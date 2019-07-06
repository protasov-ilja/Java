package com.company.supermarket.model.generators;

import com.company.product.Product;
import com.company.product.enums.ProductMeasuringType;
import com.company.product.enums.ProductType;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsGenerator implements IProductsGenerator {
	private static final float MAX_PRICE = 3000;
	private static final float MIN_PRICE = 5;

	private List<Pair<Product, Float>> _products;
	private int _maxNumberOfProducts;
	private int _minNumberOfProducts;

	public ProductsGenerator(int minNumberOfProducts, int maxNumberOfProducts) {
		_minNumberOfProducts = minNumberOfProducts;
		_maxNumberOfProducts = maxNumberOfProducts;
		generateListOfProducts();
	}

	@Override
	public List<Pair<Product, Float>> getListOfProducts() {
		return _products;
	}

	private Product generateRandomProduct(int index) {
		Random rand = new Random();
		ProductType randomType = ProductType.values()[rand.nextInt(ProductType.values().length)];
		ProductMeasuringType randomMeasureType = ProductMeasuringType.values()[rand.nextInt(ProductMeasuringType.values().length)];
		float randomPrice = rand.nextFloat() * ((MAX_PRICE - MIN_PRICE) + 1) + MIN_PRICE;
		String name = "product" + index;
		Product product = new Product(name, randomPrice, randomType, randomMeasureType);
		boolean isHasBonuses = rand.nextBoolean();
		if (isHasBonuses) {
			int bonuses = rand.nextInt((100 - 1) + 1) + 1;
			product.setBonusesForPurchasing(bonuses);
		}

		return product;
	}

	private Pair<Product, Float> generateRandomProducts(Product product) {
		Random rand = new Random();
		float randomQuantity = rand.nextFloat() * ((100 - 10) + 1) + 10;
		return new Pair<>(product, randomQuantity);
	}

	private void generateListOfProducts() {
		Random rand = new Random();
		int productsNumber = rand.nextInt((_maxNumberOfProducts - _minNumberOfProducts) + 1) + _minNumberOfProducts;
		_products = new ArrayList<>();
		for (int i = 0; i < productsNumber; ++i) {
			_products.add(generateRandomProducts(generateRandomProduct(i)));
		}
	}
}
