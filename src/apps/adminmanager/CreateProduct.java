package apps.adminmanager;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import apps.*;
import utils.pane.Colors;
import utils.pane.ImageButton;
import utils.pane.SemiTransparentTextField;
import utils.pane.TransparentButton;
import utils.sql.Requests;

public class CreateProduct extends JPanel implements ActionListener{
	
	private JPanel header = new JPanel();
	private JPanel contentPane = new JPanel();
	private TransparentButton createButton;
	
	private SemiTransparentTextField nameField = new SemiTransparentTextField("Nom");
	private SemiTransparentTextField priceField = new SemiTransparentTextField("Prix");
	
	private BufferedImage createImage;
	private ImageButton returnButton;

	private static final String MAINPANEL = "mainPanel";
	
	public CreateProduct(){
		
		try {
			this.createImage = ImageIO.read(new File("./resources/img/admin/headers/create.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		returnButton = new ImageButton(createImage);
		returnButton.addActionListener(this);
		
		this.setLayout(new MigLayout("insets 0 0 0 0"));
		header.setLayout(new MigLayout());
		contentPane.setLayout(new MigLayout());

		JLabel label = new JLabel("CREATION");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,80));
		label.setForeground(new Color(255,255,255,145));

		header.setBackground(Colors.gray);
		contentPane.setBackground(Colors.gray);
		this.setBackground(Colors.gray);
		
		header.add(returnButton, "h 100%, w 20%");
		header.add(label, "align center, h 100%, w 60%");
		
		
		nameField.setBorder(null);
		nameField.setFont(new Font("Arial",Font.BOLD,20));
		nameField.setBackground(Color.white);
		nameField.setSelectionColor(Colors.gray);
		
		priceField.setBorder(null);
		priceField.setFont(new Font("Arial",Font.BOLD,20));
		priceField.setBackground(Color.white);
		priceField.setSelectionColor(Colors.gray);
		
		createButton = new TransparentButton("Créer le Produit");
		createButton.setBorderPainted(false);
		createButton.setFont(new Font("Arial",Font.BOLD,30));
		createButton.setBackground(Color.white);
		createButton.setForeground(Colors.gray);
		createButton.addActionListener(this);
		
		contentPane.add(nameField, "gapy 10%,h 10%, w 100%, wrap");
		contentPane.add(priceField, "gapy 1%, h 10%, w 50%, wrap");
		contentPane.add(createButton, "gapx 25%, gapy 4% , h 10%, w 50%");

		
		this.add(header, "h 20%, w 100%, wrap");
		this.add(contentPane, "align center, h 80%, w 60%");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == createButton && !Requests.getProducts(" ").contains(nameField.getText())){
			Requests.createNewProduct(nameField.getText(), Float.parseFloat(priceField.getText()));
			Debiter.getInstance().update();
		}
		else if(arg0.getSource() == returnButton){
			CardLayout cl = (CardLayout)Admin.getInstance().getLayout();
			cl.show(Admin.getInstance(), MAINPANEL);
		}

	}

}
