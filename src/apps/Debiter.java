package apps;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import utils.sql.Requests;
import net.miginfocom.swing.MigLayout;

public class Debiter extends JPanel{

	private HashMap<String,JButton> products = new HashMap<String,JButton>();
	private ArrayList<String> dbProducts = new ArrayList<String>();

	private PSearchBar search;
	private ProductPane productPane;
	
	public Debiter(){
		
		
		this.setLayout(new MigLayout("insets 0 0 0 0, wrap"));
		search = new PSearchBar(this);
		productPane = new ProductPane();
		this.refreshProductsList();
		
		this.add(search,"w 100%, h 20%,wrap");
		this.add(productPane,"w 100%, h 80%");
		
		
	}
	
	
	
	public void refreshProductsList(){
		dbProducts = Requests.getProducts(search.getSelected());
		for(int i = 0; i<dbProducts.size();i++){
			products.put(dbProducts.get(i),new JButton(dbProducts.get(i)));
		}
		productPane.refreshProducts(products, dbProducts);
		
	}
	
	
}