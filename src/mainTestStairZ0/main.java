package mainTestStairZ0;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import aurelienribon.slidinglayout.SLAnimator;
import utils.pane.ChoosingPanel;
import utils.pane.SearchPanel;


public class main {

	public static void main(String[] args) {
		SLAnimator.start();
		JFrame test = new JFrame("Néphaliste");
		
		test.setBackground(Color.black);
		ChoosingPanel pane = new ChoosingPanel(3,3);
		pane.setBackground(Color.black);
		pane.addPanel(new ThePanel("","./resources/img/debiter.png"));
		pane.addPanel(new ThePanel("","./resources/img/crediter.png"));
		pane.addPanel(new ThePanel("","./resources/img/comptes.png"));
		pane.addPanel(new ThePanel("","./resources/img/historique.png"));
		pane.addPanel(new ThePanel("","./resources/img/mail.png"));
		pane.addPanel(new ThePanel("","./resources/img/stat.png"));
		pane.addPanel(new ThePanel("","./resources/img/bpong.png"));
		pane.addPanel(new ThePanel("","./resources/img/admin.png"));
		
		
		
		test.setContentPane(pane);
		test.setUndecorated(true);
		
		test.setShape(new RoundRectangle2D.Double(0, 0, 1000, 1000, 15, 15));
		test.setSize(new Dimension(1000,1000));
		
		test.setDefaultLookAndFeelDecorated(true);
	//	test.setExtendedState(Frame.MAXIMIZED_BOTH);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setLocationRelativeTo(null);
		test.setVisible(true);

	}

}
