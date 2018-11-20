package com.company.customer;

import com.company.customer.basket.Basket;
import com.company.customer.enums.CustomerCategory;
import com.company.customer.enums.StatesInSupermarket;
import com.company.customer.paymentmethod.PaymentMethod;
import com.company.product.Product;

import java.util.Random;

public class Customer {
	private String _name;
	private CustomerCategory _category;
	private Basket _basket = new Basket();
	private PaymentMethod _paymentMethod;
	private StatesInSupermarket _currState;
	private int _waitTimeInMinutes;

	public Customer(String name, CustomerCategory category, PaymentMethod method) {
		_name = name;
		_category = category;
		_paymentMethod = method;
	}

	public CustomerCategory setCustomerCategory() {
		return _category;
	}

	public void getCustomerCategory(CustomerCategory category) {
		_category = category;
	}

	private void pay() {

	}

	private void putInBasket(Product product) {
		_basket.AddProduct(product);
	}

	public void chooseCurrState() {
		if (_waitTimeInMinutes == 0) {
			Random rand = new Random();
			if (_basket.getProducts().size() != 0) {
				_currState = StatesInSupermarket.values()[rand.nextInt(StatesInSupermarket.values().length)];
			} else {
				_currState = rand.nextBoolean() ? StatesInSupermarket.WANT_TO_TAKE_PRODUCT : StatesInSupermarket.WANT_TO_EXIT;
			}
		}
	}

	public void setWaitTimeInMinutes(int waitTime) {
		_waitTimeInMinutes = waitTime;
	}

	public void decreaseTime() {
		if (_waitTimeInMinutes != 0) {
			_waitTimeInMinutes--;
		}
	}

	public StatesInSupermarket getCurrState() {
		return _currState;
	}

	public String getName() {
		return _name;
	}
}
