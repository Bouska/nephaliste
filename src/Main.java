import javax.swing.*;

import apps.Debiter;
import apps.PSearchBar;
import net.miginfocom.swing.MigLayout;



public class Main {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JFrame frame = new JFrame();
		MigLayout layout = new MigLayout("");
		Debiter debiter = new Debiter();
		
		panel.setLayout(layout);
		panel.add(debiter,"w 100%,h 100%");
		
		frame.add(panel);
		//frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setSize(500, 200);
		frame.setVisible(true);
	}

}
