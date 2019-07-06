package com.mycompany.app.supermarket.model.generators;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductsGeneratorTest {

	@Test
	public void getListOfProducts() {
		ProductsGenerator pG = new ProductsGenerator(0, 0);
		assertEquals(pG.getListOfProducts().size(), 0);

		pG = new ProductsGenerator(0, 1);
		if ((pG.getListOfProducts().size() <= 1) && (pG.getListOfProducts().size() >= 0)) {
			assertTrue(true);
		} else {
			fail("false");
		}

		pG = new ProductsGenerator(1, 10);
		if ((pG.getListOfProducts().size() <= 10) && (pG.getListOfProducts().size() >= 1)) {
			assertTrue(true);
		} else {
			fail("false");
		}
	}
}