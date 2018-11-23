package com.company.supermarket.model.processors;

import com.company.product.Products;

import java.util.List;

public class ProductProcessor implements IProductProcessor{
	private List<Products> _products;
	private List<Products> _soldedProducts;

	public ProductProcessor(List<Products> products) {
		_products = products;
	}

	public void addProducts(List<Products> products) {
		for (int i = 0; i < products.size(); ++i) {

		}
	}

	public List<Products> getProducts() {
		return _products;
	}

	public void checkProductResidue(int productIndex) {
		if (_products.get(productIndex).getQuantity() == 0) {
			_products.remove(productIndex);
		}
	}
}
