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
		MigLayout layout = new MigLayout();
		Debiter debiter = new Debiter();
		
		panel.setLayout(layout);
		panel.add(debiter);
		
		frame.add(panel);
		//frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setSize(1200, 500);
		frame.setVisible(true);
	}

}
