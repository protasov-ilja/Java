package com.company.supermarket.model.generators;

import com.company.product.Product;
import com.company.product.Products;
import com.company.product.enums.ProductMeasuringType;
import com.company.product.enums.ProductType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductsGenerator implements IProductsGenerator {
	private static final float MAX_PRICE = 3000;
	private static final float MIN_PRICE = 5;

	private List<Products> _products;
	private int _maxNumberOfProducts;
	private int _minNumberOfProducts;

	public List<Products> getListOfProducts() {
		return _products;
	}

	public ProductsGenerator(int minNumberOfProducts, int maxNumberOfProducts) {
		_minNumberOfProducts = minNumberOfProducts;
		_maxNumberOfProducts = maxNumberOfProducts;
		generateListOfProducts();
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

	private Products generateRandomProducts(Product product) {
		Random rand = new Random();
		float randomQuantity = rand.nextFloat() * ((100 - 10) + 1) + 10;
		return new Products(product, randomQuantity);
	}

	private void generateListOfProducts() {
		Random rand = new Random();
		int productsNumber = rand.nextInt((_maxNumberOfProducts - _minNumberOfProducts) + 1) + _minNumberOfProducts;
		System.out.println(productsNumber);
		_products = new ArrayList<>();
		for (int i = 0; i < productsNumber; ++i) {
			_products.add(generateRandomProducts(generateRandomProduct(i)));
			System.out.println(_products.get(i).getInfo());
		}

		System.out.println("size: " + _products.size());
	}
}
