package com.mycompany.app.customer.paymentmethod;

import org.junit.Test;

import static org.junit.Assert.*;

public class PaymentMethodTest {

	@Test
	public void CreatePaymentMethod() {
		PaymentMethod payMethod = new PaymentMethod(12, 21, 12);
		assertEquals(payMethod.getAllMoney(), (12 + 21 + 12), 0.05);
		assertEquals(payMethod.getCash(), 12,0.05);
		assertEquals(payMethod.getBankCard(), 21,0.05);
		assertEquals(payMethod.getBonuses(), 12,0.05);

		payMethod = new PaymentMethod(0, 0, 0);
		assertEquals(payMethod.getAllMoney(), 0, 0.05);
		assertEquals(payMethod.getCash(), 0,0.05);
		assertEquals(payMethod.getBankCard(), 0,0.05);
		assertEquals(payMethod.getBonuses(), 0,0.05);

		payMethod = new PaymentMethod(-1, -1, -1);
		assertEquals(payMethod.getAllMoney(), 0, 0.05);
		assertEquals(payMethod.getCash(), 0,0.05);
		assertEquals(payMethod.getBankCard(), 0,0.05);
		assertEquals(payMethod.getBonuses(), 0,0.05);
	}

	@Test
	public void addBonuses() {
		PaymentMethod payMethod = new PaymentMethod(12, 21, 10);
		payMethod.addBonuses(1);
		assertEquals(payMethod.getBonuses(), 11,0.05);
	}

	@Test
	public void getCash() {
		PaymentMethod payMethod = new PaymentMethod(12, 21, 12);
		assertEquals(payMethod.getCash(), 12,0.05);
	}

	@Test
	public void getBankCard() {
		PaymentMethod payMethod = new PaymentMethod(12, 21, 12);
		assertEquals(payMethod.getBankCard(), 21,0.05);
	}

	@Test
	public void getBonuses() {
		PaymentMethod payMethod = new PaymentMethod(12, 21, 12);
		assertEquals(payMethod.getBonuses(), 12,0.05);
	}

	@Test
	public void getAllMoney() {
		PaymentMethod payMethod = new PaymentMethod(12, 21, 12);
		assertEquals(payMethod.getAllMoney(), (12 + 21 + 12), 0.05);
	}

	@Test
	public void processMoneyForPaying() {
		PaymentMethod payMethod = new PaymentMethod(10, 10, 10);
		assertTrue(payMethod.processMoneyForPaying(30));
		assertEquals(payMethod.getAllMoney(), 0, 0.05);

		assertFalse(payMethod.processMoneyForPaying(1));
		assertEquals(payMethod.getAllMoney(), 0, 0.05);

		payMethod = new PaymentMethod(10, 10, 10);
		assertTrue(payMethod.processMoneyForPaying(15));
		assertEquals(payMethod.getAllMoney(), 15, 0.05);
		assertEquals(payMethod.getCash(), 0,0.05);
		assertEquals(payMethod.getBankCard(), 5,0.05);
		assertEquals(payMethod.getBonuses(), 10,0.05);
	}
}