package test;


import tp.Facture;
import tp.GererCommande;
import tp.TextFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestsFacture {
	
	Facture facture;
	GererCommande gererCommande;
	String[] text = {"Clients:","Joe","Plats:","Frite 5","Commandes:","Joe Frite 2"}; 
	
	@Before
	public void setUp() {
		gererCommande = new GererCommande(new TextFile(text));
		facture = new Facture(gererCommande);
	}
	@After
	public void tearDown(){
		gererCommande = null;
		facture = null;
	}
	
	@Test
	public void testCalculeTaxes() {
		double testDix = facture.calculeTaxes(10);
		assertEquals(11.5, testDix,0.10);
	}
	
	@Test
	public void testCalculeFacture() {
		
		String[] expected = {"Bienvenue chez Barette!","Factures:","Joe: 11.5$"};
		String[] result = new String[facture.getFacture().size()];
		result = facture.getFacture().toArray(result);
		assertArrayEquals(expected,result);
		
	}
}
