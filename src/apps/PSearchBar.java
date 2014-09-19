package apps;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class PSearchBar extends JPanel implements ActionListener{
	
	
	private ArrayList<LetterButton> letters = new ArrayList<LetterButton>();
	public ArrayList<String> testL = new ArrayList<String>();
	
	public PSearchBar(){
			
		
		MigLayout layout = new MigLayout("insets 0 0 0 0");
		this.setLayout(layout);
		
		for(int i = 1; i <= 26; i++){
			letters.add(new LetterButton(new String(Character.toString((char)(i+64)))));	
			letters.get(i-1).addActionListener(this);
			if(i%6==0)
			{
				this.add(letters.get(i-1), "w 20%,wrap");
			}
			else
			{
				this.add(letters.get(i-1), "w 20%");
			}
		}
	}
	
	public ArrayList<String> getSelected(){
		ArrayList<String> selectedLetters = new ArrayList<String>();
		for(int i = 1; i <= 26; i ++){
			if(letters.get(i-1).isSelected() == true){
				selectedLetters.add(letters.get(i-1).getText());
			}
		}
		return selectedLetters;	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		testL = this.getSelected();
		System.out.println(testL.toString());
	}

}
