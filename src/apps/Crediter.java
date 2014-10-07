package apps;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import utils.pane.IAppPanel;

public class Crediter extends JPanel implements IAppPanel {
	
	private BufferedImage crediter = null;
	public Crediter()
	{
		try {
			crediter=ImageIO.read(new File("./resources/img/crediter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	@Override
	public BufferedImage getThumbnail() {
		// TODO Auto-generated method stub
		return crediter;
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
