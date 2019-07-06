package com.mycompany.app.product;

import com.mycompany.app.product.enums.ProductMeasuringType;
import com.mycompany.app.product.enums.ProductType;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {
	@Test
	public void createProduct() {
		Product product = new Product("product", 100, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		assertEquals(product.getName(), "product");
		assertEquals(product.getPrice(), 100, 0.05);
		assertEquals(product.getType(), ProductType.ALLOWED_FOR_CHILDREN);
		assertEquals(product.getMeasuringType(), ProductMeasuringType.BY_WEIGHT);

		product = new Product("product", 0, ProductType.NOT_ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_QUANTITY);
		assertEquals(product.getName(), "product");
		assertEquals(product.getPrice(), 0, 0.05);
		assertEquals(product.getType(), ProductType.NOT_ALLOWED_FOR_CHILDREN);
		assertEquals(product.getMeasuringType(), ProductMeasuringType.BY_QUANTITY);

		product = new Product("product", -1, ProductType.NOT_ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_QUANTITY);
		assertEquals(product.getName(), "product");
		assertEquals(product.getPrice(), 0, 0.05);
		assertEquals(product.getType(), ProductType.NOT_ALLOWED_FOR_CHILDREN);
		assertEquals(product.getMeasuringType(), ProductMeasuringType.BY_QUANTITY);
	}

	@Test
	public void createDiscount() {
		Product product = new Product("product", 100, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		assertFalse(product.isHasDiscount());
		product.createDiscount(10);
		assertTrue(product.isHasDiscount());
		assertEquals(product.getDiscount(), 0.9, 0.05);
	}

	@Test
	public void getName() {
		Product product = new Product("product", 100, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		assertEquals(product.getName(), "product");
	}

	@Test
	public void getPrice() {
		Product product = new Product("product", 100, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		assertEquals(product.getPrice(), 100, 0.05);
	}

	@Test
	public void getBonusesForPurchasing() {
		Product product = new Product("product", 100, ProductType.NOT_ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		product.addBonusesForPurchasing(10);
		assertEquals(product.getBonusesForPurchasing(), 10);
	}

	@Test
	public void addBonusesForPurchasing() {
		Product product = new Product("product", 100, ProductType.NOT_ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		product.addBonusesForPurchasing(10);
		assertEquals(product.getBonusesForPurchasing(), 10);
	}

	@Test
	public void getType() {
		Product product = new Product("product", 100, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		assertEquals(product.getType(), ProductType.ALLOWED_FOR_CHILDREN);
	}

	@Test
	public void getMeasuringType() {
		Product product = new Product("product", 100, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		assertEquals(product.getMeasuringType(), ProductMeasuringType.BY_WEIGHT);
	}

	@Test
	public void getInfo() {
		Product product = new Product("product", 100, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		assertEquals(product.getInfo(), "name: product\t price: 100,00 type: ALLOWED_FOR_CHILDREN");

		product = new Product("product", 100, ProductType.NOT_ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		product.addBonusesForPurchasing(10);
		assertEquals(product.getInfo(), "name: product\t price: 100,00 type: NOT_ALLOWED_FOR_CHILDREN bonuses: 10");
	}

	@Test
	public void isHasBonuses() {
		Product product = new Product("product", 100, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		assertFalse(product.isHasBonuses());
		product.addBonusesForPurchasing(10);
		assertTrue(product.isHasBonuses());
	}

	@Test
	public void isHasDiscount() {
		Product product = new Product("product", 100, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		assertFalse(product.isHasDiscount());
		product.createDiscount(30);
		assertTrue(product.isHasDiscount());
	}
}