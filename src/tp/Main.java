package tp;

import java.util.List;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		List<Plat>  listPlat;
		List<Client> listClient;
		List<Commande> listCommande;
		
		System.out.print("Entrer le nom du fichier: ");
		Scanner scanner = new Scanner(System.in);
		String fic = scanner.nextLine();
		scanner.close();
		
		TextFile fichier = new TextFile(System.getProperty("user.dir")+"\\" + fic);
		
		try {
			listClient = fichier.getClient();
			listPlat = fichier.getPlat();
			listCommande = fichier.getCommandes( listClient, listPlat );
			
			facture(listClient, listCommande);
			
		} catch ( Exception e ) {
			System.out.println( "Le fichier ne respecte pas le format demandé !" );
		}

	}
	
	public static void facture(List<Client> listClient,List<Commande> listCommande) {
		for(Commande commande: listCommande) {
			commande.getClient().addTotal( commande.getTotale() );
		}
		System.out.println( "Bienvenue chez Barette!\nFactures: ");
		for(Client client: listClient) {
			System.out.println( client );
		}
		
	}
	
	

}
