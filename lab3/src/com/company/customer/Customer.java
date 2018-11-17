package com.company.customer;


import com.company.customer.basket.Basket;
import com.company.customer.enums.CustomerCategory;

public class Customer {
	private CustomerCategory _category;
	private Basket _basket = new Basket();

	public CustomerCategory SetCustomerCategory() {
		return _category;
	}

	public void GetCustomerCategory(CustomerCategory category) {
		_category = category;
	}

	private void Pay() {

	}

	private void PutInBasket() {

	}
}
