package mainTestStairZ0;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import apps.Admin;
import apps.BierePong;
import apps.Compte;
import apps.Crediter;
import apps.Debiter;
import apps.Eteindre;
import apps.FicheClient;
import apps.Historique;
import apps.Mail;
import apps.Statistiques;
import aurelienribon.slidinglayout.SLAnimator;
import utils.pane.ChoosingPanel;
import utils.pane.ImagePanel;
import utils.pane.MotionPanel;



public class main {

	public static void main(String[] args) throws IOException {
		SLAnimator.start();
		JFrame test = new JFrame("N�phaliste");

		BufferedImage icon = ImageIO.read(new File("./resources/img/Coopemanpetit.png"));
		test.setIconImage(icon);
		
		test.setBackground(Color.black);
		ChoosingPanel pane = new ChoosingPanel(3,3);
		pane.setBackground(Color.black);
		
		
		test.setContentPane(new MotionPanel(test));
		//test.getContentPane().setLayout(new CardLayout());
		test.getContentPane().setBackground(Color.black);
		
		test.setUndecorated(true);
		
		test.setShape(new RoundRectangle2D.Double(0, 0,1100, 950, 15, 15));
		test.setSize(new Dimension(1100,950));
		
		test.getContentPane().setLayout(new MigLayout("insets 0 0 0 0"));
		JPanel test1 = new JPanel();
		
		
		test.getContentPane().add(test1,"w 75%,h 100%");
		test.getContentPane().add(FicheClient.getInstance(),"w 25%,h 100%");
		
		pane.addPanel(Debiter.getInstance());
		pane.addPanel(new Crediter());
		pane.addPanel(new Historique());
		pane.addPanel(Compte.getInstance());
		pane.addPanel(new Mail());
		pane.addPanel(Admin.getInstance());
		pane.addPanel(new Statistiques());
		pane.addPanel(new BierePong());
		pane.addPanel(new Eteindre());
		test1.setLayout(new MigLayout("center"));
		test1.setBackground(Color.black);
		BufferedImage coope =ImageIO.read(new File("./resources/img/COOPE.png"));
		JPanel test2 = new JPanel();
		test2.setBackground(Color.black);
		test2.setLayout(new MigLayout());
		test2.add(new ImagePanel(coope),"w 100%,h 100%");
		
		test1.add(test2,"align center,w 30%,h 15%,wrap");
		test1.add(pane,"align center,w 100%,h 85%");
		
		
		
		
		test.setDefaultLookAndFeelDecorated(true);
	//	test.setExtendedState(Frame.MAXIMIZED_BOTH);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setLocationRelativeTo(null);
		test.validate();
		test.setVisible(true);
		

	}

}
