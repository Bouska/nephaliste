package apps.comptemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import utils.pane.IAppPanel;
import utils.pane.SemiTransparentTextField;
import utils.sql.Requests;
import net.miginfocom.swing.MigLayout;

public class CreationCompte extends JPanel implements ActionListener, IAppPanel{
	
	private JButton createButton;
	private SemiTransparentTextField fnameField = new SemiTransparentTextField("Prénom");
	private SemiTransparentTextField snameField = new SemiTransparentTextField("Surnom");
	private SemiTransparentTextField nnameField = new SemiTransparentTextField("Nom");
	private SemiTransparentTextField promoField = new SemiTransparentTextField("Promo");
	private SemiTransparentTextField emailField = new SemiTransparentTextField("E-Mail");

	private BufferedImage thumbnail;
	
	public CreationCompte(){
		this.setLayout(new MigLayout("insets 0 0 0 0"));
		
		this.add(fnameField, "gapx 15%, gapy 2%, align center,h 15%, w 70%, wrap");
		
		this.add(nnameField, "gapx 15%,align center,h 15%, w 70%, wrap");
		
		this.add(snameField, "gapx 15%,align center,h 15%, w 70%, wrap");
		
		this.add(promoField, "gapx 15%,align center,h 15%, w 70%, wrap");
		
		this.add(emailField, "gapx 15%,align center,h 15%, w 70%, wrap");
		
		createButton = new JButton("Créer le Compte");
		createButton.addActionListener(this);
		this.add(createButton, "gapx 25%, gapy 2% , h 10%, w 50%");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == createButton){
			Requests.createNewClient(fnameField.getText(),snameField.getText(),nnameField.getText(),Integer.parseInt(promoField.getText()), emailField.getText());
		}
	}

	@Override
	public BufferedImage getThumbnail() {
		// TODO Auto-generated method stub
		return this.thumbnail;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public JButton getReturnButton() {
		// TODO Auto-generated method stub
		return new JButton();
	}
}

