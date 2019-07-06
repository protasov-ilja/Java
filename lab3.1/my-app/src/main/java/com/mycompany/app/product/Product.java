package com.mycompany.app.product;

import com.mycompany.app.product.discount.Discount;
import com.mycompany.app.product.discount.IDiscount;
import com.mycompany.app.product.enums.ProductMeasuringType;
import com.mycompany.app.product.enums.ProductType;
import com.mycompany.app.supermarket.utils.IInfo;

public class Product implements IProduct, IInfo {
	private String _name;
	private ProductType _type;
	private ProductMeasuringType _measuringType;
	private IDiscount _discount;
	private double _price;
	private int _bonusesForPurchasing;
	private boolean _isHasBonuses = false;
	private boolean _isHasDiscount = false;

	public Product(String name, double price, ProductType type, ProductMeasuringType measuringType) {
		_name = name;
		if (isPricePositiveNumber(price)) {
			_price = price;
		}

		_type = type;
		_measuringType = measuringType;
	}

	private boolean isPricePositiveNumber(double price) {
		return price >= 0;
	}

	@Override
	public void createDiscount(int coeff) {
		_isHasDiscount = true;
		_discount = new Discount(coeff);
	}

	@Override
	public float getDiscount() {
		return (100 - _discount.getDiscount()) / 100;
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public double getPrice() {
		return _price;
	}

	@Override
	public int getBonusesForPurchasing() {
		return _bonusesForPurchasing;
	}

	@Override
	public void addBonusesForPurchasing(int value) {
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

	private String priceToString() {
		return String.format("%.2f", _price);
	}

	@Override
	public String getInfo() {
		return ("name: " + getName() + "\t price: " + priceToString() +
				" type: " + getType() + (_isHasBonuses ? (" bonuses: " + getBonusesForPurchasing()) : ""));
	}

	@Override
	public boolean isHasBonuses() {
		return _isHasBonuses;
	}

	@Override
	public boolean isHasDiscount() {
		return _isHasDiscount;
	}
}
