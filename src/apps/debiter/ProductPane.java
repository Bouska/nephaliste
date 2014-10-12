package apps.debiter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class ProductPane extends JPanel{
	
	public ProductPane(){
		this.setLayout(new MigLayout("insets 0 0 0 0, wrap 4, w 100%"));
	}
	
	public void refreshProducts(HashMap<String, JButton> hashProd, ArrayList<String> dbProd){
		this.removeAll();
		for(int i = 0; i < dbProd.size(); i++){
			if(i > 3){
				this.add(hashProd.get(dbProd.get(i)), "h 180px, w 22%, gapx 2%, gapy 1%");
			}
			else{
				this.add(hashProd.get(dbProd.get(i)), "h 180px, w 22%, gapx 2%");
			}
		}
		this.repaint();
		this.revalidate();
	}
}
