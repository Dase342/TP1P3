package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tp.Plat;

public class testPlat {

	@Test
	public void testPlatSetNomPlat(){
		Plat un = new Plat("Poutine",10.5);
		un.setNomPlat("Poulet");
		Plat test = new Plat("Poulet", 10.5);
		
		assertEquals(test.getNomPlat(), un.getNomPlat());
		
	}
	
	@Test
	public void testPlatSetPrixPlat(){
		Plat un = new Plat("Poutine",10.5);
		
		un.setPrixPlat(2.5);
		
		Plat test = new Plat("Poutine", 2.5);
		
		assertEquals(test,un);
		
	}
}
