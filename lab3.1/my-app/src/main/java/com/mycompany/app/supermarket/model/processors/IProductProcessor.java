package com.mycompany.app.supermarket.model.processors;

import com.mycompany.app.product.Product;
import javafx.util.Pair;

import java.util.List;

public interface IProductProcessor {
	void addProducts(List<Pair<Product, Float>> products);

	List<Pair<Product, Float>> getProducts();

	void checkProductResidue(int productIndex);
}
