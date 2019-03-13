package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import tp.Client;
import tp.Commande;
import tp.GererCommande;
import tp.Plat;

public class gererCommandeTest {
	
	private GererCommande commande;
	
	@Before
	public void avant(){
		commande = Mockito.mock(GererCommande.class);
		
	}
	@Test
	public void testUpdate() {
		commande.update();
		List<Client> tempClient = commande.getClient();
		List<Plat> tempPlat = commande.getPlat();
		List<Commande> tempCommande = commande.getCommande();
		
		List<Client> exUn = new ArrayList<>();
		List<Plat> exDeux = new ArrayList<>();
		List<Commande> exTrois = new ArrayList<>();
		
		assertEquals(exUn, tempClient);
		assertEquals(exDeux, tempPlat);
		assertEquals(exTrois, tempCommande);
	}

	@Test
	public void testCreerClient() {
		commande.creerClient();
		List<Client> tempClient = commande.getClient();
		List<Client> expected = new ArrayList<>();
		expected.add(new Client("Roger"));
		expected.add(new Client("Céline"));
		expected.add(new Client("Steeve"));
		
		assertEquals(expected, tempClient);
	}
	
	@Test
	public void testCreerPlat(){
		commande.creerPlat();
		List<Plat> tempPlat = commande.getPlat();
		List<Plat> expected = new ArrayList<>();
		expected.add(new Plat("Poutine",10.5));
		expected.add(new Plat("Frites",2.5));
		expected.add(new Plat("Repas_Poulet",15.75));
	
		
		assertEquals(expected, tempPlat);
		
	}
	
	@Test
	public void testCreerCommande(){

		
		commande.creerCommande();

		List<Commande> tempCommande = commande.getCommande();
		List<Commande> expected = new ArrayList<>();
		
		
		expected.add(new Commande(new Client("Roger"), new Plat("Poutine",10.5), 1));
		expected.add(new Commande(new Client("Céline"), new Plat("Frites",2.5), 2));
		expected.add(new Commande(new Client("Steeve"), new Plat("Repas_Poulet",15.75), 1));
		
	
		
		assertEquals(expected, tempCommande);
	}
	
	
}
