package apps;

import java.awt.Color;
import java.awt.Font;
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
import utils.pane.SemiTransparentScrollBar;
import utils.sql.Requests;
import net.miginfocom.swing.MigLayout;

public class Debiter extends JPanel implements IAppPanel{

	private HashMap<String,JButton> products = new HashMap<String,JButton>();
	private ArrayList<String> dbProducts = new ArrayList<String>();
	private BufferedImage thumbnail;
	private PSearchBar search;
	private ProductPane productPane;
	private JPanel header = new JPanel();
	private JScrollPane scrollPane;
	
	public Debiter(){
		
		
		try {
			this.thumbnail=ImageIO.read(new File("./resources/img/debiter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setLayout(new MigLayout("insets 0 0 0 0, wrap"));
		search = new PSearchBar(this);
		productPane = new ProductPane();
		this.refreshProductsList();
		
		JLabel label = new JLabel("DEBITER");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,80));
		label.setForeground(new Color(255,255,255,145));
		header.setBackground(new Color(237,31,36));
		header.add(label,"align center,w 100%,h 100%");
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(productPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(null);
		scrollPane.getVerticalScrollBar().setUI(new SemiTransparentScrollBar(new Color(237,31,36)));
		
		
		this.add(header, "w 100%, h 10%, wrap");
		this.add(search,"gapx 10%, gapy 5%, w 80%, h 15%,wrap");
		this.add(scrollPane,"gapx 7%, gapy 5%, w 90%, h 55%");
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