package mainTestStairZ0;

import java.awt.Frame;

import javax.swing.JFrame;
import utils.pane

public class main {

	public static void main(String[] args) {
		JFrame test = new JFrame("Néphaliste");
		ChoosingPanel pane = new ChoosingPanel(4,4);
		test.setContentPane();
		test.pack();
		test.setDefaultLookAndFeelDecorated(true);
		test.setExtendedState(Frame.MAXIMIZED_BOTH);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setLocationRelativeTo(null);
		test.setVisible(true);

	}

}
