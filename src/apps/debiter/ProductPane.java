package apps.debiter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class ProductPane extends JPanel{
	
	public ProductPane(){
		this.setLayout(new MigLayout("insets 0 0 0 0, wrap 3, w 100%"));
	}
	
	public void refreshProducts(HashMap<String, JButton> hashProd, ArrayList<String> dbProd){
		this.removeAll();
		for(int i = 0; i < dbProd.size(); i++){
			this.add(hashProd.get(dbProd.get(i)), "h 40%, w 33%, gapx 1%, gapy 1%");
		}
		this.repaint();
		this.revalidate();
	}
}
