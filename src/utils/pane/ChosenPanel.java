package utils.pane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import net.miginfocom.swing.MigLayout;



 public class ChosenPanel extends JPanel {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		
		
		private Runnable action;
		private boolean actionEnabled = true;
		private boolean empty = true;
		private JLabel label = new JLabel();
		private JPanel panel=new JPanel();
		private JButton extend = new JButton();
		private int number;
		private boolean flagextend=false;
		private SpringLayout overlay = new SpringLayout();
		public ChosenPanel(int number) {
			setLayout(new MigLayout());
			setBackground(Color.black);
			
			//			this.number=number;
//			extend.setPreferredSize(new Dimension(48,48));
//			extend.setIcon(new ImageIcon("expand.png"));
//			extend.setBackground(Color.white);
//			   setLayout(overlay);
//			overlay.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, this);
//			overlay.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
//			overlay.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, this);
//			overlay.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, this);
//			
//			switch (number) 
//			{
//				case 1 :
//					 overlay.putConstraint(SpringLayout.SOUTH, extend, -10, SpringLayout.SOUTH, panel);
//					 overlay.putConstraint(SpringLayout.EAST, extend, -10, SpringLayout.EAST, panel);
//					break;
//				case 2 :
//					overlay.putConstraint(SpringLayout.SOUTH, extend, -10, SpringLayout.SOUTH, panel);
//					 overlay.putConstraint(SpringLayout.WEST, extend, 10, SpringLayout.WEST, panel);
//					break;
//				case 3 :
//					 overlay.putConstraint(SpringLayout.NORTH, extend, 10, SpringLayout.NORTH, panel);
//					 overlay.putConstraint(SpringLayout.EAST, extend, -10, SpringLayout.EAST, panel);
//					 
//					break;
//				case 4 :
//					 overlay.putConstraint(SpringLayout.NORTH, extend, 10, SpringLayout.NORTH, panel);
//					 overlay.putConstraint(SpringLayout.WEST, extend, 10, SpringLayout.WEST, panel);
//					break;
//					
//			}
			
			
			  
			
			
			this.setBorder(BorderFactory.createLineBorder(Color.black));
			addMouseListener(new MouseAdapter() {
				

				@Override
				public void mouseReleased(MouseEvent e) {
					if (action != null && actionEnabled) action.run();
				}
			});
		
		
		//	add(extend);
			extend.setVisible(false);
			add(panel,"w 100%,h 100%");
			
//			extend.addActionListener(new ActionListener() {
//			
//
//				public void actionPerformed(ActionEvent arg0) {
//					if (action != null && actionEnabled){ 
//						if(flagextend)
//						extend.setIcon(new ImageIcon("expand.png"));
//						else
//						extend.setIcon(new ImageIcon("collapse.png"));	
//						
//						flagextend=!flagextend;
//						action.run();
//						}
//					}
//					
//				
//			});
		}

		public void setAction(Runnable action) {this.action = action;}
		public void enableAction() {actionEnabled = true;}
		public void disableAction() {actionEnabled = false;}
		
		public void makePanel(JPanel pane)
		{
		//	remove(extend);
			remove(panel);
			panel=pane;
//			overlay.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, this);
//			overlay.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
//			overlay.putConstraint(SpringLayout.SOUTH, panel, 0, SpringLayout.SOUTH, this);
//			overlay.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, this);
//			
//			switch (number) 
//			{
//				case 1 :
//					 overlay.putConstraint(SpringLayout.SOUTH, extend, -10, SpringLayout.SOUTH, panel);
//					 overlay.putConstraint(SpringLayout.EAST, extend, -10, SpringLayout.EAST, panel);
//					break;
//				case 2 :
//					overlay.putConstraint(SpringLayout.SOUTH, extend, -10, SpringLayout.SOUTH, panel);
//					 overlay.putConstraint(SpringLayout.WEST, extend, 10, SpringLayout.WEST, panel);
//					break;
//				case 3 :
//					 overlay.putConstraint(SpringLayout.NORTH, extend, 10, SpringLayout.NORTH, panel);
//					 overlay.putConstraint(SpringLayout.EAST, extend, -10, SpringLayout.EAST, panel);
//					 
//					break;
//				case 4 :
//					 overlay.putConstraint(SpringLayout.NORTH, extend, 10, SpringLayout.NORTH, panel);
//					 overlay.putConstraint(SpringLayout.WEST, extend, 10, SpringLayout.WEST, panel);
//					break;
//					
//			}
//			extend.setVisible(true);
//			add(extend);
			add(panel,"w 100%,h 100%");
			empty=false;
			repaint();
		}
		public boolean isEmpty()
		{
			return empty;
		}
	
}
