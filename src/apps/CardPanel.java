package apps;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;

import java.io.*;

public class CardPanel extends JPanel{
	

	private BufferedImage bgImg;
	private JPanel imgPane;
	public CardPanel(JPanel pane, String imgPath){
		
		try{
			bgImg = ImageIO.read(new File(imgPath));
		}
		catch(IOException ex){
			System.err.println("[error] cannot read image path '" + imgPath + "'");
		}
		
		imgPane = new JPanel(){
			@Override
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				
				Graphics2D gg = (Graphics2D) g;
				
				int w = getWidth();
				int h = getHeight();

				if (bgImg != null) {
					int imgW = bgImg.getWidth();
					int imgH = bgImg.getHeight();

					if ((float)w/h < (float)imgW/imgH) {
						int tw = h * imgW/ imgH;
						int th = h;
						gg.drawImage(bgImg, (w-tw)/2, 0, tw, th, null);
					} else {
						int tw = w;
						int th = w * imgH / imgW;
						gg.drawImage(bgImg, 0, (h-th)/2, tw, th, null);
					}
				}

				
			}
		};
		imgPane.setLayout(new MigLayout("h 100%, w 100%"));
		
		CardLayout layout = new CardLayout();
		this.setLayout(layout);
		this.add(imgPane);
		this.add(pane);

	}
}
