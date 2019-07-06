package com.mycompany.app.product.discount;

import org.junit.Test;

import static org.junit.Assert.*;

public class DiscountTest {

	@Test
	public void createDiscount() {
		Discount discount = new Discount(12);
		assertEquals(discount.getDiscount(), 12, 0.05);

		discount = new Discount(0);
		assertEquals(discount.getDiscount(), 0, 0.05);

		discount = new Discount(-1);
		assertEquals(discount.getDiscount(), 0, 0.05);
	}

	@Test
	public void getDiscount() {
		Discount discount = new Discount(50);
		assertEquals(discount.getDiscount(), 50, 0.05);
	}
}