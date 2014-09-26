import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import aurelienribon.slidinglayout.SLAnimator;
import utils.pane.ChoosingPanel;
import utils.pane.SearchPanel;
import utils.sql.DataBaseInterface;

import javax.swing.*;

import mainTestStairZ0.ThePanel;
import net.miginfocom.swing.MigLayout;
import apps.*;

public class Main {

	public static void main(String[] args) {
		SLAnimator.start();
		JFrame test = new JFrame("Néphaliste");
		
		test.setBackground(Color.black);
		
		ChoosingPanel cpane = new ChoosingPanel(3,3);
		JPanel menu = new JPanel();
		JPanel pane = new JPanel();
		JPanel testPanel = new JPanel();
		
		pane.setLayout(new MigLayout("insets 0 0 0 0"));
		pane.add(cpane,"w 70%, h 100%");
		pane.add(menu,"w 30%, h 100%");
		
		
		menu.setBackground(Color.black);
		pane.setBackground(Color.black);
		cpane.setBackground(Color.black);

		testPanel.setLayout(new MigLayout(""));
		testPanel.add(new JButton("Test"));
		
		
		cpane.addPanel(new CardPanel(new Debiter(),"./resources/img/debiter.png"));
		cpane.addPanel(new CardPanel(new SearchPanel(), "./resources/img/crediter.png"));
		cpane.addPanel(new ThePanel("","./resources/img/comptes.png"));
		cpane.addPanel(new ThePanel("","./resources/img/historique.png"));
		cpane.addPanel(new ThePanel("","./resources/img/mail.png"));
		cpane.addPanel(new ThePanel("","./resources/img/stat.png"));
		cpane.addPanel(new ThePanel("","./resources/img/bpong.png"));
		cpane.addPanel(new ThePanel("","./resources/img/admin.png"));
		

		test.setContentPane(pane);
		test.setUndecorated(true);
		
		test.setShape(new RoundRectangle2D.Double(0, 0, 1142, 800, 15, 15));
		test.setSize(new Dimension(1142,800));
		
		test.setDefaultLookAndFeelDecorated(true);
	//	test.setExtendedState(Frame.MAXIMIZED_BOTH);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setLocationRelativeTo(null);
		test.setVisible(true);

	}

}
