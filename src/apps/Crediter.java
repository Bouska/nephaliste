package apps;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import utils.pane.Colors;
import utils.pane.IAppPanel;
import utils.pane.ImageButton;
import utils.pane.ImagePanel;
import utils.pane.SemiTransparentTextField;
import utils.pane.TransparentButton;
import utils.sql.Requests;

public class Crediter extends JPanel implements IAppPanel,ActionListener {
	
	private JPanel billets= new JPanel();
	private JPanel pieces = new JPanel();
	SemiTransparentTextField montant = new SemiTransparentTextField("0.0");
	private TransparentButton okButton = new TransparentButton("OK");
	private TransparentButton resetButton=new TransparentButton("RESET");
	private BufferedImage crediter = null;
	private BufferedImage crediterHeader = null;
	private ImageButton returnButton ;
	HashMap<ImageButton,Double> buttons = new HashMap<ImageButton,Double>();
	
	public Crediter()
	{
		setBackground(Colors.green);
		pieces.setBackground(Colors.green);
		billets.setBackground(Colors.green);
		try {
			
			crediter=ImageIO.read(new File("./resources/img/crediter.png"));
			crediterHeader=ImageIO.read(new File("./resources/img/headers/crediter.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		returnButton = new ImageButton(crediterHeader);
		setLayout(new MigLayout());
		
		JPanel header = new JPanel();
		
		add(header,"w 100%,h 20%,wrap");
		add(montant,"gapy 2%,align center ,w 60%, h 10%,wrap");
		add(billets,"gapy 3%,align center, w 35%, h 25%,wrap");
		add(pieces,"gapy 2%,align center, w 60%, h 15%,wrap");
		JPanel inter = new JPanel();
		inter.setLayout(new MigLayout());
		inter.setBackground(Colors.green);;
		inter.add(okButton,"w 45%,h 100%");
		inter.add(resetButton,"gap 10%,w 45%,h 100%");
		add(inter,"gapy 3% ,align center, w 40%,h 10%");
		loadImages();
		header.setLayout(new MigLayout());
		header.add(returnButton,"w 20%,h 100%");
		header.setBackground(Colors.green);
		JLabel label = new JLabel("CREDITER");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial",Font.BOLD,80));
		label.setForeground(new Color(255,255,255,145));
		header.add(label,"w 60%,h 100%");
		
		montant.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		montant.setHorizontalAlignment(JTextField.CENTER);
		montant.setFont(new Font("Arial",Font.BOLD,40));
		montant.setBorder(null);
		montant.setBackground(Color.white);
		montant.setForeground(Colors.green);
		montant.setSelectionColor(Colors.green);
		montant.setEditable(false);
		okButton.setBorderPainted(false);
		okButton.setFont(new Font("Arial",Font.BOLD,40));
		okButton.setBackground(Color.white);
		okButton.setForeground(Colors.green);
		okButton.addActionListener(this);
		resetButton.setBorderPainted(false);
		resetButton.setFont(new Font("Arial",Font.BOLD,40));
		resetButton.setBackground(Color.white);
		resetButton.setForeground(Colors.green);
		resetButton.addActionListener(this);
		
		
		
		
		
		
		
	}
	private void loadImages()
	{
		BufferedImage b5 = null;
		BufferedImage b10 = null;
		BufferedImage b20 = null;
		BufferedImage b50 = null;
		BufferedImage p10c = null;
		BufferedImage p20c = null;
		BufferedImage p50c = null;
		BufferedImage p1 = null;
		BufferedImage p2 = null;
		try {
			 b5 = ImageIO.read(new File("./resources/img/Billets/5.png"));
			 b10 = ImageIO.read(new File("./resources/img/Billets/10.png"));
			 b20 = ImageIO.read(new File("./resources/img/Billets/20.png"));
			 b50 = ImageIO.read(new File("./resources/img/Billets/50.png"));
			 p10c = ImageIO.read(new File("./resources/img/Pieces/10c.png"));
			 p20c = ImageIO.read(new File("./resources/img/Pieces/20c.png"));
			 p50c = ImageIO.read(new File("./resources/img/Pieces/50c.png"));
			 p1 = ImageIO.read(new File("./resources/img/Pieces/1.png"));
			 p2 = ImageIO.read(new File("./resources/img/Pieces/2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImageButton ib5 = new ImageButton(b5);
		ImageButton ib10 = new ImageButton(b10);
		ImageButton ib20 = new ImageButton(b20);
		ImageButton ib50 = new ImageButton(b50);
		ImageButton ip10c = new ImageButton(p10c);
		ImageButton ip20c = new ImageButton(p20c);
		ImageButton ip50c = new ImageButton(p50c);
		ImageButton ip1 = new ImageButton(p1);
		ImageButton ip2 = new ImageButton(p2);
		
		buttons.put(ib5, 5.0);
		buttons.put(ib10, 10.0);
		buttons.put(ib20, 20.0);
		buttons.put(ib50, 50.0);
		billets.setLayout(new MigLayout());
		billets.add(ib50,"aligny top,w 25%,h 95%");
		billets.add(ib20,"aligny top,w 25%, h 90%");
		billets.add(ib10,"aligny top,w 25%,h 85%");
		billets.add(ib5,"aligny top,w 25%,h 80%");
		buttons.put(ip10c, 0.1);
		buttons.put(ip20c, 0.2);
		buttons.put(ip50c, 0.5);
		buttons.put(ip1, 1.0);
		buttons.put(ip2, 2.0);
		pieces.setLayout(new MigLayout());
		pieces.add(ip2,"aligny center,w 20%, h 95%");
		pieces.add(ip1,"aligny center,w 20%,h 90%");
		pieces.add(ip50c,"aligny center,w 20%,h 85%");
		pieces.add(ip20c,"aligny center,w 20%,h 80%");
		pieces.add(ip10c,"aligny center,w 20%,h 75%");
		for(ImageButton button : buttons.keySet())
		{
			button.setBackground(Colors.green);
			button.addActionListener(this);
		}
			
		
	}
	@Override
	public BufferedImage getThumbnail() {
		return crediter;
	}

	@Override
	public void update() {
	}

	@Override
	public JPanel getPanel() {
		return this;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==okButton)
		{	if(Client.isInit())
		{
			double oldSolde = Double.parseDouble(Requests.getClientSolde(Client.getNom()));
			double montant = Double.parseDouble(this.montant.getText());
		    Requests.setClientSolde(Client.getNom(),""+montant);
		}
			montant.setText("0.0");
		}
		else if(e.getSource()==resetButton)
		{
			montant.setText("0.0");
		}
		else
		{
			
		
		Double solde = buttons.get(e.getSource());
		DecimalFormat formatter = new DecimalFormat("#0.0");
		DecimalFormatSymbols sym = new DecimalFormatSymbols();
		sym.setDecimalSeparator('.');
		formatter.setDecimalFormatSymbols(sym);
		montant.setText(formatter.format((Double.parseDouble(montant.getText())+solde)).toString());
		}
		FicheClient fc = FicheClient.getInstance();
		fc.updateClient(Client.getNom());
	}
	@Override
	public JButton getReturnButton() {
		
		return returnButton;
	}

}
