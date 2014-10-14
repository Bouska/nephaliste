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

public class Statistiques extends JPanel implements IAppPanel{
	private ImageButton returnButton;
	private JPanel header = new JPanel();
	private BufferedImage stat = null;
	private BufferedImage statHeader = null;

	public Statistiques()
	{
		try {
			
			stat=ImageIO.read(new File("./resources/img/stat.png"));
			statHeader=ImageIO.read(new File("./resources/img/headers/stat.png"));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		this.setBackground(Colors.yellow);
		returnButton = new ImageButton(statHeader);
		setLayout(new MigLayout());
		add(header,"w 100%,h 20%,wrap");
		JPanel test = new JPanel();
		test.setBackground(Colors.yellow);
		add(test,"w 100%,h 80%");
		header.setLayout(new MigLayout());
		header.add(returnButton,"w 20%,h 100%");
		header.setBackground(Colors.magenta);
		JLabel label = new JLabel("STATISTIQUES");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,80));
		label.setForeground(new Color(255,255,255,145));
		header.add(label,"w 60%,h 100%");
	}
	@Override
	public BufferedImage getThumbnail() {
		// TODO Auto-generated method stub
		return stat;
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