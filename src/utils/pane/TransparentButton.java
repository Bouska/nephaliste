package utils.pane;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class TransparentButton extends JButton implements MouseListener {
	
	public TransparentButton(String text)
	{
		setOpaque(false);
		setText(text);
		addMouseListener(this);
	}
	   @Override
	     public void paint(Graphics g) {
	         Graphics2D g2d = (Graphics2D) g.create();
	         g2d.setComposite(AlphaComposite.SrcOver.derive(0.60f));
	         super.paint(g2d);
	         g2d.dispose();
	     }

	     @Override
	     protected void paintComponent(Graphics g) {
	         Graphics2D g2d = (Graphics2D) g.create();
	         g2d.setColor(getBackground());
	         g2d.fillRect(0, 0, getWidth(), getHeight());
	         super.paintComponent(g2d);
	         g2d.dispose();
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
