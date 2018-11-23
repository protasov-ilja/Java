package com.company.customer.basket;

import com.company.product.Product;
import com.company.product.Products;

import java.util.ArrayList;
import java.util.List;

public interface IBasket {
	void addProduct(Product product, float amount);
	List<Products> getProducts();
	List<Products> takeAllProducts();
	Products takeProducts(int index);
}
