package test;

import org.mockito.Mock;
import org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class TestsFacture {

	@Mock
	private gererCommande;
	private list<String> listString;
	
	@Test
	void testCalculeTaxes() {
		double testDix = Facture.calculeTaxes(10);
		assertEquals(11.5, testDix,0.01);
	}
	@Test
	void testCalculeFacture() {
		fail( "Not yet implemented" );
	}

}
