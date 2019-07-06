package com.company.product;

import com.company.product.discount.Discount;
import com.company.product.enums.ProductMeasuringType;
import com.company.product.enums.ProductType;

public class Product implements IProduct {
	private String _name;
	private ProductType _type;
	private ProductMeasuringType _measuringType;
	private Discount _discount = new Discount();
	private float _price;
	private int _bonusesForPurchasing;
	private boolean _isHasBonuses = false;

	public Product(String name, float price, ProductType type, ProductMeasuringType measuringType) {
		_name = name;
		_price = price;
		_type = type;
		_measuringType = measuringType;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public float getPrice() {
		return _price;
	}

	@Override
	public int getBonusesForPurchasing() {
		return _bonusesForPurchasing;
	}

	@Override
	public void setBonusesForPurchasing(int value) {
		_isHasBonuses = true;
		_bonusesForPurchasing = value;
	}

	@Override
	public ProductType getType() {
		return _type;
	}

	@Override
	public ProductMeasuringType getMeasuringType() {
		return _measuringType;
	}

	@Override
	public String getInfoByString() {
		return "name: " + getName() + "\t price: " + getPrice();
	}
}
