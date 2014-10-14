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
	private TransparentButton updateButton;
	
	private SemiTransparentComboBox comboBox;
	private SemiTransparentTextField nameField = new SemiTransparentTextField("Produit");
	private SemiTransparentTextField priceField = new SemiTransparentTextField("Prix");
	private BufferedImage updateImage;
	private ImageButton returnButton;

	private static final String MAINPANEL = "mainPanel";
	
	public UpdateProduct(){
		
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
		
		nameField.setBorder(null);
		nameField.setFont(new Font("Arial",Font.BOLD,20));
		nameField.setBackground(Color.white);
		nameField.setSelectionColor(Colors.gray);
		nameField.setHorizontalAlignment(JTextField.CENTER);
		
		priceField.setBorder(null);
		priceField.setFont(new Font("Arial",Font.BOLD,20));
		priceField.setBackground(Color.white);
		priceField.setSelectionColor(Colors.gray);
		priceField.setHorizontalAlignment(JTextField.CENTER);

		
		contentPane.add(comboBox,"gapy 4%,h 10%, w 100%,wrap");
		contentPane.add(nameField,"gapy 1%, h 10%, w 100%,wrap");
		contentPane.add(priceField,"gapy 1%, h 10%, w 50%,wrap");
		
		this.add(header, "h 20%, w 100%, wrap");
		this.add(contentPane, "align center,h 80%, w 60%");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == returnButton){
			CardLayout cl = (CardLayout)Admin.getInstance().getLayout();
			cl.show(Admin.getInstance(), MAINPANEL);
		}

	}

}
