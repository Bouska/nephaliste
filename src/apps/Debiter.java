package apps;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.*;

import apps.debiter.PSearchBar;
import apps.debiter.ProductButton;
import apps.debiter.ProductPane;
import utils.pane.IAppPanel;
import utils.sql.Requests;
import net.miginfocom.swing.MigLayout;

public class Debiter extends JPanel implements IAppPanel{

	private HashMap<String,JButton> products = new HashMap<String,JButton>();
	private ArrayList<String> dbProducts = new ArrayList<String>();
	private BufferedImage thumbnail;
	private PSearchBar search;
	private ProductPane productPane;
	
	public Debiter(String img) throws IOException{
		
		this.thumbnail = ImageIO.read(new File(img));
		this.setLayout(new MigLayout("insets 0 0 0 0, wrap"));
		search = new PSearchBar(this);
		productPane = new ProductPane();
		this.refreshProductsList();
		
		this.add(search,"w 100%, h 20%,wrap");
		this.add(productPane,"w 100%, h 80%");
		search.setBackground(new Color(237,31,36));
		productPane.setBackground(new Color(237,31,36));
		this.setBackground(new Color(237,31,36));
		
	}
	
	
	
	public void refreshProductsList(){
		dbProducts = Requests.getProducts(search.getSelected());
		for(int i = 0; i<dbProducts.size();i++){
			products.put(dbProducts.get(i),new ProductButton(dbProducts.get(i)));
		}
		productPane.refreshProducts(products, dbProducts);
		
	}



	@Override
	public BufferedImage getThumbnail() {
		// TODO Auto-generated method stub
		return this.thumbnail;
	}



	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return this;
	}
	
	
}