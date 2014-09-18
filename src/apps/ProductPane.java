package apps;
import javax.swing.*;

import utils.sql.Requests;

import net.miginfocom.swing.MigLayout;
public class ProductPane extends JPanel{
	
	public ProductPane(){
		Requests requests = new Requests();
		this.setLayout(new MigLayout("insets 0 0 0 0"));
		this.add(new JLabel("Produits"));
		String test = requests.getProduct("");
		this.add(new JButton(test));
	}
}
