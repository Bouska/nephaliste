package apps.debiter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import utils.sql.Requests;

public class ProductButton extends JButton implements ActionListener{

	public ProductButton(String arg0){
		super(arg0);
		this.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		double price = Requests.getProductPrice(this.getText());
		double solde = Requests.getClientSolde(client);
		if((solde - price > 0)||(Requests.getCoopeman(client) == 1)){
			Requests.setClientSolde(client, price);
		}
		else{
			
		}
	}
	
	
	
}
