package apps.comptemanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import utils.pane.IAppPanel;
import utils.sql.Requests;
import net.miginfocom.swing.MigLayout;

public class CreationCompte extends JPanel implements ActionListener, IAppPanel{
	
	private JButton createButton;
	private JTextField fnameField = new JTextField();
	private JTextField snameField = new JTextField();
	private JTextField nnameField = new JTextField();
	private JTextField promoField = new JTextField();
	private JCheckBox coopemanCheck = new JCheckBox();
	private BufferedImage thumbnail;
	
	public CreationCompte(){
		this.setLayout(new MigLayout("insets 0 0 0 0, wrap 2"));
		
		this.add(new JLabel("Prenom : "),"h 10%, w 30%");
		this.add(fnameField, "h 10%, w 70%");
		
		this.add(new JLabel("Surnom : "),"h 10%, w 30%");
		this.add(nnameField, "h 10%, w 70%");
		
		this.add(new JLabel("Nom : "),"h 10%, w 30%");
		this.add(snameField, "h 10%, w 70%");
		
		this.add(new JLabel("Promo : "),"h 10%, w 30%");
		this.add(promoField, "h 10%, w 70%");
		
		this.add(new JLabel("Coopeman : "), "h 10%, w 30%");
		this.add(coopemanCheck, "h 10%, w 70%");
		
		createButton = new JButton("Créer le Compte");
		createButton.addActionListener(this);
		this.add(createButton, "align center");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == createButton){
			System.out.println("" + fnameField.getText() + "\n" + snameField.getText() + "\n" + nnameField.getText() + "\n" + Integer.parseInt(promoField.getText()) + "\n" + coopemanCheck.isSelected());
			//Requests.createNewClient(fnameField.getText(),snameField.getText(),nnameField.getText(),Integer.parseInt(promoField.getText()),coopemanCheck.isSelected());
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
}

