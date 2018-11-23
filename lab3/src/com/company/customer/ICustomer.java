package com.company.customer;

import com.company.customer.enums.CustomerCategory;
import com.company.customer.enums.StatesInSupermarket;
import com.company.product.Products;

import java.util.List;

public interface ICustomer {
	CustomerCategory getCustomerCategory();

	List<Products> getProductsFromBasket();

	String getName();

	StatesInSupermarket getCurrState();

	void chooseCurrState();

	List<Products> returnAllProducts();

	Products returnProducts(int index);

	float pay(float amountOfMoney);

	int putProductInBasket(List<Products> products);
}
