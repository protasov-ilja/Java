package com.mycompany.app.customer.basket;

import com.mycompany.app.product.Product;
import com.mycompany.app.product.enums.ProductMeasuringType;
import com.mycompany.app.product.enums.ProductType;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BasketTest {

	@Test
	public void addProduct() {
		Basket basket = new Basket();
		Product p = new Product("1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		basket.addProduct(p, 0);
		assertEquals(basket.getProducts().size(), 0);

		basket.addProduct(p, 1);
		assertEquals(basket.getProducts().size(), 1);
		List<Pair<Product, Float>> l = new ArrayList<>();
		l.add(new Pair<>(p, 1f));

		assertEquals(basket.getProducts(), l);
	}

	@Test
	public void getProducts() {
		Basket basket = new Basket();
		Product p = new Product("1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		basket.addProduct(p, 1);
		assertEquals(basket.getProducts().size(), 1);
		List<Pair<Product, Float>> l = new ArrayList<>();
		l.add(new Pair<>(p, 1f));

		assertEquals(basket.getProducts(), l);
	}

	@Test
	public void takeAllProducts() {
		Basket basket = new Basket();
		Product p = new Product("1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		basket.addProduct(p, 1);
		assertEquals(basket.getProducts().size(), 1);
		List<Pair<Product, Float>> l = new ArrayList<>();
		l.add(new Pair<>(p, 1f));
		assertEquals(basket.takeAllProducts(), l);
		assertEquals(basket.getProducts().size(), 0);
	}

	@Test
	public void takeProducts() {
		Basket basket = new Basket();
		Product p = new Product("1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		basket.addProduct(p, 1);
		assertEquals(basket.getProducts().size(), 1);
		Pair<Product, Float> tempProduct = new Pair<>(p, 1f);
		assertEquals(basket.takeProducts(0), tempProduct);
		assertEquals(basket.getProducts().size(), 0);
	}
}