package apps.debiter;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.swing.*;

import utils.sql.Requests;
import apps.Debiter;
import net.miginfocom.swing.MigLayout;

public class PSearchBar extends JPanel implements ActionListener{
	
	private HashSet<String> letters = new HashSet<String>();
	private ArrayList<String> dbProducts;
	private ArrayList<LetterButton> letterButtons = new ArrayList<LetterButton>();
	public LetterButton L;
	private Debiter dPanel;
	
	
	public PSearchBar(Debiter dPanel){
			
		this.dPanel = dPanel;
		MigLayout layout = new MigLayout("insets 0 0 0 0, wrap 6");
		this.setLayout(layout);
		update();
	}
	
	public void update(){
		if(!letters.isEmpty() || !letterButtons.isEmpty()){
			this.removeAll();
			letters.clear();
			letterButtons.clear();
		}
		dbProducts = Requests.getProducts("");
		Collections.sort(dbProducts);
		for(int i = 0; i < dbProducts.size(); i++){
			if(letters.contains(""+dbProducts.get(i).charAt(0)) != true ){
				letters.add(""+dbProducts.get(i).charAt(0));
				String c = "" + dbProducts.get(i).charAt(0);
				letterButtons.add(new LetterButton(c.toUpperCase()));
				letterButtons.get(letterButtons.size()-1).addActionListener(this);
				this.add(letterButtons.get(letterButtons.size()-1), "w 20%, h 30%");
			}
		}
	}
	
	public String getSelected(){
		if(L == null){
			return "";
		}
		else{
			return L.getText();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(L != null){
			L.setSelected(false);
		}
		if((LetterButton)arg0.getSource() != L){
			L = (LetterButton)arg0.getSource();

		}
		else{
			L = null;
		}
		
		this.dPanel.refreshProductsList();
		
	}
	
}
