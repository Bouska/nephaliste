package apps;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class LetterButton extends JCheckBox{

	private Color color;
	
	public LetterButton(String string) {
		super(string);
		color = Color.LIGHT_GRAY;
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.clearRect(0,0,this.getWidth(),this.getHeight());
		if(this.isSelected()){
			color = Color.DARK_GRAY;
		}
		else
		{
			color = Color.LIGHT_GRAY;
		}
		g.setColor(color);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.white);
		g.drawString(this.getText(), this.getWidth()/2-g.getFont().getSize()/2, this.getHeight()/2+g.getFont().getSize()/2);
		
			
	}
}
