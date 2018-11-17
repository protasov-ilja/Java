package com.company.product;

import com.company.product.enums.ProductMeasuringType;
import com.company.product.enums.ProductType;

public class Product {
	private String _name;
	private ProductType _type;
	private ProductMeasuringType _measuringType;
	private float _price;
	private int _bonusesForPurchasing;
	private float _quantity;
	private boolean _isHasBonuses = false;

	public Product(String name, float price, ProductType type, ProductMeasuringType measuringType, float quantity) {
		_isHasBonuses = true;
		_name = name;
		_price = price;
		_type = type;
		_measuringType = measuringType;
		_quantity = quantity;
	}

	public String getName() {
		return _name;
	}

	public void setName(String value) {
		_name = value;
	}

	public float getPrice() {
		return _price;
	}

	public void setPrice(float value) {
		_price = value;
	}

	public int getBonusesForPurchasing() {
		return _bonusesForPurchasing;
	}

	public void setBonusesForPurchasing(int value) {
		_isHasBonuses = true;
		_bonusesForPurchasing = value;
	}

	public ProductType getType() {
		return _type;
	}

	public void setType(ProductType value) {
		_type = value;
	}

	public ProductMeasuringType getMeasuringType() {
		return _measuringType;
	}

	public void setMeasuringType(ProductMeasuringType value) {
		_measuringType = value;
	}

	public float getQuantity() {
		return _quantity;
	}

	public void setQuantity(float value) {
		_quantity = value;
	}

	public String getInfoByString() {
		return "name: " + getName() + "\t price: " + getPrice();
	}
}
