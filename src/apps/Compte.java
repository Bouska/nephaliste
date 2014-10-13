package apps;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import apps.comptemanager.*;
import net.miginfocom.swing.MigLayout;
import utils.pane.Colors;
import utils.pane.IAppPanel;
import utils.pane.ImageButton;

public class Compte extends JPanel implements IAppPanel,ActionListener{
	
	private JPanel cpane = new JPanel();
	private JPanel bpane = new JPanel();
	private JPanel header = new JPanel();
	
	private BufferedImage thumbnail;
	private BufferedImage compteHeader;
	private BufferedImage createImage;
	private BufferedImage updateImage;
	
	private ImageButton createButton;
	private ImageButton updateButton;
	private ImageButton returnButton;
	
	private static final String MAINPANEL = "mainComptes";
	private static final String CREATEPANEL = "createComptes";
	private static final String UPDATEPANEL = "updatePanel";
	
	private CreationCompte createCompte;
	private UpdateCompte updateCompte;
	
	private Compte(){
		
		try {
			this.updateImage = ImageIO.read(new File("./resources/img/comptes/gestion.png"));
			this.createImage = ImageIO.read(new File("./resources/img/comptes/creation.png"));
			this.compteHeader = ImageIO.read(new File("./resources/img/headers/comptes.png"));
			this.thumbnail=ImageIO.read(new File("./resources/img/comptes.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		cpane.setLayout(new MigLayout("insets 0 0 0 0"));
		bpane.setLayout(new MigLayout("insets 0 0 0 0"));
		this.setLayout(new CardLayout());
		
		createButton = new ImageButton(createImage);
		createButton.setText(CREATEPANEL);
		createButton.addActionListener(this);
		updateButton = new ImageButton(updateImage);
		updateButton.setText(UPDATEPANEL);
		updateButton.addActionListener(this);
		
		returnButton = new ImageButton(compteHeader);
		
		header.setLayout(new MigLayout());
		JLabel label = new JLabel("COMPTES");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,80));
		label.setForeground(new Color(255,255,255,145));
		
		header.setBackground(Colors.lightBlue);
		header.add(returnButton,"w 20%, h 100%");
		header.add(label,"align center,w 60%,h 100%");
		
		cpane.setBackground(Colors.lightBlue);
		cpane.add(header, "w 100%, h 20%, wrap");
		bpane.add(createButton, "gapx 15%, gapy 30%, w 32%, h 40%");
		bpane.add(updateButton, "gapx 6%, w 32%, h 40%");
		bpane.setBackground(Colors.lightBlue);
		
		cpane.add(bpane, "w 100%, h 80%");
		this.add(cpane,MAINPANEL);
		this.add(createCompte = new CreationCompte(), CREATEPANEL);
		this.add(updateCompte = new UpdateCompte(), UPDATEPANEL);
	}
	
	private static class SingletonHolder{
		public static final Compte INSTANCE = new Compte();	
	}
	public static Compte getInstance(){
		return SingletonHolder.INSTANCE;
	}
	

	@Override
	public BufferedImage getThumbnail() {
		// TODO Auto-generated method stub
		return this.thumbnail;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JPanel getPanel() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public JButton getReturnButton() {
		// TODO Auto-generated method stub
		return returnButton;
	}
	
	public UpdateCompte getUpdateComptePanel(){
		return updateCompte;
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		CardLayout cl = (CardLayout)this.getLayout();
		if(arg0.getSource() == createButton){
			cl.show(this, CREATEPANEL);
		}
		else if(arg0.getSource() == updateButton){ 
			cl.show(this, UPDATEPANEL);
		}
	}
}
