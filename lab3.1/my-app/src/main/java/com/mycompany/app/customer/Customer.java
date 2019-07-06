package com.mycompany.app.customer;

import com.mycompany.app.customer.basket.Basket;
import com.mycompany.app.customer.basket.IBasket;
import com.mycompany.app.customer.enums.CustomerCategory;
import com.mycompany.app.customer.enums.StatesInSupermarket;
import com.mycompany.app.customer.paymentmethod.PaymentMethod;
import com.mycompany.app.product.Product;
import com.mycompany.app.supermarket.utils.IInfo;
import com.mycompany.app.supermarket.utils.Logger;
import javafx.util.Pair;

import java.util.List;
import java.util.Random;

public class Customer implements ICustomer, IInfo {
	private String _name;
	private CustomerCategory _category;
	private IBasket _basket = new Basket();
	private PaymentMethod _paymentMethod;
	private StatesInSupermarket _currState;
	private double _estimatedCosts = 0;

	public Customer(String name, CustomerCategory category, PaymentMethod method) {
		_name = name;
		_category = category;
		_paymentMethod = method;
		_currState = StatesInSupermarket.WALK;
	}

	@Override
	public CustomerCategory getCustomerCategory() {
		return _category;
	}

	@Override
	public List<Pair<Product, Float>> getProductsFromBasket() {
		return _basket.getProducts();
	}

	@Override
	public List<Pair<Product, Float>> returnAllProducts() {
		return _basket.takeAllProducts();
	}

	@Override
	public Pair<Product, Float> returnProducts(int index) {
		return _basket.takeProducts(index);
	}

	@Override
	public boolean pay(float needAmountOfMoney) {
		return _paymentMethod.processMoneyForPaying(needAmountOfMoney);
	}

	@Override
	public int putProductInBasket(List<Pair<Product, Float>> products) {
		if (_paymentMethod.getCash() != 0 || _paymentMethod.getBankCard() != 0 || _paymentMethod.getBonuses() != 0) {
			int index = chooseRandomProductIndex(products.size());

			if (index >= 0) {

				float maxAmount = products.get(index).getValue();
				float amount = chooseRandomAmount(maxAmount);
				if (amount != 0) {
					if (canTakeProduct(products.get(index).getKey(), amount)) {
						Pair<Product, Float> pair = new Pair<>(products.get(index).getKey(), products.get(index).getValue() - amount);
						products.set(index, pair);
						Logger.showProductsPeakedByCustomer(this, products.get(index).getKey(), amount);
						_basket.addProduct(products.get(index).getKey(), amount);

						return index;
					}
				}
			}
		}

		return -1;
	}

	@Override
	public void chooseCurrState() {
		Random rand = new Random();
		if (_basket.getProducts().size() != 0) {
			_currState = StatesInSupermarket.values()[rand.nextInt(StatesInSupermarket.values().length)];
		} else {
			_currState = rand.nextBoolean() ? StatesInSupermarket.WANT_TO_TAKE_PRODUCT : StatesInSupermarket.WANT_TO_EXIT;
		}
	}

	@Override
	public StatesInSupermarket getCurrState() {
		return _currState;
	}

	@Override
	public String getName() {
		return _name;
	}

	private String getMoneyToString() {
		return String.format("%.2f", _paymentMethod.getAllMoney());
	}

	@Override
	public String getInfo() {
		return "name: " + getName() + " category: " + getCustomerCategory() + " money: " + getMoneyToString();
	}

	@Override
	public void addBonuses(float bonuses) {
		_paymentMethod.addBonuses(bonuses);
	}

	private int chooseRandomProductIndex(int arrLength) {
		Random rand = new Random();
		int randomIndex = rand.nextInt(arrLength) + 1;
		if (randomIndex < arrLength) {
			return randomIndex;
		}

		return -1;
	}

	private float chooseRandomAmount(float maxAmount) {
		Random rand = new Random();
		return rand.nextFloat() * (maxAmount + 1);
	}

	private boolean canTakeProduct(Product product, float randomAmount) {
		if (randomAmount * product.getPrice() + _estimatedCosts >= _paymentMethod.getAllMoney()) {
			_estimatedCosts += randomAmount * product.getPrice();

			return true;
		}

		return false;
	}
}
