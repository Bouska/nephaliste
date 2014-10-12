package apps.debiter;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import apps.Client;
import apps.FicheClient;
import utils.sql.Requests;

public class ProductButton extends JButton implements ActionListener{
	
	
	private FicheClient fclient;
	private BufferedImage img;
	
	public ProductButton(String arg0){
		super(arg0);
		this.addActionListener(this);
		this.setBorder(null);
		this.setOpaque(false);
		this.setBackground(new Color(237,31,36));
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
		if(Client.isInit()){
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
	    g2d.setComposite(AlphaComposite.SrcOver.derive(0.60f));
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
  		
		g2d.dispose();
  		
	}
}
