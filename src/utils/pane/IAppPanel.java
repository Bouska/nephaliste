package utils.pane;

import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public interface IAppPanel {
	
	public BufferedImage getThumbnail();
	public void update();
	public JPanel getPanel();
	
	

}
