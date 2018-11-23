package com.company.customer.basket;

import com.company.product.Product;
import com.company.product.Products;

import java.util.ArrayList;
import java.util.List;

public class Basket implements IBasket {
	private List<Products> _products = new ArrayList<>();

	@Override
	public void addProduct(Product product, float amount) {
		_products.add(new Products(product, amount));
	}

	@Override
	public List<Products> getProducts() {
		return _products;
	}

	@Override
	public List<Products> takeAllProducts() {
		List<Products> products = _products;
		_products = new ArrayList<>();

		return products;
	}

	@Override
	public Products takeProducts(int index) {
		return _products.remove(index);
	}
}
