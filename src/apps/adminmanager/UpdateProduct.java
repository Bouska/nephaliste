package apps.adminmanager;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import apps.*;
import utils.pane.Colors;
import utils.pane.ImageButton;
import utils.pane.SemiTransparentComboBox;
import utils.pane.SemiTransparentTextField;
import utils.pane.TransparentButton;
import utils.sql.Requests;

public class UpdateProduct extends JPanel implements ActionListener{
	
	private JPanel header = new JPanel();
	private JPanel contentPane = new JPanel();
	private TransparentButton updateButton = new TransparentButton("Mettre à Jour");
	private TransparentButton deleteButton = new TransparentButton("Supprimer");
	
	private SemiTransparentComboBox comboBox;
	private SemiTransparentTextField nameField = new SemiTransparentTextField("Produit");
	private SemiTransparentTextField priceField = new SemiTransparentTextField("Prix");
	private BufferedImage updateImage;
	private ImageButton returnButton;

	private static final String MAINPANEL = "mainPanel";
	
	private UpdateProduct(){
		
		try {
			this.updateImage = ImageIO.read(new File("./resources/img/admin/headers/update.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		returnButton = new ImageButton(updateImage);
		returnButton.addActionListener(this);
		
		this.setLayout(new MigLayout());
		header.setLayout(new MigLayout());
		contentPane.setLayout(new MigLayout());

		JLabel label = new JLabel("GESTION");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,80));
		label.setForeground(new Color(255,255,255,145));

		header.setBackground(Colors.gray);
		contentPane.setBackground(Colors.gray);
		this.setBackground(Colors.gray);
		
		
		header.add(returnButton, "h 100%, w 20%");
		header.add(label, "align center, h 100%, w 60%");
		
		ArrayList<String> dbProd = Requests.getProducts("");
		Collections.sort(dbProd);
		comboBox = new SemiTransparentComboBox(dbProd.toArray(),Colors.lightGray);
		comboBox.setFont(new Font("Arial",Font.BOLD,20));
		comboBox.addActionListener(this);
		
		nameField.setBorder(null);
		nameField.setFont(new Font("Arial",Font.BOLD,20));
		nameField.setBackground(Color.white);
		nameField.setSelectionColor(Colors.gray);
		
		priceField.setBorder(null);
		priceField.setFont(new Font("Arial",Font.BOLD,20));
		priceField.setBackground(Color.white);
		priceField.setSelectionColor(Colors.gray);

		
		contentPane.add(comboBox,"align center,gapy 4%,h 10%, w 90%,wrap");
		contentPane.add(nameField,"align center,gapy 1%, h 10%, w 90%,wrap");
		JPanel disp = new JPanel(new MigLayout("insets 0 0 0 0"));
		disp.setBackground(Colors.gray);
		disp.add(priceField,"h 100%, w 50%");
		disp.add(new JLabel(" €"){{
			setFont(new Font("Arial",Font.BOLD,30));
			setForeground(new Color(255,255,255,145));
			setVerticalAlignment(JTextField.CENTER);
		}},"h 10%, w 20%,wrap");
		contentPane.add(disp,"align center,gapy 1%, h 10%, w 90%,wrap");
		
		updateButton.setBorderPainted(false);
		updateButton.setFont(new Font("Arial",Font.BOLD,30));
		updateButton.setBackground(Color.white);
		updateButton.setForeground(Colors.gray);
		updateButton.addActionListener(this);
		
		deleteButton.setBorderPainted(false);
		deleteButton.setFont(new Font("Arial",Font.BOLD,30));
		deleteButton.setBackground(Color.white);
		deleteButton.setForeground(Colors.gray);
		deleteButton.addActionListener(this);
		
		
		JPanel disp2 = new JPanel(new MigLayout("insets 0 0 0 0"));
		disp2.setBackground(Colors.gray);
		disp2.add(updateButton,"h 100%, w 48%");
		disp2.add(deleteButton,"h 100%, w 48%,gapx 4%");
		contentPane.add(disp2,"align center,gapy 5%, h 10%, w 70%");

		this.add(header, "h 20%, w 100%, wrap");
		this.add(contentPane, "align center,h 80%, w 70%,wrap");
	}
	
	private static class SingletonHolder{
		public static UpdateProduct INSTANCE = new UpdateProduct();
	}
	public static UpdateProduct getInstance(){
		return SingletonHolder.INSTANCE;
	}
	
	public void update(){
		ArrayList<String> dbProd = Requests.getProducts("");
		Collections.sort(dbProd);
		comboBox.updateList(dbProd.toArray());
		comboBox.setSelectedIndex(0);
		this.nameField.setText("Produit");
		this.priceField.setText("Prix");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == returnButton){
			CardLayout cl = (CardLayout)Admin.getInstance().getLayout();
			cl.show(Admin.getInstance(), MAINPANEL);
		}
		else if(arg0.getSource() == comboBox){
			this.nameField.setText((String)comboBox.getSelectedItem());
			this.priceField.setText(""+Requests.getProductPrice((String)comboBox.getSelectedItem()));
		}
		else if(arg0.getSource() == updateButton){
			Requests.updateProduct((String)comboBox.getSelectedItem(), this.nameField.getText(), Float.parseFloat(this.priceField.getText()));
			Debiter.getInstance().update();
			update();
		}
		else if(arg0.getSource() == deleteButton){
			Requests.deleteProduct((String)comboBox.getSelectedItem());
			Debiter.getInstance().update();
			update();
		}
	}

}
