package com.mycompany.app.supermarket.model.generators;

import com.mycompany.app.customer.Customer;
import com.mycompany.app.customer.enums.CustomerCategory;
import com.mycompany.app.customer.paymentmethod.PaymentMethod;

import java.util.Random;

public class CustomerGenerator implements ICustomerGenerator {
	private final static float MIN_MONEY_AMOUNT = 5;
	private final static float MAX_MONEY_AMOUNT = 1000;
	private final static int MIN_BONUSES_AMOUNT = 0;
	private final static int MAX_BONUSES_AMOUNT = 1000;
	private final static String CUSTOMER_NAME = "customer";

	private int _index = 0;

	private Customer createNewCustomer() {
		Random rand = new Random();
		int randCategoryIndex = rand.nextInt(CustomerCategory.values().length);
		CustomerCategory category = CustomerCategory.values()[randCategoryIndex];
		String name = CUSTOMER_NAME + _index;
		float cash = rand.nextFloat() * ((MAX_MONEY_AMOUNT - MIN_MONEY_AMOUNT) + 1) + MIN_MONEY_AMOUNT;
		float bankCard = rand.nextFloat() * ((MAX_MONEY_AMOUNT - MIN_MONEY_AMOUNT) + 1) + MIN_MONEY_AMOUNT;
		int bonuses = rand.nextInt((MAX_BONUSES_AMOUNT - MIN_BONUSES_AMOUNT) + 1) + MIN_BONUSES_AMOUNT;
		PaymentMethod method = new PaymentMethod(cash, bankCard, bonuses);
		_index++;

		return new Customer(name, category, method);
	}

	@Override
	public Customer getNewCustomer() {
		return createNewCustomer();
	}
}
