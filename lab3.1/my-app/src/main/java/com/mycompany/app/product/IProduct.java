package com.mycompany.app.product;

import com.mycompany.app.product.enums.ProductMeasuringType;
import com.mycompany.app.product.enums.ProductType;

public interface IProduct {
	String getName();

	double getPrice();

	int getBonusesForPurchasing();

	void addBonusesForPurchasing(int value);

	ProductType getType();

	ProductMeasuringType getMeasuringType();

	void createDiscount(int coeff);

	float getDiscount();

	boolean isHasBonuses();

	boolean isHasDiscount();
}
