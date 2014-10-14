package apps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import utils.pane.Colors;
import utils.pane.IAppPanel;
import utils.pane.ImageButton;
import utils.pane.SemiTransparentScrollBar;
import utils.sql.Requests;
import net.miginfocom.swing.MigLayout;

public class Debiter extends JPanel implements IAppPanel,ActionListener{

	private HashMap<String,JButton> products = new HashMap<String,JButton>();
	private ArrayList<String> dbProducts = new ArrayList<String>();
	private BufferedImage thumbnail;
	private PSearchBar search;
	private ProductPane productPane;
	private JPanel header = new JPanel();
	private JScrollPane scrollPane;
	private BufferedImage debiterHeader;
	private ImageButton returnButton;
	
	private Debiter(){
		
		
		try {
			debiterHeader=ImageIO.read(new File("./resources/img/headers/debiter.png"));
			this.thumbnail=ImageIO.read(new File("./resources/img/debiter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		returnButton = new ImageButton(debiterHeader);
		returnButton.addActionListener(this);
		this.setLayout(new MigLayout("insets 0 0 0 0, wrap"));
		search = new PSearchBar(this);
		productPane = new ProductPane();
		this.refreshProductsList();
		
		JLabel label = new JLabel("DEBITER");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,80));
		label.setForeground(new Color(255,255,255,145));
		header.setBackground(Colors.red);
		header.setLayout(new MigLayout());
		header.add(returnButton,"w 20%, h 100%");
		header.add(label,"align center,w 60%,h 100%");
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(productPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBorder(null);
		scrollPane.getVerticalScrollBar().setUI(new SemiTransparentScrollBar(Colors.red));
		scrollPane.setMaximumSize(new Dimension(1500,1500));
		
		this.add(header, "w 100%, h 20%, wrap");
		this.add(search,"gapx 10%, w 80%, h 15%,wrap");
		this.add(scrollPane,"gapx 7%, gapy 5%, w 90%, h 55%");
		search.setBackground(Colors.red);
		productPane.setBackground(Colors.darkRed);
		this.setBackground(Colors.red);
		
	}
	

	private static class SingletonHolder{
		public static final Debiter INSTANCE = new Debiter();	
	}
	public static Debiter getInstance(){
		return SingletonHolder.INSTANCE;
	}
	
	
	
	public void refreshProductsList(){
		if(!search.getSelected().equals("")){
			products.clear();
			dbProducts = Requests.getProducts(search.getSelected());
			for(int i = 0; i<dbProducts.size();i++){
				products.put(dbProducts.get(i),new ProductButton(dbProducts.get(i)));
			}
			productPane.refreshProducts(products, dbProducts);
		}
		else{
			productPane.deleteProducts();
		}
	}



	@Override
	public BufferedImage getThumbnail() {
		// TODO Auto-generated method stub
		return this.thumbnail;
	}



	@Override
	public void update() {
		// TODO Auto-generated method stub
		refreshProductsList();
		search.update();
	}



	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return this;
	}



	@Override
	public JButton getReturnButton() {
		// TODO Auto-generated method stub
		return returnButton;
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == returnButton){
			search.deselect();
		}
	}
	
	
}