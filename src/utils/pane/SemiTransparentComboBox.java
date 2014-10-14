package utils.pane;


import java.util.Vector;

import javax.swing.*;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.plaf.metal.MetalComboBoxUI;

public class SemiTransparentComboBox extends JComboBox{
	
	public SemiTransparentComboBox(Object[] items){
		super(items);
		this.setUI(new STComboBoxUI());
	}
	
	class STComboBoxUI extends MetalComboBoxUI {
		protected ComboPopup createPopup() {
			STBasicComboPopup popup = new STBasicComboPopup(comboBox);
			JList list = popup.getList();
			return popup;
	   }           
	}        
	
	class STBasicComboPopup extends BasicComboPopup {
	   STBasicComboPopup(JComboBox box){
	      super(box);
	   }
	   protected JScrollPane createScroller() {
	      JScrollPane pane = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	      pane.getVerticalScrollBar().setUI(new SemiTransparentScrollBar(this.getBackground()));;
	      return pane;
	   } 
	}
	
}                                 

