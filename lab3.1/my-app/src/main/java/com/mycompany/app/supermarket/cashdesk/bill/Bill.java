package com.mycompany.app.supermarket.cashdesk.bill;

import com.mycompany.app.product.Product;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Bill implements IBill {
	private float _amountOfMoney;
	private float _bonuses;
	private List<Pair<Product, Float>> _products = new ArrayList<>();

	public void add(Pair<Product, Float> product) {
		_products.add(product);
	}

	public void addMoney(float money) {
		_amountOfMoney = money;
	}

	public void addBonuses(float bonuses) {
		_bonuses = bonuses;
	}

	public float getMoney() {
		return _amountOfMoney;
	}

	public float getBonuses() {
		return _bonuses;
	}

	public void showInfo() {
		System.out.println(" BILL");
		for (int i = 0; i < _products.size(); ++i) {
			System.out.println("  " + _products.get(i).getKey().getInfo() + " : " + _products.get(i).getValue());
		}

		System.out.println(" money: " + getMoneyToString() + " bonuses: " + getBonusesToString());
	}

	private String getMoneyToString() {
		return String.format("%.2f", getMoney());
	}

	private String getBonusesToString() {
		return String.format("%.2f", getBonuses());
	}
}
