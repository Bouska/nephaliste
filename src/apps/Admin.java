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

import apps.adminmanager.*;
import net.miginfocom.swing.MigLayout;
import utils.pane.Colors;
import utils.pane.IAppPanel;
import utils.pane.ImageButton;

public class Admin extends JPanel implements IAppPanel, ActionListener{
	private ImageButton returnButton;
	private JPanel header = new JPanel();
	private JPanel contentPane = new JPanel();
	private JPanel bpane = new JPanel();
	
	private BufferedImage admin = null;
	private BufferedImage adminHeader = null;
	private BufferedImage createImage;
	private BufferedImage updateImage;
	
	private ImageButton createButton;
	private ImageButton updateButton;
	
	
	private static final String MAINPANEL = "mainPanel";
	private static final String CREATEPANEL = "createProduct";
	private static final String UPDATEPANEL = "updateProduct";
	
	private CreateProduct cp;
	private UpdateProduct up;
	
	private Admin()
	{
		try {		
			createImage = ImageIO.read(new File("./resources/img/admin/create.png"));
			updateImage = ImageIO.read(new File("./resources/img/admin/update.png"));
			admin=ImageIO.read(new File("./resources/img/admin.png"));
			adminHeader=ImageIO.read(new File("./resources/img/headers/admin.png"));
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setLayout(new CardLayout());
		
		
		this.setBackground(Colors.lightGray);
		createButton = new ImageButton(createImage);
		updateButton = new ImageButton(updateImage);
		returnButton = new ImageButton(adminHeader);
	
		createButton.addActionListener(this);
		updateButton.addActionListener(this);
		
		contentPane.setLayout(new MigLayout("insets 0 0 0 0"));
		bpane.setLayout(new MigLayout("insets 0 0 0 0"));
		
		bpane.add(createButton, "gapx 15%, gapy 30%, w 32%, h 40%");
		bpane.add(updateButton, "gapx 6%, gapy 30%, w 32%, h 40%");
		contentPane.add(header,"w 100%,h 20%,wrap");
		contentPane.add(bpane,"w 100%,h 80%");
		
		contentPane.setBackground(Colors.lightGray);
		bpane.setBackground(Colors.lightGray);
		this.setBackground(Colors.lightGray);
		
		header.setLayout(new MigLayout());
		header.add(returnButton,"w 20%,h 100%");
		header.setBackground(Colors.lightGray);
		JLabel label = new JLabel("ADMIN");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,80));
		label.setForeground(new Color(255,255,255,145));
		header.add(label,"align center,w 60%,h 100%");
		
		this.add(contentPane, MAINPANEL);
		this.add(cp = new CreateProduct(), CREATEPANEL);
		this.add(up = new UpdateProduct(), UPDATEPANEL);
		
	}
	
	private static class SingletonHolder{
		public static final Admin INSTANCE = new Admin();	
	}
	public static Admin getInstance(){
		return SingletonHolder.INSTANCE;
	}
	
	@Override
	public BufferedImage getThumbnail() {
		// TODO Auto-generated method stub
		return admin;
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
