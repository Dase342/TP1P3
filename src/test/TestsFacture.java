package test;

import org.mockito.Mock;
import org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class TestsFacture {

	@Mock
	private GererCommande gererCommande;
	
	@Before
	void setUp() {
		
	}
	@After
	void tearDown(){
		
	}
	@Test
	void testCalculeTaxes() {
		double testDix = Facture.calculeTaxes(10);
		assertEquals(11.5, testDix,0.01);
	}

}
