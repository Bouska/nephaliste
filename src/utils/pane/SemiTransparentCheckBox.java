package utils.pane;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JCheckBox;

public class SemiTransparentCheckBox extends JCheckBox{
	
	public SemiTransparentCheckBox(String string, String state){
		super(string);
		if(state.equals("1")){
			this.setSelected(true);
		}
		else{
			this.setSelected(false);
		}
		this.setOpaque(false);
	}
	
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g.create();		
		
		g2d.setComposite(AlphaComposite.SrcOver.derive(0.60f));
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

		g2d.setFont(new Font("Arial",Font.BOLD,20));
		
		g2d.setComposite(AlphaComposite.SrcOver.derive(0.30f));
		g2d.setColor(Color.white);
		g2d.fillRect(this.getWidth() - this.getHeight()/4 - this.getHeight()/2 , this.getHeight()/4, this.getHeight()/2, this.getHeight()/2);

		if(this.isSelected()){
			g2d.setComposite(AlphaComposite.SrcOver.derive(1.0f));
			g2d.setColor(Colors.blue);	
			g2d.fillRect(this.getWidth() - this.getHeight()/4 - this.getHeight()/2 + 5, this.getHeight()/4 + 5, this.getHeight()/2 - 10, this.getHeight()/2 - 10);

		}

	
		g2d.setColor(Colors.blue);
		g2d.setComposite(AlphaComposite.SrcOver.derive(0.6f));
		g2d.drawString(this.getText(), this.getHeight()/4, this.getHeight()/2 + this.getFont().getSize()/2);

		
		g2d.dispose();
	}

}
