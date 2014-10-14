package apps;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import utils.pane.Colors;
import utils.pane.IAppPanel;
import utils.pane.ImageButton;

public class Admin extends JPanel implements IAppPanel{
	private ImageButton returnButton;
	private JPanel header = new JPanel();
	private BufferedImage admin = null;
	private BufferedImage adminHeader = null;

	public Admin()
	{
		try {
			
			admin=ImageIO.read(new File("./resources/img/admin.png"));
			adminHeader=ImageIO.read(new File("./resources/img/headers/admin.png"));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		this.setBackground(Colors.lightGray);
		returnButton = new ImageButton(adminHeader);
		setLayout(new MigLayout());
		add(header,"w 100%,h 20%,wrap");
		JPanel test = new JPanel();
		test.setBackground(Colors.lightGray);
		add(test,"w 100%,h 80%");
		header.setLayout(new MigLayout());
		header.add(returnButton,"w 20%,h 100%");
		header.setBackground(Colors.lightGray);
		JLabel label = new JLabel("ADMIN");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,80));
		label.setForeground(new Color(255,255,255,145));
		header.add(label,"align center,w 80%,h 100%");
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

}
