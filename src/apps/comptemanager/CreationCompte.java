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
import apps.FicheClient;
import utils.pane.*;
import utils.sql.Requests;
import net.miginfocom.swing.MigLayout;

public class CreationCompte extends JPanel implements ActionListener{
	
	private TransparentButton createButton;
	private JPanel header = new JPanel();
	private SemiTransparentTextField fnameField = new SemiTransparentTextField("Prénom");
	private SemiTransparentTextField snameField = new SemiTransparentTextField("Surnom");
	private SemiTransparentTextField nnameField = new SemiTransparentTextField("Nom");
	private SemiTransparentTextField promoField = new SemiTransparentTextField("Promo");
	private SemiTransparentTextField emailField = new SemiTransparentTextField("E-Mail");
	private BufferedImage createImage;
	private ImageButton returnButton;
	private FicheClient fc;
	
	private static final String MAINPANEL = "mainComptes";

	public CreationCompte(){
		
		try {
			this.createImage = ImageIO.read(new File("./resources/img/comptes/headers/creation.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		returnButton = new ImageButton(createImage);
		returnButton.addActionListener(this);
		
		header.setLayout(new MigLayout());
		JLabel label = new JLabel("CREATION");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,80));
		label.setForeground(new Color(255,255,255,145));
		
		header.setBackground(Colors.compteBlue);
		header.add(returnButton,"w 20%, h 100%");
		header.add(label,"align center,w 60%,h 100%");
		
		this.setLayout(new MigLayout("insets 0 0 0 0"));
		
		this.add(header, "w 100%, h 20%,wrap");
		
		fnameField.setBorder(null);
		fnameField.setFont(new Font("Arial",Font.BOLD,20));
		fnameField.setBackground(Color.white);
		fnameField.setSelectionColor(Colors.compteBlue);
		fnameField.setHorizontalAlignment(JTextField.CENTER);
		this.add(fnameField, "gapy 2%, align center,h 10%, w 70%, wrap");
		nnameField.setBorder(null);		
		nnameField.setFont(new Font("Arial",Font.BOLD,20));
		nnameField.setBackground(Color.white);
		nnameField.setSelectionColor(Colors.compteBlue);
		nnameField.setHorizontalAlignment(JTextField.CENTER);

		this.add(nnameField, "gapy 1%, align center,h 10%, w 70%, wrap");
		snameField.setBorder(null);
		snameField.setFont(new Font("Arial",Font.BOLD,20));
		snameField.setBackground(Color.white);
		snameField.setSelectionColor(Colors.compteBlue);
		snameField.setHorizontalAlignment(JTextField.CENTER);

		this.add(snameField, "gapy 1%, align center,h 10%, w 70%, wrap");
		promoField.setBorder(null);
		promoField.setFont(new Font("Arial",Font.BOLD,20));
		promoField.setBackground(Color.white);
		promoField.setSelectionColor(Colors.compteBlue);
		promoField.setHorizontalAlignment(JTextField.CENTER);

		this.add(promoField, "gapy 1%, align center,h 10%, w 70%, wrap");
		emailField.setBorder(null);
		emailField.setFont(new Font("Arial",Font.BOLD,20));
		emailField.setBackground(Color.white);
		emailField.setSelectionColor(Colors.compteBlue);
		emailField.setHorizontalAlignment(JTextField.CENTER);

		this.add(emailField, "gapy 1%, align center,h 10%, w 70%, wrap");
		
		createButton = new TransparentButton("Créer le Compte");
		createButton.setBorderPainted(false);
		createButton.setFont(new Font("Arial",Font.BOLD,30));
		createButton.setBackground(Color.white);
		createButton.setForeground(Colors.compteBlue);
		createButton.addActionListener(this);
		this.add(createButton, "gapx 25%, gapy 2% , h 10%, w 50%");
		this.setBackground(Colors.compteBlue);
	}
	
	public void update(){
		this.fnameField.setText("Prénom");
		this.nnameField.setText("Surnom");
		this.snameField.setText("Nom");
		this.promoField.setText("Promo");
		this.emailField.setText("E-Mail");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == createButton){
			Requests.createNewClient(fnameField.getText(),snameField.getText(),nnameField.getText(),Integer.parseInt(promoField.getText()), emailField.getText());
			fc = FicheClient.getInstance();
			fc.updateAutocompleter();
			update();
		}
		else if(arg0.getSource() == returnButton){
			CardLayout cl = (CardLayout)Compte.getInstance().getLayout();
			cl.show(Compte.getInstance(), MAINPANEL);
		}
	}
}

