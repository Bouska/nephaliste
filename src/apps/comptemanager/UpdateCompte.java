package apps.comptemanager;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;
import apps.*;
import utils.pane.*;

public class UpdateCompte extends JPanel implements ActionListener{
	
	
	private JLabel header = new JLabel();
	private JLabel contentPane = new JLabel();
	
	private SemiTransparentTextField fnameField = new SemiTransparentTextField("Prénom \"Surnom\" Nom");
	private SemiTransparentTextField promoField = new SemiTransparentTextField("Promo");
	private SemiTransparentTextField emailField = new SemiTransparentTextField("E-Mail");
	private SemiTransparentCheckBox coopemanField = new SemiTransparentCheckBox("Coopeman","0");
	
	private BufferedImage updateImage;
	private ImageButton returnButton;
	
	private static final String MAINPANEL = "mainComptes";
	
	public UpdateCompte(){
	
		try {
			this.updateImage = ImageIO.read(new File("./resources/img/comptes/headers/gestion.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		returnButton = new ImageButton(updateImage);
		returnButton.addActionListener(this);
		
		header.setLayout(new MigLayout());
		JLabel label = new JLabel("GESTION");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,80));
		label.setForeground(new Color(255,255,255,145));
		
		header.setBackground(Colors.blue);
		header.add(returnButton,"w 20%, h 100%");
		header.add(label,"align center,w 60%,h 100%");
		
		contentPane.setLayout(new MigLayout());
		contentPane.setBackground(Colors.blue);
		
		
		
		
		fnameField.setBorder(null);
		fnameField.setFont(new Font("Arial",Font.BOLD,20));
		fnameField.setBackground(Color.white);
		
		contentPane.add(fnameField, "gapy 2%, align center,h 10%, w 100%, wrap");
		promoField.setBorder(null);
		promoField.setFont(new Font("Arial",Font.BOLD,20));
		promoField.setBackground(Color.white);
		contentPane.add(promoField, "gapy 1%, align center,h 10%, w 100%, wrap");
		emailField.setBorder(null);
		emailField.setFont(new Font("Arial",Font.BOLD,20));
		emailField.setBackground(Color.white);
		contentPane.add(emailField, "gapy 1%, align center,h 10%, w 100%, wrap");
		contentPane.add(coopemanField, "gapy 1%, h 10%, w 50%, wrap");
		
		
		this.setLayout(new MigLayout("insets 0 0 0 0"));
		this.add(header, "w 100%, h 20%,wrap");
		this.add(contentPane,"gapx 20%,w 60%, h 80%");
		this.setBackground(Colors.blue);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == returnButton){
			CardLayout cl = (CardLayout)Compte.getInstance().getLayout();
			cl.show(Compte.getInstance(), MAINPANEL);
		}
	}
	
	public void update(){
		fnameField.setText(Client.getNom());
		promoField.setText(Client.getPromo());
		emailField.setText(Client.getEmail());
		boolean state;
		if(Client.getCoopeman().equals("1")){
			state = true;
		}
		else{
			state = false;
		}
		coopemanField.setSelected(state);
	}
	
}
