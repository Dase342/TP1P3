package tp;

import java.io.IOException;
import java.util.ArrayList;

public class GererFacture {
	private TextFile fichierText;
	private ArrayList<Client> listClient;
	private ArrayList<Plat> listPlat;
	private ArrayList<Commande> listCommande;
	private ArrayList<String> listErreur;

	public GererFacture( TextFile texte ) {
		newText( texte );
		listClient = new ArrayList<Client>();
		listPlat = new ArrayList<Plat>();
		listCommande = new ArrayList<Commande>();
		listErreur = new ArrayList<String>();

	}

	public void newText( TextFile texte ) {
		this.fichierText = texte;
	}

	public void creerClient() {
		String[] text = fichierText.getText();
		ArrayList<Client> client = new ArrayList<Client>();
		boolean dansClient = false;

		for ( int i = 0; i < text.length; i++ ) {
			if ( text[i].equals( "Clients:" ) ) {
				dansClient = true;
			}
			if ( text[i].equals( "Plats:" ) ) {
				dansClient = false;
			}
			if ( dansClient ) {
				client.add( new Client( text[i] ) );
			}
		}
		if ( !client.isEmpty() ) {
			client = listClient;
		} else {
			listErreur.add( "Erreur! Creation de Client : Aucun Client Detecter." );
		}
	}
	
	public void creerPlat() {
		String[] text = fichierText.getText();
		ArrayList<Plat> plats = new ArrayList<Plat>();
		boolean dansPlats = false;
		String[] ligne = null;
		
		for ( int i = 0; i < text.length; i++ ) {
			if ( text[i].equals( "Plats:" ) ) {
				dansPlats = true;
			} else if ( text[i].equals( "Commandes:" ) ) {
				dansPlats = false;
			} else if ( dansPlats ) {
				try {
					ligne = text[i].split( " " );
					plats.add( new Plat( ligne[0], Double.parseDouble( ligne[1] ) ) );
				} catch (Exception e) {
					listErreur.add( "Erreur! Creation de Plat : Plat mal formaté -> " + ligne );
				}
				
			}
		}
		if(!plats.isEmpty()) {
			listPlat = plats;
		} else {
			listErreur.add( "Erreur! Creation de Plat : Aucun Plat Detecter." );
		}
	}
	public ArrayList<Client> getClient() {
		return listClient;
	}

	public ArrayList<Plat> getPlat() {
		return listPlat;
	}

	public ArrayList<Commande> getCommande() {
		return listCommande;
	}

	public ArrayList<String> getErreur() {
		return listErreur;
	}
}
