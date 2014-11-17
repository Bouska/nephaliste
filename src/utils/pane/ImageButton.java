package utils.pane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

public class ImageButton extends JButton implements MouseListener {
	
	private BufferedImage bgImg;
	
	public ImageButton(BufferedImage img) {
		//setBackground(Color.black);
		setLayout(new BorderLayout());
		//this.setBorder(BorderFactory.createLineBorder(Color.gray,1));
		bgImg=img;
		//super.setOpaque(false);
		super.setBorderPainted(false);
		this.addMouseListener(this);

	}
 
	
	@Override
	protected void paintComponent(Graphics g) {
		//super.paintComponent(g);

		Graphics2D gg = (Graphics2D) g;
		gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		gg.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BICUBIC);

		int w = getWidth();
		int h = getHeight();
		gg.setColor(this.getBackground());
		gg.fillRect(0, 0, w
				+1, h+1);
		//gg.clearRect(0,0,w+1,h+1);
		if (bgImg != null) {
			int imgW = this.getWidth();
			int imgH = this.getHeight();

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

		int t = 0;
		
		
	}
	public void setImage(BufferedImage img)
	{
		bgImg=img;
		repaint();
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		super.setBorderPainted(true);
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		super.setBorderPainted(true);
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		super.setBorderPainted(false);
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		super.setBorderPainted(true);
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		super.setBorderPainted(false);
		repaint();
		
	}

}
