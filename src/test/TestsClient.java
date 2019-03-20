package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import tp.Client;

public class TestsClient {
	public Client joe;
	
	@Before
	public void setUp() {
		joe = new Client("Joe");
	}
	@After
	public void tearDown(){
		joe = null;
	}
	
	@Test
	public void testSetNom() {
		String expected = "Bill";
		joe.setNom( expected );
		
		assertEquals(expected,joe.getNom());
	}
	@Test
	public void testSetTotal() {
		double expected = 20;
		joe.setTotal( expected );
		
		assertEquals(expected,joe.getTotal(),0.01);
	}
	@Test
	public void testAddTotal() {
		double expected = 30;
		joe.addTotal( expected );
		
		assertEquals(expected,joe.getTotal(),0.01);
	}

}
