package utils.pane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;






import utils.sql.DataBaseInterface;
import net.miginfocom.swing.MigLayout;




public class SearchPanel extends JPanel {
	private JLabel labelSearch = new JLabel("Rechercher :", JLabel.CENTER);
	private JTextField textSearch = new JTextField(30);
	private JButton buttonAddToOrder = new JButton("Ajouter à la commande");
	private ArrayList<String> names = new ArrayList<String>();
	public SearchPanel()
	{
		super();

//		this.buttonAddToOrder.addActionListener(this);
		DataBaseInterface inter = new DataBaseInterface();
		names = inter.readRequest("SELECT nom FROM comptes WHERE promo > 2011 AND ouvert=1");
		new AccountAutoCompleter(this.textSearch, names);

		Font police = new Font("Arial", Font.PLAIN, 16);
		this.textSearch.setFont(police);
		this.textSearch.setForeground(Color.BLACK);
		
		this.setLayout(new MigLayout());
		this.add(this.labelSearch, "h 80%, w 15%, gapleft 6%");
		this.add(this.textSearch, "h 60%, w 46%, gapright 3%");
		this.add(this.buttonAddToOrder, "h 60%, w 24%, gapright 6%");		
	}


	
	
}
