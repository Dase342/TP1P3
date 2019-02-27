package tp;

public class Commande {
	private Client client;
	private Plat plat;
	private int qte;
	
	public Commande (Client clientCommande, Plat platCommande, int qteCommande){
		client = clientCommande;
		plat = platCommande;
		qte = qteCommande;
	}
	
	public Client getClient(){
		return client;
	}
	public Plat getPlat(){
		return plat;
	}
	public int getQte(){
		return qte;
	}
	public void setClient(Client clientCommande){
		client = clientCommande;
	}
	
	public void setPlat(Plat platCommande){
		plat = platCommande;
	}
	
	public double getTotale(){
		
		return plat.getPrixPlat()*getQte();
	}
}
