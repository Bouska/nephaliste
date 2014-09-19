package apps;
import java.util.ArrayList;

import javax.swing.*;

import utils.sql.Requests;

import net.miginfocom.swing.MigLayout;
public class ProductPane extends JPanel{
	
	
	public ProductPane(){
		this.setLayout(new MigLayout("insets 0 0 0 0"));
		this.add(new JLabel("Produits"),"h 10%, w 30%");
		
	}
}
