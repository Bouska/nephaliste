package apps.debiter;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

import utils.pane.Colors;

public class LetterButton extends JCheckBox{

	
	public LetterButton(String string) {
		super(string);
		this.setOpaque(false);
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g.create();		
		
		
		if(this.isSelected()){
			g2d.setComposite(AlphaComposite.SrcOver.derive(0.75f));
		}
		else
		{
			g2d.setComposite(AlphaComposite.SrcOver.derive(0.60f));
		}
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g2d.setColor(Color.red);
		g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
		g2d.setFont(new Font("Arial",Font.BOLD,20));
		g2d.drawString(this.getText(), this.getWidth()/2-g2d.getFont().getSize()/2, this.getHeight()/2+g2d.getFont().getSize()/2);

		
		g2d.dispose();
	}

}
