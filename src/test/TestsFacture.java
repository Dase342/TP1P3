package test;

import tp.Client;
import tp.Commande;
import tp.Plat;
import tp.TextFile;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

class TestsFacture {
	
	Facture facture;
	
	@Mock
	private GererCommande gererCommande;
	
	@Before
	void setUp() {
		List<Client> testListClient = new ArrayList<Client>();
		testListClient.add( new Client("Joe") );
		
		List<Commande> testListCommande = new ArrayList<Commande>();
		testListCommande.add(new Commande( new Client("Joe"), new Plat("poutine",15),2 ));
		
		Mockito.when(gererCommande.getClient()).thenReturn(testListClient);
		Mockito.when(gererCommande.getCommande()).thenReturn(testListCommande);
		
	}
	@After
	void tearDown(){
		gererCommande = null;
	}
	
	@Test
	void testCalculeTaxes() {
		double testDix = Facture.calculeTaxes(10);
		assertEquals(11.5, testDix,0.01);
	}
	
	@Test
	void testCalculeFacture() {
		facture = new Facture(gererCommande);
		String[] expected = {"","",""};
		String[] result = {"","",""};
		
		result = facture.getFacture;
		assertArrayEquals(expected,result);
	}
}
