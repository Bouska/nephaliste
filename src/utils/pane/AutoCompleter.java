package utils.pane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

public abstract class AutoCompleter { 
	@SuppressWarnings("rawtypes")
	JList list = new JList(); 
	JPopupMenu popup = new JPopupMenu(); 

	JTextComponent textComp; 
	private static final String AUTOCOMPLETER = "AUTOCOMPLETER"; //NOI18N 

	public AutoCompleter(JTextComponent comp) { 
		Font police = new Font("Arial", Font.PLAIN, 25);
		this.list.setFont(police);
		this.textComp = comp; 
		this.textComp.putClientProperty(AUTOCOMPLETER, this); 
		JScrollPane scroll = new JScrollPane(this.list); 
		scroll.setBorder(null);

		this.list.setFocusable( false ); 
		scroll.getVerticalScrollBar().setFocusable( false ); 
		scroll.getHorizontalScrollBar().setFocusable( false ); 

		this.popup.setBorder(BorderFactory.createLineBorder(Color.GRAY)); 
		this.popup.add(scroll); 

		if(this.textComp instanceof JTextField){ 
			this.textComp.registerKeyboardAction(showAction, KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), JComponent.WHEN_FOCUSED); 
			this.textComp.getDocument().addDocumentListener(this.documentListener); 
		}else 
			this.textComp.registerKeyboardAction(showAction, KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, KeyEvent.CTRL_MASK), JComponent.WHEN_FOCUSED); 

		this.textComp.registerKeyboardAction(upAction, KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), JComponent.WHEN_FOCUSED); 
		this.textComp.registerKeyboardAction(hidePopupAction, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_FOCUSED); 

		this.popup.addPopupMenuListener(new PopupMenuListener(){ 
			public void popupMenuWillBecomeVisible(PopupMenuEvent e){ 
			} 

			public void popupMenuWillBecomeInvisible(PopupMenuEvent e){ 
				AutoCompleter.this.textComp.unregisterKeyboardAction(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0)); 
			} 

			public void popupMenuCanceled(PopupMenuEvent e){ 
			} 
		}); 
		this.list.setRequestFocusEnabled(false); 
	} 

	static Action acceptAction = new AbstractAction(){ 
		/**
		 * 
		 */
		private static final long serialVersionUID = -8529180565743792862L;

		public void actionPerformed(ActionEvent e){ 
			JComponent tf = (JComponent)e.getSource(); 
			AutoCompleter completer = (AutoCompleter)tf.getClientProperty(AUTOCOMPLETER); 
			completer.popup.setVisible(false); 
			completer.acceptedListItem((String)completer.list.getSelectedValue()); 
		} 
	}; 

	DocumentListener documentListener = new DocumentListener(){ 
		public void insertUpdate(DocumentEvent e){ 
			showPopup(); 
		} 

		public void removeUpdate(DocumentEvent e){ 
			showPopup(); 
		} 

		public void changedUpdate(DocumentEvent e){} 
	}; 

	protected void showPopup(){ 
		this.popup.setVisible(false); 
		if(this.textComp.isEnabled() && updateListData() && this.list.getModel().getSize()!=0){ 
			if(!(this.textComp instanceof JTextField)) 
				this.textComp.getDocument().addDocumentListener(this.documentListener); 
			this.textComp.registerKeyboardAction(acceptAction, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_FOCUSED); 
			int size = this.list.getModel().getSize(); 
			this.list.setVisibleRowCount(size<2 ? size : 10); 

			int x = 0; 
			try{ 

				int pos=this.textComp.getX();
				x = this.textComp.getUI().modelToView(this.textComp, pos).x; 
			} catch(BadLocationException e){ 
				// this should never happen!!! 
				e.printStackTrace(); 
			} 
			this.popup.show(this.textComp, x, this.textComp.getHeight()); 
		}else 
			this.popup.setVisible(false); 
		this.textComp.requestFocus(); 
	} 

	static Action showAction = new AbstractAction(){ 
		/**
		 * 
		 */
		private static final long serialVersionUID = -3048749044515917977L;

		public void actionPerformed(ActionEvent e){ 
			JComponent tf = (JComponent)e.getSource(); 
			AutoCompleter completer = (AutoCompleter)tf.getClientProperty(AUTOCOMPLETER); 
			if(tf.isEnabled()){ 
				if(completer.popup.isVisible()) 
					completer.selectNextPossibleValue(); 
				else 
					completer.showPopup(); 
			} 
		} 
	}; 

	static Action upAction = new AbstractAction(){ 
		/**
		 * 
		 */
		private static final long serialVersionUID = 2257727359960779619L;

		public void actionPerformed(ActionEvent e){ 
			JComponent tf = (JComponent)e.getSource(); 
			AutoCompleter completer = (AutoCompleter)tf.getClientProperty(AUTOCOMPLETER); 
			if(tf.isEnabled()){ 
				if(completer.popup.isVisible()) 
					completer.selectPreviousPossibleValue(); 
			} 
		} 
	}; 

	static Action hidePopupAction = new AbstractAction(){ 
		/**
		 * 
		 */
		private static final long serialVersionUID = -1184825726863279428L;

		public void actionPerformed(ActionEvent e){ 
			JComponent tf = (JComponent)e.getSource(); 
			AutoCompleter completer = (AutoCompleter)tf.getClientProperty(AUTOCOMPLETER); 
			if(tf.isEnabled()) 
				completer.popup.setVisible(false); 
		} 
	}; 

	/** 
	 * Selects the next item in the list.  It won't change the selection if the 
	 * currently selected item is already the last item. 
	 */ 
	protected void selectNextPossibleValue(){ 
		int si = this.list.getSelectedIndex(); 

		if(si < this.list.getModel().getSize() - 1){ 
			this.list.setSelectedIndex(si + 1); 
			this.list.ensureIndexIsVisible(si + 1); 
		} 
	} 

	/** 
	 * Selects the previous item in the list.  It won't change the selection if the 
	 * currently selected item is already the first item. 
	 */ 
	protected void selectPreviousPossibleValue(){ 
		int si = this.list.getSelectedIndex(); 

		if(si > 0){ 
			this.list.setSelectedIndex(si - 1); 
			this.list.ensureIndexIsVisible(si - 1); 
		} 
	} 
	public void mouseClicked(MouseEvent e)
	{

	} 
	// update list model depending on the data in textfield 
	protected abstract boolean updateListData(); 

	// user has selected some item in the list. update textfield accordingly... 
	protected abstract void acceptedListItem(String selected); 
}