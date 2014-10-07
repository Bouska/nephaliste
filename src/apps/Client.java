package apps;

import utils.sql.Requests;

public class Client {
	private static String nom;
	private static String solde;
	private static String coopeman;
	private static String promo;
	private static boolean init;
	
	public Client(){
		nom = "";
		solde = "";
		coopeman = "";
		promo = "";
		init = false;
	}
	
	public static void setClient(String client){
		nom = client;
		promo =Requests.getClientPromo(client);
		solde = Requests.getClientSolde(client);
		coopeman =Requests.getClientCoope(client);
		init = true;
	}
	
	public static boolean isInit(){
		return init;
	}
	public static String getSolde(){
		return solde;
	}
	public static String getPromo(){
		return promo;
	}
	public static String getCoopeman(){
		return coopeman;
	}
	public static String getNom(){
		return nom;
	}
}
