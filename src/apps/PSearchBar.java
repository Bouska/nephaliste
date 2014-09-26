package apps;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class PSearchBar extends JPanel implements ActionListener{
	
	
	private HashMap<String,LetterButton> letters = new HashMap<String,LetterButton>();
	public String L = new String();
	private String selectedLetter = new String();
	public PSearchBar(){
			
		
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
		if(!selectedLetter.isEmpty()){
			letters.get(selectedLetter).setSelected(false);
		}
		
		for(int i = 1; i <= 26; i ++){
			if(letters.get(Character.toString((char)(i+64))).isSelected() == true){
				selectedLetter = Character.toString((char)(i+64));
			}
		}
		if(selectedLetter.isEmpty()){
			return " ";
		}
		else{
			return selectedLetter;	
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		L = this.getSelected();
		
	}

}
