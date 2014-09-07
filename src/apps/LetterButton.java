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
		g.clearRect(0,0,100,100);
		if(this.isSelected()){
			color = Color.DARK_GRAY;
		}
		else
		{
			color = Color.LIGHT_GRAY;
		}
		g.setColor(color);
		g.fillRect(0, 0, 100, 100);
		g.setColor(Color.white);
		g.drawString(this.getText(), 17, 17);
		
			
	}
}
