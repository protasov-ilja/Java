package com.company.customer.basket;

import com.company.product.Product;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Basket implements IBasket {
	private List<Pair<Product, Float>> _products = new ArrayList<>();

	@Override
	public void addProduct(Product product, float amount) {
		_products.add(new Pair<>(product, amount));
	}

	@Override
	public List<Pair<Product, Float>> getProducts() {
		return _products;
	}

	@Override
	public List<Pair<Product, Float>> takeAllProducts() {
		List<Pair<Product, Float>> products = _products;
		_products = new ArrayList<>();

		return products;
	}

	@Override
	public Pair<Product, Float> takeProducts(int index) {
		return _products.remove(index);
	}
}
