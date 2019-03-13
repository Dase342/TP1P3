package tp;

import java.util.ArrayList;

public class GererFacture {
	private TextFile fichierText;
	private ArrayList<Client> listClient;
	private ArrayList<Plat> listPLat;
	private ArrayList<Commande> listCommande;
	private ArrayList<String> listErreur;
	
	public ArrayList<Client> getClient(){
		return listClient;
	}
	public ArrayList<Plat> getPlat(){
		return listPLat;
	}
	public ArrayList<Commande> getCommande(){
		return listCommande;
	}
	public ArrayList<String> getErreur(){
		return listErreur;
	}
}
