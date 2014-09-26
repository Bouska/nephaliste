package apps;

import java.util.HashMap;

import javax.swing.*;

import utils.sql.Requests;
import net.miginfocom.swing.MigLayout;

public class Debiter extends JPanel{

	private HashMap<String,JButton> product = new HashMap<String,JButton>();
	public Debiter(){
		
		this.setLayout(new MigLayout("insets 0 0 0 0, wrap"));
		
		PSearchBar search = new PSearchBar();
		ProductPane productPane = new ProductPane();
		
		for(int i = 0; i<Requests.getProducts(search.getSelected()).size();i++){
			product.put(Requests.getProducts(search.getSelected()).get(i),new JButton(Requests.getProducts(search.getSelected()).get(i)));
		}
		
		this.add(search,"w 100%, h 20%,wrap");
		this.add(productPane,"w 100%, h 80%");
		
		
	}
	
}
