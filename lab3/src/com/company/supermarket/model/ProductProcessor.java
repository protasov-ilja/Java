package com.company.supermarket.model;

import com.company.product.Product;

import java.util.List;

public class ProductProcessor {
	private List<Product> _products;
	private List<Product> _soldedProducts;

	public ProductProcessor(List<Product> products) {
		_products = products;
	}
}
