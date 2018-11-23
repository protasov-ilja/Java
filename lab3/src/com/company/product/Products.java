package com.company.product;

public class Products {
	private Product _product;
	private float _quantity;

	public Products(Product product, float quantity) {
		_product = product;
		_quantity = quantity;
	}

	public Product getProduct() {
		return _product;
	}

	public float getQuantity() {
		return _quantity;
	}

	public void setQuantity(float value) {
		_quantity = value;
	}

	public String getInfo() {
		return _product.getInfoByString() + " amount: " + getQuantity();
	}
}
