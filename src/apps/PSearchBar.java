package apps;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class PSearchBar extends JPanel implements ActionListener{
	
	private HashMap<String,LetterButton> letters = new HashMap<String,LetterButton>();
	public LetterButton L;
	private Debiter dPanel;
	public PSearchBar(Debiter dPanel){
			
		this.dPanel = dPanel;
		MigLayout layout = new MigLayout("insets 0 0 0 0");
		this.setLayout(layout);
		for(int i = 1; i <= 26; i++){
			letters.put(new String(Character.toString((char)(i+64))),new LetterButton(new String(Character.toString((char)(i+64)))));	
			letters.get(Character.toString((char)(i+64))).addActionListener(this);
			if(i%6==0)
			{
				this.add(letters.get(Character.toString((char)(i+64))), "w 20%,wrap");
			}
			else
			{
				this.add(letters.get(Character.toString((char)(i+64))), "w 20%");
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
			letters.get(L.getText()).setSelected(false);
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
