package apps;

import java.util.ArrayList;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class PSearchBar extends JPanel {
	
	
	ArrayList<LetterButton> letters = new ArrayList<LetterButton>();
	
	public PSearchBar(){
		
		int l;
	
		
		
		MigLayout layout = new MigLayout("insets 0 0 0 0");
		this.setLayout(layout);
		
		for(int i = 1; i <= 26; i++){
			letters.add(new LetterButton(new String(Character.toString((char)(i+64)))));	
			if(i%10==0)
			{
				this.add(letters.get(i-1), "w 10%,wrap");
			}
			else
			{
				this.add(letters.get(i-1), "w 10%");
			}
			
			
		
		}
	}
}
