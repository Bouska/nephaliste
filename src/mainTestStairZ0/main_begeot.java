package mainTestStairZ0;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;

import javax.swing.JFrame;

import net.miginfocom.swing.MigLayout;
import apps.*;
import aurelienribon.slidinglayout.SLAnimator;
import utils.pane.ChoosingPanel;
import utils.pane.MotionPanel;



public class main_begeot {

	public static void main(String[] args) throws IOException {
		SLAnimator.start();
		JFrame test = new JFrame("Néphaliste");
		

		test.setBackground(Color.black);
		ChoosingPanel pane = new ChoosingPanel(3,3);
		pane.setBackground(Color.black);
		
		test.setContentPane(new MotionPanel(test));
		test.getContentPane().setBackground(Color.black);

		test.setUndecorated(true);
		
		test.setShape(new RoundRectangle2D.Double(0, 0, 1000, 750, 15, 15));
		test.setSize(new Dimension(1000,750));
		
		pane.addPanel(Debiter.getInstance());
		pane.addPanel(new Crediter());
		pane.addPanel(Compte.getInstance());
		pane.addPanel(Admin.getInstance());
		test.getContentPane().setLayout(new MigLayout("insets 0 0 0 0"));
		test.getContentPane().add(pane,"w 75%,h 100%");
		test.getContentPane().add(FicheClient.getInstance(),"w 25%,h 100%");
		
		
		
		test.setDefaultLookAndFeelDecorated(true);
	//	test.setExtendedState(Frame.MAXIMIZED_BOTH);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setLocationRelativeTo(null);
		test.setVisible(true);
		
	}

}
