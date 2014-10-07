package apps;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import apps.comptemanager.CreationCompte;
import net.miginfocom.swing.MigLayout;
import utils.pane.ChoosingPanel;
import utils.pane.IAppPanel;

public class Compte extends JPanel implements IAppPanel{
	
	private ChoosingPanel cpane = new ChoosingPanel(2,1);
	private BufferedImage thumbnail;
	public Compte(String img) throws IOException{
		this.thumbnail = ImageIO.read(new File(img));
		this.setLayout(new MigLayout("insets 0 0 0 0"));
		cpane.addPanel(new CreationCompte());
		this.add(cpane,"h 100%, w 100%");
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
