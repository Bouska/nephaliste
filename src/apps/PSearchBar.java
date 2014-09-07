package apps;

import java.util.ArrayList;

import javax.swing.*;

import net.miginfocom.swing.MigLayout;

public class PSearchBar extends JPanel {
	
	
	ArrayList<LetterButton> letters = new ArrayList<LetterButton>();
	
	public PSearchBar(){
		
		int l;
		
		this.setSize(1100,50);
		
		l = (int) this.getSize().getWidth();
		l = l / 40;
		
		String str = new String("wrap " + l);
		MigLayout layout = new MigLayout(str, "center");
		this.setLayout(layout);
		
		for(int i = 1; i <= 26; i++){
			letters.add(new LetterButton(new String(Character.toString((char)(i+64)))));	
			this.add(letters.get(i-1), "width 40px");
		
		}
	}
}
