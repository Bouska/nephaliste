

public class HistoricValue {
	public String product;
	public String date;
	public String id;
	public String client;
	public Boolean historique;
	public int nbclient;
	
	public HistoricValue(String product,String date,String id,String client,Boolean historique,int nbclient)
	{
		this.product=product;
		this.date=date;
		this.id=id;
		this.client=client;
		this.historique=historique;
		this.nbclient=nbclient;
	}

}
