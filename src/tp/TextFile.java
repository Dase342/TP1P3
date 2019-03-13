package tp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFile{

	private String[] file;
	
	public TextFile(String path){
		try {
			  String filestring = new Scanner(new File(path)).useDelimiter("\\A").next();
			  file = filestring.split( "\\r\\n" );
			  
		} catch (IOException e) {
			System.out.println( "Introuvable : " + path );
		}
	}
	
	public String[] getText() {
		return file;
	}
	@Deprecated 
	public List<Client> getClient(){
		List<Client> client = new ArrayList<Client>();
		boolean dansClient = false;
		
		for ( int i = 0; i < file.length; i++ ) {
			if ( file[i].equals( "Clients:" ) ) {
				dansClient = true;
			} else if ( file[i].equals( "Plats:" ) ) {
				dansClient = false;
			} else if ( dansClient ) {
				client.add( new Client( file[i] ) );
			}

		}
		return client;
	}
	@Deprecated
	public List<Plat> getPlat(){
		List<Plat> plats = new ArrayList<Plat>();
		boolean dansPlats = false;
		String[] ligne = null;
		
		for ( int i = 0; i < file.length; i++ ) {
			if ( file[i].equals( "Plats:" ) ) {
				dansPlats = true;
			} else if ( file[i].equals( "Commandes:" ) ) {
				dansPlats = false;
			} else if ( dansPlats ) {
				ligne = file[i].split( " " );
				plats.add( new Plat( ligne[0], Double.parseDouble( ligne[1] ) ) );
			}
		}
		return plats;
	}
	@Deprecated
	public List<Commande> getCommandes(List<Client> listClient, List<Plat> listPlat){
			List<Commande> commandes = new ArrayList<Commande>();
			Client client;
			Plat plat;
			int qte;
			
			boolean dansCommande= false;
			String[] ligne;
			int index = -1;

		for ( int i = 0; i < file.length; i++ ) {

			if ( file[i].equals( "Commandes:" ) ) {
				dansCommande = true;
			} else if ( dansCommande ) {
				ligne = file[i].split( " " );				
				qte = Integer.parseInt( ligne[2] );
				index = listClient.indexOf( new Client( ligne[0] ) );
				client = listClient.get( index );
				index = listPlat.indexOf( new Plat( ligne[1], 0 ) );

				plat = listPlat.get( index );
				commandes.add( new Commande( client, plat, qte ) );

			}
		}

		return commandes;

	}

}
