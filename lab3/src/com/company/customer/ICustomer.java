package com.company.customer;

import com.company.customer.enums.CustomerCategory;
import com.company.customer.enums.StatesInSupermarket;
import com.company.product.Product;
import javafx.util.Pair;

import java.util.List;

public interface ICustomer {
	CustomerCategory getCustomerCategory();

	List<Pair<Product, Float>> getProductsFromBasket();

	String getName();

	StatesInSupermarket getCurrState();

	void chooseCurrState();

	List<Pair<Product, Float>> returnAllProducts();

	Pair<Product, Float> returnProducts(int index);

	boolean pay(float amountOfMoney);

	int putProductInBasket(List<Pair<Product, Float>> products);
}
