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
	}

	public void newText( TextFile texte ) {
		this.fichierText = texte;
		update();
	}
	
	public void update() {
		listClient = new ArrayList<Client>();
		listPlat = new ArrayList<Plat>();
		listCommande = new ArrayList<Commande>();
		listErreur = new ArrayList<String>();
		creerClient();
		creerPlat();
		creerCommande();
	}

	public void creerClient() {
		String[] text = fichierText.getText();
		ArrayList<Client> client = new ArrayList<Client>();
		boolean dansClient = false;

		for ( String ligne : text ) {
			if ( ligne.equals( "Plats:" ) || ligne.equals( "Commandes:" ) ) {
				dansClient = false;
			}
			if ( dansClient ) {
				client.add( new Client( ligne ) );
			}
			if ( ligne.equals( "Clients:" ) ) {
				dansClient = true;
			}

		}
		if ( !client.isEmpty() ) {
			listClient = client;

		} else {
			listErreur.add( "Erreur! Creation de Client : Aucun Client Detecter." );
		}
	}

	public void creerPlat() {
		String[] text = fichierText.getText();
		ArrayList<Plat> plats = new ArrayList<Plat>();
		boolean dansPlats = false;
		String[] ligne = null;

		for ( String line : text ) {
			if ( line.equals( "Commandes:" ) || line.equals( "Clients:" ) ) {
				dansPlats = false;
			}
			if ( dansPlats ) {
				try {
					ligne = line.split( " " );
					plats.add( new Plat( ligne[0], Double.parseDouble( ligne[1] ) ) );
				} catch ( Exception e ) {
					listErreur.add( "Erreur! Creation de Plat : Plat mal formaté -> " + line );
				}

			}
			if ( line.equals( "Plats:" ) ) {
				dansPlats = true;
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

		for ( String line : text ) {
			if ( line.equals( "Plats:" ) || line.equals( "Clients:" ) ) {
				dansCommande = false;
			}
			if ( dansCommande ) {
				try {
					ligne = line.split( " " );
					qte = Integer.parseInt( ligne[2]);
					index = listClient.indexOf( new Client(ligne[0]));
					client = listClient.get( index );

					try {
						index = listPlat.indexOf( new Plat( ligne[1], 0 ) );
						plat = listPlat.get( index );

						commandes.add( new Commande( client, plat, qte ) );
					} catch ( Exception e ) {
						listErreur.add( "Erreur! Creation de Commande : Plat non Creer-> " + line );
					}

				} catch ( Exception e ) {
					listErreur.add( "Erreur! Creation de Commande : Client non Creer -> " + line );
				}

			}

			if ( line.equals( "Commandes:" ) ) {
				dansCommande = true;
			}

		}
		if ( !commandes.isEmpty() ) {
			listCommande = commandes;
		} else {
			listErreur.add( "Erreur! Creation de Commande : Aucune Commande Detecter." );
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
