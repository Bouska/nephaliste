package apps;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import apps.comptemanager.CreationCompte;
import net.miginfocom.swing.MigLayout;
import utils.pane.ChoosingPanel;
import utils.pane.IAppPanel;

public class Compte extends JPanel implements IAppPanel{
	
	private ChoosingPanel cpane = new ChoosingPanel(1,2);
	private BufferedImage thumbnail;
	private JPanel header = new JPanel();
	public Compte(){
		
		try {
			this.thumbnail=ImageIO.read(new File("./resources/img/comptes.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setLayout(new MigLayout("insets 0 0 0 0"));
		

		
		header.setLayout(new MigLayout());
		//header.setBackground(new Color(156,203,92));
		JLabel label = new JLabel("COMPTES");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,80));
		label.setForeground(new Color(255,255,255,145));
		header.add(label,"align center,w 100%,h 100%");
		cpane.addPanel(new CreationCompte());
		this.add(header, "w 100%, h 10%, wrap");
		this.add(cpane,"gapy 10%, gapx 10%, h 50%, w 80%");
	}

	@Override
	public BufferedImage getThumbnail() {
		// TODO Auto-generated method stub
		return this.thumbnail;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return this;
	}
}
