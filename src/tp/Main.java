package tp;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		
		System.out.print("Entrer le nom du fichier: ");
		Scanner scanner = new Scanner(System.in);
		String fic = scanner.nextLine();
		scanner.close();
		
		GererCommande gererCommande = new GererCommande(new TextFile(System.getProperty("user.dir")+"\\" + fic));
		Facture facture = new Facture(gererCommande);
		facture.enregistrerFacture();
		
	}

}
