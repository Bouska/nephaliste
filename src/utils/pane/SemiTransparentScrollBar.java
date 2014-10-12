package utils.pane;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class SemiTransparentScrollBar extends BasicScrollBarUI {
	
	public Color background;
	public SemiTransparentScrollBar(Color color){
		background = color;
		this.trackColor = background;
		this.trackHighlightColor = background;
	}
	
	
	@Override
	protected void configureScrollBarColors(){
		this.thumbColor = new Color(0,0,0);
		this.thumbHighlightColor = new Color(0,0,0);

	}
	
	@Override
	protected JButton createIncreaseButton(int orientation){
		return createZero();
	}
	
	@Override
	protected JButton createDecreaseButton(int orientation){
		return createZero();
	}
	
	
	
	
	private JButton createZero(){
		JButton butt = new JButton();
        butt.setPreferredSize(new Dimension(0, 0));
        butt.setMinimumSize(new Dimension(0, 0));
        butt.setMaximumSize(new Dimension(0, 0));
        return butt;
	}
	
	
	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds){
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.40f));
        super.paintThumb(g2d,c,thumbBounds);
        g2d.dispose();
	}

}
