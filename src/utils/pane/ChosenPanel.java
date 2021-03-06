package utils.pane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		private boolean actionEnabled = false;
		private boolean empty = true;
		private boolean baction=false;
		private JLabel label = new JLabel();
		private IAppPanel appPanel;
		private JPanel panel=new JPanel();
		private ImagePanel imgPanel;
		private JPanel currentPanel;
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
					if (action != null && actionEnabled&&baction==true) 
					{action.run();
					 
					 remove(currentPanel);
					 currentPanel=panel;
					 add(currentPanel,"w 100%,h 100%");
					 
														 
					}
				
			}});
			
		
		
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

		public void setAction(Runnable action) {this.action = action;
												baction=!baction;}
		public void enableAction() {actionEnabled = true;}
		public void disableAction() {actionEnabled = false;}
		
		public void makePanel(IAppPanel pane)
		{
		//	remove(extend);
			appPanel=pane;
			remove(panel);
			
			imgPanel=new ImagePanel(pane.getThumbnail());
			if(action==null)
			{
				imgPanel.addMouseListener(new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent arg0) {
						System.exit(0);
						
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
			}
			currentPanel = imgPanel;
			panel=pane.getPanel();
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
			
			add(imgPanel,"w 100%,h 100%");
			empty=false;
			repaint();
			appPanel.getReturnButton().addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(action!=null&&actionEnabled)
					{
						action.run();
						remove(currentPanel);
						 currentPanel=imgPanel;
						 add(currentPanel,"w 100%,h 100%");
					}
				}
				
			});
		}
		public boolean isEmpty()
		{
			return empty;
		}
	
}
