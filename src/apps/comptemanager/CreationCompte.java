package apps.comptemanager;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import apps.Compte;
import utils.pane.Colors;
import utils.pane.ImageButton;
import utils.pane.SemiTransparentTextField;
import utils.sql.Requests;
import net.miginfocom.swing.MigLayout;

public class CreationCompte extends JPanel implements ActionListener{
	
	private JButton createButton;
	private JPanel header = new JPanel();
	private SemiTransparentTextField fnameField = new SemiTransparentTextField("Prénom");
	private SemiTransparentTextField snameField = new SemiTransparentTextField("Surnom");
	private SemiTransparentTextField nnameField = new SemiTransparentTextField("Nom");
	private SemiTransparentTextField promoField = new SemiTransparentTextField("Promo");
	private SemiTransparentTextField emailField = new SemiTransparentTextField("E-Mail");
	private Compte parent;
	private BufferedImage thumbnail;
	private BufferedImage createImage;
	private ImageButton returnButton;
	
	private static final String MAINPANEL = "mainComptes";

	public CreationCompte(Compte parent){
		
		try {
			this.createImage = ImageIO.read(new File("./resources/img/comptes/creation.png"));
			this.thumbnail=ImageIO.read(new File("./resources/img/comptes.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.parent = parent;
		
		returnButton = new ImageButton(createImage);
		returnButton.addActionListener(this);
		
		header.setLayout(new MigLayout());
		JLabel label = new JLabel("CREATION");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,80));
		label.setForeground(new Color(255,255,255,145));
		
		header.setBackground(Colors.blue);
		header.add(returnButton,"w 20%, h 100%");
		header.add(label,"align center,w 60%,h 100%");
		
		this.setLayout(new MigLayout("insets 0 0 0 0"));
		
		this.add(header, "w 100%, h 20%,wrap");
		
		fnameField.setBorder(null);
		fnameField.setFont(new Font("Arial",Font.BOLD,20));
		fnameField.setBackground(Color.white);
		this.add(fnameField, "gapy 2%, align center,h 10%, w 70%, wrap");
		nnameField.setBorder(null);		
		nnameField.setFont(new Font("Arial",Font.BOLD,20));
		nnameField.setBackground(Color.white);
		this.add(nnameField, "align center,h 10%, w 70%, wrap");
		snameField.setBorder(null);
		snameField.setFont(new Font("Arial",Font.BOLD,20));
		snameField.setBackground(Color.white);
		this.add(snameField, "align center,h 10%, w 70%, wrap");
		promoField.setBorder(null);
		promoField.setFont(new Font("Arial",Font.BOLD,20));
		promoField.setBackground(Color.white);
		this.add(promoField, "align center,h 10%, w 70%, wrap");
		emailField.setBorder(null);
		emailField.setFont(new Font("Arial",Font.BOLD,20));
		emailField.setBackground(Color.white);
		this.add(emailField, "align center,h 10%, w 70%, wrap");
		
		createButton = new JButton("Créer le Compte");
		createButton.addActionListener(this);
		this.add(createButton, "gapx 25%, gapy 2% , h 10%, w 50%");
		this.setBackground(Colors.blue);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == createButton){
			Requests.createNewClient(fnameField.getText(),snameField.getText(),nnameField.getText(),Integer.parseInt(promoField.getText()), emailField.getText());
		}
		else if(arg0.getSource() == returnButton){
			CardLayout cl = (CardLayout)this.parent.getLayout();
			cl.show(this.parent, MAINPANEL);
		}
	}
}

