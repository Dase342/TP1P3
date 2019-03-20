package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tp.Client;
import tp.Commande;
import tp.Plat;

public class TestsCommande {

	private Client client;
	private Plat plat;
	private Commande commande;
	@Before
	public void setUp() throws Exception {
		client = new Client ("Joe");
		plat = new Plat ("Frite",5.50);
		commande = new Commande(client,plat,1);
	}

	@After
	public void tearDown() throws Exception {
		client = null;
		plat = null;
		commande = null;
		}

	@Test
	public void testSetClient() {
		Client expected = new Client("Bob");
		
		commande.setClient( expected );
		
		assertEquals(expected,commande.getClient());
	}
	
	public void testSetPlat() {
		Plat expected = new Plat("Poutine",10.99);
		
		commande.setPlat( expected );
		
		assertEquals(expected,commande.getPlat());
	}

}
