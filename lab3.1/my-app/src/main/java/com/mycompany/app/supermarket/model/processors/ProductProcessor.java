package com.mycompany.app.supermarket.model.processors;

import com.mycompany.app.product.Product;
import javafx.util.Pair;

import java.util.List;

public class ProductProcessor implements IProductProcessor {
	private List<Pair<Product, Float>> _products;

	public ProductProcessor(List<Pair<Product, Float>> products) {
		_products = products;
	}

	@Override
	public void addProducts(List<Pair<Product, Float>> products) {
		for (int i = 0; i < products.size(); ++i) {
			for (int j = 0; j < _products.size(); ++j) {
				if (_products.get(j).getKey().equals(products.get(i).getKey())) {
					Pair<Product, Float> pair = new Pair<>(_products.get(j).getKey(), _products.get(j).getValue() + products.get(i).getValue());
					_products.set(j, pair);

					break;
				}
			}
		}
	}

	@Override
	public List<Pair<Product, Float>> getProducts() {
		return _products;
	}

	@Override
	public void checkProductResidue(int productIndex) {
		if (_products.get(productIndex).getValue() <= 0) {
			_products.remove(productIndex);
		}
	}
}
