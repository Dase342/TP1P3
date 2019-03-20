package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import tp.Client;
import tp.Commande;
import tp.GererCommande;
import tp.Plat;
import tp.TextFile;

public class gererCommandeTest {
	
	private GererCommande commande;
	private String[] text = {"Clients:","Bob","Plats:","Poulet 5","Commandes:","Bob Poulet 3"};
	
	@Before
	public void avant(){
		commande = new GererCommande(new TextFile(text));
		
	}
	@Test
	public void testUpdate() {
		commande.update();
	
		List<Commande> tempCommande = commande.getCommande();
		
		
		Client exUn = new Client("Bob");
		Plat exDeux = new Plat("Poulet", 5);
		Commande exTrois = new Commande(exUn, exDeux, 3);		
	
		assertEquals(exUn,tempCommande.get(0).getClient());
		assertEquals(exDeux,tempCommande.get(0).getPlat());
		assertEquals(exTrois.getQte(),tempCommande.get(0).getQte());
		
		
	}

	@Test
	public void testCreerClient() {
		commande.creerClient();
		List<Client> tempClient = commande.getClient();
		List<Client> expected = new ArrayList<>();
		expected.add(new Client("Bob"));
		
		
		assertEquals(expected, tempClient);
		
	}
	
	@Test
	public void testCreerPlat(){
		commande.creerPlat();
		List<Plat> tempPlat = commande.getPlat();
		List<Plat> expected = new ArrayList<>();
		expected.add(new Plat("Poulet",5));

	
		
		assertEquals(expected, tempPlat);
		
	}
	
	@Test
	public void testCreerCommande(){
		commande.creerClient();
		commande.creerPlat();
		
		commande.creerCommande();

		List<Commande> tempCommande = commande.getCommande();
		
		
		
		Commande expected = new Commande(new Client("Bob"), new Plat("Poulet",5), 3);
		
	
		
		assertEquals(expected.getClient(), tempCommande.get(0).getClient());
		assertEquals(expected.getPlat(), tempCommande.get(0).getPlat());
		assertEquals(expected.getQte(), tempCommande.get(0).getQte());
	}
	
	
}
