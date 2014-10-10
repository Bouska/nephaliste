package utils.pane;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextField;

public class SemiTransparentTextField extends JTextField {
	 public SemiTransparentTextField(String text) {
         super(text);
         init();
     }

     public SemiTransparentTextField(int columns) {
         super(columns);
         init();
     }

     public SemiTransparentTextField(String text, int columns) {
         super(text, columns);
         init();
     }

     protected void init() {
         setOpaque(false);
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

 }

