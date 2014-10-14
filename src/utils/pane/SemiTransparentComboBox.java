package utils.pane;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.plaf.metal.MetalComboBoxUI;

public class SemiTransparentComboBox extends JComboBox{
	
	private Color menuColor;
	public SemiTransparentComboBox(Object[] items, Color color){
		super(items);
		this.menuColor = color;
		this.setUI(new STComboBoxUI(menuColor));
		this.setMaximumRowCount(10);
	}
	
	public void updateList(Object[] items){
		this.removeAll();
		this.setUI(new STComboBoxUI(menuColor));
		this.setMaximumRowCount(10);
		this.setModel(new DefaultComboBoxModel(items));;
	}
	
	class STComboBoxUI extends MetalComboBoxUI {
		
		private Color color;
		public STComboBoxUI(Color color){
			super();
			this.color = color;
		}
		protected ComboPopup createPopup() {
			STBasicComboPopup popup = new STBasicComboPopup(comboBox);
			JList list = popup.getList();
			return popup;
	   }           
		protected JButton createArrowButton(){
			JButton button = new ComboBoxButton(color);
			return button;
		}
		
	}        
	
	class STBasicComboPopup extends BasicComboPopup {
	   STBasicComboPopup(JComboBox box){
	      super(box);
	   }
	   protected JScrollPane createScroller() {
	      JScrollPane pane = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	      pane.getVerticalScrollBar().setUI(new SemiTransparentScrollBar(menuColor));;
	      return pane;
	   } 
	}
	
	class ComboBoxButton extends JButton implements MouseListener{
		
		private Color color;
		public ComboBoxButton(Color color){
			super();
			this.color = color;
		}
		
		public void paintComponent(Graphics g){
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setColor(color);
			g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		
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
}                                 

