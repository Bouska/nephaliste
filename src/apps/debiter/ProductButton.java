package apps.debiter;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;






import apps.Client;
import apps.FicheClient;
import utils.pane.Colors;
import utils.sql.Requests;

public class ProductButton extends JButton implements ActionListener, MouseListener{
	
	
	private FicheClient fclient;
	private BufferedImage img;
	private boolean mouseState = false;
	
	public ProductButton(String arg0){
		super(arg0);
		this.addActionListener(this);
		this.addMouseListener(this);
		this.setOpaque(false);
		this.setBorder(null);
		this.setBackground(Colors.red);
		try {
			this.img=ImageIO.read(new File("./resources/img/Produits/bouteille.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(Client.isInit() && Client.getOpen().equals("1")){
			fclient = FicheClient.getInstance();
			double price = Requests.getProductPrice(this.getText());
			String solde = Client.getSolde();
			double amount = Double.parseDouble(solde) - price;
			if((amount > 0)||(Client.getCoopeman().equals("1"))){
				Requests.setClientSolde(Client.getNom(), "-" + price);
				fclient.updateClient(Client.getNom());
			}
			else{
				//A completer pour le popup
			}
		}
	}
	
	
	@Override
	protected void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setColor(new Color(255,255,255));
		g2d.setFont(new Font("Arial",Font.BOLD,17));
		
		//Dessin prix produit
		g2d.drawString(""+Requests.getProductPrice(this.getText())+"€", 3*this.getWidth()/4, this.getFont().getSize()*3/2);
		
		
		g2d.setFont(new Font("Arial",Font.BOLD,14));
		//Mise en forme et dessin du nom du produit
		String str = this.getText();
		int flagSplit = 0;
		str = str.substring(0,1).toUpperCase() + str.substring(1, str.length());

		if(this.getText().length()*this.getFont().getSize() > this.getWidth()){
			String strSplit[] = str.split(" ");
			
			for(int i = 0; i < strSplit.length; i++){
			strSplit[i] = strSplit[i].substring(0,1).toUpperCase() + strSplit[i].substring(1, strSplit[i].length());
				if(i < strSplit.length - 1){
					if((strSplit[i].length()+strSplit[i+1].length())*this.getFont().getSize() < this.getWidth()){
						g2d.drawString(new String(strSplit[i]+" "+strSplit[i+1]), 10, this.getHeight()*5/6+this.getFont().getSize()*(i-flagSplit)*3/2);
						flagSplit++;
						i++;
					}		
					else{
						g2d.drawString(strSplit[i], 10, this.getHeight()*5/6+this.getFont().getSize()*(i-flagSplit)*3/2);
					}
				}
				else{
					g2d.drawString(strSplit[i], 10, this.getHeight()*5/6+this.getFont().getSize()*(i-flagSplit)*3/2);
				}

			}
		}
		else{
			g2d.drawString(str, 10, this.getHeight()*5/6);
		}

		g2d.setFont(new Font("Arial",Font.BOLD,17));
		//Dessin de l'image
		g2d.drawImage(img, this.getWidth()*3/10, this.getFont().getSize()*3/2, this.getWidth()*2/5, this.getHeight()*7/12, null);
		
		//Dessin du fond transparent
		if(mouseState == false){
			g2d.setComposite(AlphaComposite.SrcOver.derive(0.60f));
		}
		else{
			g2d.setComposite(AlphaComposite.SrcOver.derive(0.75f));
		}
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
  		
		g2d.dispose();
  		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		mouseState = true;
		repaint();
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		mouseState = true;
		repaint();

	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		mouseState = false;
		repaint();

	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		mouseState = true;
		repaint();

	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		mouseState = false;
		repaint();
		
		
	}
}
