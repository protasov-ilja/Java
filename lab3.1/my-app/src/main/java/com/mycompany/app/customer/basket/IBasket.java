package com.mycompany.app.customer.basket;

import com.mycompany.app.product.Product;
import javafx.util.Pair;

import java.util.List;

public interface IBasket {
	void addProduct(Product product, float amount);

	List<Pair<Product, Float>> getProducts();

	List<Pair<Product, Float>> takeAllProducts();

	Pair<Product, Float> takeProducts(int index);
}
