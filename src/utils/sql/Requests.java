package utils.sql;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;





public class Requests {
	
	static DataBaseInterface db = new DataBaseInterface();
	
	static public String getClientSolde(String client)
	{

		String request = "SELECT solde FROM comptes WHERE nom = '"+client+"'";
		ArrayList<String> test = db.readRequest(request);
		return test.get(0);
		
	}
	static public int getCoopeman(String client)
	{

		String request = "SELECT coopeman FROM comptes WHERE nom = '"+client+"'";
		ArrayList<String> test = db.readRequest(request);
		return Integer.parseInt(test.get(0));
		
	}
	static public void addToHistoric(String client,String product,String nbclient,double etat_solde)
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = dateFormat.format(date);
		String product2= getProductId(product);
		String client2 = getClientId(client);
		String request = "INSERT INTO historique_conso (date,consommation,compte,etat_solde,nbclient) " +
				"VALUES ('"+ dateString +"', '"+ product2 +"', '"+ client2 +"', '"+ etat_solde +"', '"+nbclient+"'"+")";
		db.writeRequest(request);
	}
	static public void addToHistoric(String client,String amount,double etatSolde)
	{
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = dateFormat.format(date);
		String client2 = getClientId(client);
		String request = "INSERT INTO depots (date,montant,compte,forme,etat_solde) " +
				"VALUES ('"+ dateString +"', '"+ amount +"', '"+ client2 +"','0', '"+ etatSolde +"')";
		db.writeRequest(request);
	}
	static public ArrayList<HistoricValue> getHistoric(String client)
	{
		
		ArrayList<HistoricValue> historic = new ArrayList<HistoricValue>();

		
		String request = "SELECT id FROM historique_conso WHERE compte = '"+getClientId(client)+"'";
		ArrayList<String> length = db.readRequest(request);
		
		int i=0; 
		while(i<length.size())
		{
			
			
			request = "SELECT date FROM historique_conso WHERE id = '"+length.get(i)+"'";
			ArrayList<String> test = db.readRequest(request);
			String date = test.get(0);
			request = "SELECT consommation FROM historique_conso WHERE id = '"+length.get(i)+"'";
			test = db.readRequest(request);
			String product = test.get(0);
			request = "SELECT nbclient FROM historique_conso WHERE id = '"+length.get(i)+"'";
			test = db.readRequest(request);
			String nbclient = test.get(0);
			historic.add(new HistoricValue(product,date,length.get(i),client,true,Integer.parseInt(nbclient)));
			i++;
			
			
		}
		request = "SELECT id FROM depots WHERE compte = '"+getClientId(client)+"'";
		length = db.readRequest(request);
		i=0;
		while(i<length.size())
		{
			request = "SELECT date FROM depots WHERE id = '"+length.get(i)+"'";
			ArrayList<String> test = db.readRequest(request);
			String date = test.get(0);
			request = "SELECT montant FROM depots WHERE id = '"+length.get(i)+"'";
			test = db.readRequest(request);
			String product = test.get(0);
			historic.add(new HistoricValue(product,date,length.get(i),client,false,1));
			i++;
		}
	
		return historic;
		
	}
	static public void setClientSolde(String client,String amount)
	{
		String request = "UPDATE comptes SET solde = solde + " + amount + " WHERE nom = '" + client + "'";
		db.writeRequest(request);
	}
	static public double getProductPrice(String product)
	{
		String request = "SELECT prix FROM recettes WHERE nom = '"+product+"'";
		ArrayList<String> test = db.readRequest(request);
		
		return Double.parseDouble(test.get(0));
		
	}
	static public String getProduct(String id)
	{
		String request = "SELECT nom FROM recettes WHERE id = '"+id+"'";
		ArrayList<String> test = db.readRequest(request);
		
		return test.get(0);
		
	}
	
	static public ArrayList<String> getProducts(String c){
		String request = new String();
		if (c == " "){
			request = "SELECT nom FROM recettes";
		}
		else{
			request = "SELECT nom FROM recettes WHERE nom  LIKE '" + c +"%'";
		}
		ArrayList<String> test = db.readRequest(request);
		return test;
	}
	
	static public void createNewClient(String firstName, String surName, String nickName, int promo, boolean coopeman){
		String request = new String();
		
	}
	
	static public String getProductId(String product)
	{
		String request = "SELECT id FROM recettes WHERE nom = '"+product+"'";
		ArrayList<String> test = db.readRequest(request);
		return test.get(0);
	}
	static public String getClientId(String client)
	{
		String request = "SELECT id FROM comptes WHERE nom = '"+client+"'";
		ArrayList<String> test = db.readRequest(request);
		return test.get(0);
	}
	
	static public String getClientName(String id)
	{
		String request = "SELECT name FROM comptes WHERE id = '"+id+"'";
		ArrayList<String> test = db.readRequest(request);
		return test.get(0);
	}
	static public String getClientPromo(String client)
	{
		String request = "SELECT promo FROM comptes WHERE nom = '"+client+"'";
		ArrayList<String> test = db.readRequest(request);
		return test.get(0);
	}
	
	static public String getClientCoope(String client)
	{
		String request = "SELECT coopeman FROM comptes WHERE nom = '"+client+"'";
		ArrayList<String> test = db.readRequest(request);
		return test.get(0);
	}

}
