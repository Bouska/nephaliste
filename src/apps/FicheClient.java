package apps;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utils.pane.AccountAutoCompleter;
import utils.pane.ImagePanel;
import utils.sql.DataBaseInterface;
import utils.sql.Requests;
import net.miginfocom.swing.MigLayout;

public class FicheClient extends JPanel {
	
	private JTextField textSearch = new JTextField(30);
	private ArrayList<String> names ;
	private BufferedImage search_img;
	private BufferedImage coopeman_img;
	private BufferedImage nonCoopeman_img;
	private DataBaseInterface database = new DataBaseInterface();
	private AccountAutoCompleter autocompleter;
	private ImagePanel coopeman;
	private ImagePanel search;
	private JPanel photo = new JPanel();
	private JLabel nom = new JLabel("Client");
	private JLabel solde = new JLabel("Solde");
	private JLabel promo = new JLabel("PROMO");
	public static String client = "";
	private FicheClient()
	{	
		try {
			loadImages();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initComponents();
		createPanels();	
	}
	
	private static class SingletonHolder{
			public static final FicheClient INSTANCE = new FicheClient();	
	}
	public static FicheClient getInstance(){
		return SingletonHolder.INSTANCE;
	}
	
	private void initComponents()
	{
		this.setBackground(new Color(61,61,61));
		Font font = new Font("Arial",Font.PLAIN,17);
		nom.setHorizontalAlignment(SwingConstants.CENTER);
		nom.setVerticalAlignment(SwingConstants.CENTER);
		nom.setFont(font);
		nom.setForeground(Color.white);
		promo.setHorizontalAlignment(SwingConstants.CENTER);
		promo.setVerticalAlignment(SwingConstants.CENTER);
		promo.setFont(new Font("Arial",Font.PLAIN,25));
		promo.setForeground(Color.white);
		solde.setBorder(BorderFactory.createLineBorder(Color.white));
		solde.setHorizontalAlignment(SwingConstants.CENTER);
		solde.setVerticalAlignment(SwingConstants.CENTER);
		solde.setFont(new Font("Arial",Font.BOLD,25));
		solde.setForeground(Color.white);
		
		
		
		
		search = new ImagePanel(search_img);
		coopeman = new ImagePanel(nonCoopeman_img);
		//names = database.readRequest("SELECT nom FROM comptes WHERE promo > 2011 AND ouvert=1");
		autocompleter = new AccountAutoCompleter(this.textSearch, names,this);
		photo.setBackground(new Color(125,187,162));
		coopeman.setBackground(new Color(61,61,61));

	}
	private void createPanels()
	{

		setLayout(new MigLayout());
		JPanel searchBar = new JPanel();
		searchBar.setLayout(new MigLayout("insets 0 0 0 0"));
		searchBar.add(textSearch,"w 80%,h 100%");
		searchBar.add(search,"w 20%,h 100%");
		searchBar.setBackground(new Color(61,61,61));
	
		add(searchBar,"w 100%,h 6%,wrap");
		
		add(photo,"w 100%,h 35%,wrap");
		JPanel imageCoopeman = new JPanel();
		imageCoopeman.setBackground(new Color(61,61,61));
		imageCoopeman.setLayout(new MigLayout(""));
	
		
		imageCoopeman.add(coopeman,"w 100%,h 100%");
		
		add(imageCoopeman,"align center,w 30% ,h 10%,wrap");
		add(nom,"align center,w 100%,h 5%,wrap");
		add(promo,"align center,w 100%,h 5%,wrap");
		add(solde,"gapy 20%,align center,w 90%,h 10%");
	}
	private void loadImages() throws IOException
	{
		search_img = ImageIO.read(new File("./resources/img/recherche.png"));
		coopeman_img = ImageIO.read(new File("./resources/img/coopemanpetit.png"));
		nonCoopeman_img = ImageIO.read(new File("./resources/img/NonCoopeman.png"));
	}
	public void updateClient(String client)
	{
		Client.setClient(client);
		nom.setText(client);
		this.promo.setText(Client.getPromo());
		this.solde.setText(Client.getSolde()+" €");
		if(Double.parseDouble(Client.getSolde())<0)
		{
			this.solde.setBorder(BorderFactory.createLineBorder(Color.red,2));
			this.solde.setForeground(Color.red);
		}
		else
		{
			this.solde.setBorder(BorderFactory.createLineBorder(Color.green,2));
			this.solde.setForeground(Color.green);
		}
		if(Client.getCoopeman().equals("1"))
		{
			this.coopeman.setImage(coopeman_img);
		}
		else
		{
			this.coopeman.setImage(nonCoopeman_img);
		}
	}

}
