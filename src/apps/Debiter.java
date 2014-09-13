package apps;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class Debiter extends JPanel{

	private HashMap<JButton, String> product = new HashMap<JButton, String>();
	
	public Debiter(){
		this.setLayout(new MigLayout("insets 0 0 0 0, wrap"));
		PSearchBar search = new PSearchBar();
		ProductPane productPane = new ProductPane();
		this.add(search,"center");
		this.add(productPane,"w 100%, h 100%");
		
		
	}
	
}
