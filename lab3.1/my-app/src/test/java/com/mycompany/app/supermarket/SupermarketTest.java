package com.mycompany.app.supermarket;

import org.junit.Test;

import static org.junit.Assert.*;

public class SupermarketTest {

	@Test
	public void work() {
		try {
			Supermarket supermarket = new Supermarket("00:00", "23:59");
			supermarket.work();
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}
}