package mainTestStairZ0;

import java.awt.Frame;

import javax.swing.JFrame;

import aurelienribon.slidinglayout.SLAnimator;
import utils.pane.ChoosingPanel;
import utils.pane.SearchPanel;


public class main {

	public static void main(String[] args) {
		SLAnimator.start();
		JFrame test = new JFrame("Néphaliste");
		ChoosingPanel pane = new ChoosingPanel(4,3);
		for(int i =0;i<3;i++)
		{
			pane.addPanel(new ThePanel(""+i,""));
		}
		pane.addPanel(new SearchPanel());
		test.setContentPane(pane);
		test.pack();
		test.setDefaultLookAndFeelDecorated(true);
		test.setExtendedState(Frame.MAXIMIZED_BOTH);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setLocationRelativeTo(null);
		test.setVisible(true);

	}

}
