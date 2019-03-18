package tp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Facture {
	private GererCommande gererCommande;
	private ArrayList<String> listFacture;
	
	public Facture(GererCommande commande){
		gererCommande = commande;
	}
	
	public void calculeFacture(){
		for (Commande commande : gererCommande.getCommande()) {
			commande.getClient().addTotal(commande.getTotale());
		}
		
	
		
		System.out.println("Bienvenue chez Barette!\nFactures: ");
		
		listFacture.add("Bienvenue chez Barette!\nFactures: ");
		
		for (Client client : gererCommande.getClient()) {
			double tax = calculeTaxes(client.getTotal());
			
			System.out.println(client.getNom() + tax + "$");
			
			if (client.getTotal() != 0) {
				listFacture.add( client.getNom() + tax + "$");
			}
		}
	}

	public double calculeTaxes(double montant) {
		double tps,tvq;
		tvq = montant * 0.10;
		
		tps = montant * 0.05;
		
		montant = montant + tps + tvq;
		return montant;
	}
	
	public void enregistrerFacture(){
		DateFormat dateFormat = new SimpleDateFormat("dd-HH");
		Date date = new Date();
		String[] tab = new String[listFacture.size()];
		tab = listFacture.toArray(tab);
		TextFile text = new TextFile(tab);
		text.save("Facture-du-"+dateFormat.format(date));
	}
	
	public ArrayList<String> getFacture(){
		
		return listFacture;
	}
}
