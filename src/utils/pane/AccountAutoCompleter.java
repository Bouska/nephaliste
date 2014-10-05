package utils.pane;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;

import apps.FicheClient;






public class AccountAutoCompleter extends AutoCompleter implements MouseListener,MouseMotionListener{ 
	private ArrayList<String> files=new ArrayList<String>();
	private FicheClient fiche;
 public AccountAutoCompleter(JTextComponent comp,ArrayList<String> file,FicheClient fiche){ 
     super(comp); 
     files=file;
     this.fiche=fiche;
     list.addMouseListener(this);
 } 

 protected boolean updateListData(){ 
     
   

     if(textComp.getText().length()!=0)
     {
    	 
     Pattern p = Pattern.compile(""+this.textComp.getText()+"");
     int i = 0;
     ArrayList<String> files2= new ArrayList<String>();
     while(i<files.size())
     {
    	 Matcher m = p.matcher(files.get(i));
    	 if(m.find())
    	 {
    		 files2.add(files.get(i));
    	 }
    	 i++;
    	 
     }
    
     
     
    

			 Object[] test = new Object[files2.size()];
			 int j=0;
			 while(j<files2.size())
			 {
				 test[j]=files2.get(j);
				 j++;
			 }
             list.setListData(test);
             return true;
     }
     list.clearSelection();
     return false;
     
       
     } 
 

 protected void acceptedListItem(String selected){ 
     if(selected==null) 
         return; 

     textComp.setText(selected);
     fiche.client=selected;
     fiche.updateClient(selected);
     list.clearSelection();
     popup.setVisible(false); 
     
//     int index1 = value.lastIndexOf('\\'); 
//     int index2 = value.lastIndexOf('/'); 
//     int index = Math.max(index1, index2); 
//     if(index==-1) 
//         return; 
//     int prefixlen = textComp.getDocument().getLength()-index-1; 
//     try{ 
//         textComp.getDocument().insertString(textComp.getCaretPosition(), selected.substring(prefixlen), null); 
//     } catch(BadLocationException e){ 
//         e.printStackTrace(); 
//     } 
 }

@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
public void mouseClicked(MouseEvent e) {
	
}

@Override
public void mousePressed(MouseEvent e) {
	
	
}

@Override
public void mouseReleased(MouseEvent arg0) {
	acceptedListItem((String) list.getSelectedValue());

	
}
@Override
public void mouseDragged(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseMoved(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
} 
}