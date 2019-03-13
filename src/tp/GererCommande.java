package tp;

import java.util.ArrayList;

public class GererCommande {
	private TextFile fichierText;
	private ArrayList<Client> listClient;
	private ArrayList<Plat> listPlat;
	private ArrayList<Commande> listCommande;
	private ArrayList<String> listErreur;

	public GererCommande( TextFile texte ) {
		newText( texte );
		listClient = new ArrayList<Client>();
		listPlat = new ArrayList<Plat>();
		listCommande = new ArrayList<Commande>();
		listErreur = new ArrayList<String>();

	}

	public void newText( TextFile texte ) {
		this.fichierText = texte;
		update();
	}
	
	public void update() {
		listErreur = new ArrayList<String>();
		creerClient();
		creerPlat();
		creerCommande();
	}

	public void creerClient() {
		String[] text = fichierText.getText();
		ArrayList<Client> client = new ArrayList<Client>();
		boolean dansClient = false;

		for ( int i = 0; i < text.length; i++ ) {
			if ( text[i].equals( "Clients:" ) ) {
				dansClient = true;
			}
			if ( text[i].equals( "Plats:" ) || text[i].equals( "Commandes:" ) ) {
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
			}
			if ( text[i].equals( "Commandes:" ) || text[i].equals( "Clients:" ) ) {
				dansPlats = false;
			}
			if ( dansPlats ) {
				try {
					ligne = text[i].split( " " );
					plats.add( new Plat( ligne[0], Double.parseDouble( ligne[1] ) ) );
				} catch ( Exception e ) {
					listErreur.add( "Erreur! Creation de Plat : Plat mal formaté -> " + ligne );
				}

			}
		}
		if ( !plats.isEmpty() ) {
			listPlat = plats;
		} else {
			listErreur.add( "Erreur! Creation de Plat : Aucun Plat Detecter." );
		}
	}

	//a completer
	public void creerCommande() {
		String[] text = fichierText.getText();
		ArrayList<Commande> commandes = new ArrayList<Commande>();
		Client client;
		Plat plat;
		int qte;

		boolean dansCommande = false;
		String[] ligne;
		int index = -1;

		for ( int i = 0; i < text.length; i++ ) {

			if ( text[i].equals( "Commandes:" ) ) {
				dansCommande = true;
			}
			if ( text[i].equals( "Plats:" ) || text[i].equals( "Clients:" ) ) {
				dansCommande = false;
			}
			if ( dansCommande ) {
				try {
					ligne = text[i].split( " " );
					qte = Integer.parseInt( ligne[2] );
					index = listClient.indexOf( new Client( ligne[0] ) );
					client = listClient.get( index );
					
					try {
						index = listPlat.indexOf( new Plat( ligne[1], 0 ) );
						plat = listPlat.get( index );
						
						commandes.add( new Commande( client, plat, qte ) );
					} catch ( Exception e ) {
						listErreur.add( "Erreur! Creation de Commande : Plat non Creer-> " + text[i] );
					}
					
					
				} catch ( Exception e ) {
					listErreur.add( "Erreur! Creation de Commande : Client non Creer -> " + text[i] );
				}
				
				
				

			}
			if ( !commandes.isEmpty() ) {
				listCommande = commandes;
			} else {
				listErreur.add( "Erreur! Creation de Commande : Aucune Commande Detecter." );
			}
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
