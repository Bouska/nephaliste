package apps;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import utils.pane.IAppPanel;

public class Eteindre implements IAppPanel {
	private BufferedImage eteindre=null;
	
	public Eteindre()
	{
		try {
			eteindre=ImageIO.read(new File("./resources/img/quitter.png"));
			} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public BufferedImage getThumbnail() {
		// TODO Auto-generated method stub
		return eteindre;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return new JPanel();
	}

	@Override
	public JButton getReturnButton() {
		// TODO Auto-generated method stub
		return new JButton();
	}

}
