package com.mycompany.app.product.discount;

import com.mycompany.app.product.discount.IDiscount;

public class Discount implements IDiscount {
	private int _value;

	public Discount(int value) {
		if (checkNumberNotNegative(value)) {
			_value = value;
		}
	}

	@Override
	public float getDiscount() {
		return (float)_value;
	}

	private boolean checkNumberNotNegative(int value) {
		return !(value < 0);
	}
}
