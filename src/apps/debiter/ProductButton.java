package apps.debiter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import apps.Client;
import apps.FicheClient;
import utils.sql.Requests;

public class ProductButton extends JButton implements ActionListener{
	
	
	private FicheClient fclient;
	public ProductButton(String arg0){
		super(arg0);
		this.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(Client.isInit()){
			fclient = FicheClient.getInstance();
			double price = Requests.getProductPrice(this.getText());
			String solde = Client.getSolde();
			double amount = Double.parseDouble(solde) - price;
			if((amount > 0)||(Client.getCoopeman().equals("1"))){
				Requests.setClientSolde(Client.getNom(), "-" + price);
				fclient.updateClient(Client.getNom());
			}
			else{
			 // A COMPLETER
			}
		}
	}
}
