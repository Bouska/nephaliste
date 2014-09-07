package apps;

import java.util.HashMap;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class Debiter extends JPanel{

	private HashMap<JButton, String> product = new HashMap<JButton, String>();
	
	public Debiter(){
		this.setLayout(new MigLayout());
		PSearchBar search = new PSearchBar();
		this.add(search,"center");
		
	}
	
}
