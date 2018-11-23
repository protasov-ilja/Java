package com.company.product;

import com.company.product.enums.ProductMeasuringType;
import com.company.product.enums.ProductType;

public interface IProduct {
	String getName();

	float getPrice();

	int getBonusesForPurchasing();

	void setBonusesForPurchasing(int value);

	ProductType getType();

	ProductMeasuringType getMeasuringType();

	String getInfoByString();
}
