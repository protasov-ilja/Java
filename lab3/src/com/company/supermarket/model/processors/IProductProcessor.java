package com.company.supermarket.model.processors;

import com.company.product.Product;
import javafx.util.Pair;

import java.util.List;

public interface IProductProcessor {
	void addProducts(List<Pair<Product, Float>> products);

	List<Pair<Product, Float>> getProducts();

	void checkProductResidue(int productIndex);
}
