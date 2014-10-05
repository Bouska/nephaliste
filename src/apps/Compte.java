package apps;

import javax.swing.JPanel;

import apps.comptemanager.CreationCompte;
import net.miginfocom.swing.MigLayout;
import utils.pane.ChoosingPanel;

public class Compte extends JPanel{
	
	private ChoosingPanel cpane = new ChoosingPanel(2,1);
	
	public Compte(){
		this.setLayout(new MigLayout("insets 0 0 0 0"));
		cpane.addPanel(new CreationCompte());
		this.add(cpane,"h 100%, w 100%");
	}
}
