package com.company.supermarket;

import com.company.product.Product;
import com.company.product.enums.ProductMeasuringType;
import com.company.product.enums.ProductType;
import com.company.supermarket.cashdesk.CashDesk;
import com.company.supermarket.report.Report;
import com.company.supermarket.timer.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Supermarket {
	private List<Product> _listOfProducts;
	private CashDesk _cashDesk;
	private Report _report;
	private int _maxNumberOfProducts = 20;
	private int _minNumberOfProducts = 10;
	private int _productsNumber;
	private List<Product> _listOfSoldProducts = new ArrayList<>();
	private Time _currTime;
	private Time _startWorkingTime;
	private Time _endWorkingTime;

	public Supermarket() {
		GenerateListOfProducts();
		_currTime = new Time("23:00:23");
		System.out.println(_currTime.getInfo());
	}

	private void GenerateListOfProducts() {
		Random rand = new Random();
		_productsNumber = rand.nextInt((_maxNumberOfProducts - _minNumberOfProducts) + 1) + _minNumberOfProducts;
		System.out.println(_productsNumber);
		_listOfProducts = new ArrayList<>();
		for (int i = 0; i < _productsNumber; ++i) {
			_listOfProducts.add(GenerateRandomProduct(i));
			System.out.println(_listOfProducts.get(i).getInfoByString());
		}

		System.out.println(_listOfProducts.size());
	}

	private Product GenerateRandomProduct(int index) {
		Random rand = new Random();
		ProductType randomType = rand.nextBoolean() ? ProductType.ALLOWED_FOR_CHILDREN : ProductType.NOT_ALLOWED_FOR_CHILDREN;
		ProductMeasuringType randomMeasureType = rand.nextBoolean() ? ProductMeasuringType.BY_QUANTITY : ProductMeasuringType.BY_WEIGHT;
		float randomQuantity = rand.nextFloat() * ((100 - 10) + 1) + 10;
		float randomPrice = rand.nextFloat() * ((1000 - 1) + 1) + 1;
		String name = "product" + index;
		Product product = new Product(name, randomPrice, randomType, randomMeasureType, randomQuantity);
		boolean isHasBonuses = rand.nextBoolean();
		if (isHasBonuses)
		{
			int bonuses = rand.nextInt((100 - 1) + 1) + 1;
			product.setBonusesForPurchasing(bonuses);
		}

		return product;
	}

	// set time
	//


}
