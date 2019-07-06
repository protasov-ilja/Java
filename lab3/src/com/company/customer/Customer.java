package com.company.customer;

import com.company.customer.basket.Basket;
import com.company.customer.basket.IBasket;
import com.company.customer.enums.CustomerCategory;
import com.company.customer.enums.StatesInSupermarket;
import com.company.customer.paymentmethod.PaymentMethod;
import com.company.product.Product;
import javafx.util.Pair;

import java.util.List;
import java.util.Random;

public class Customer implements ICustomer {
	private String _name;
	private CustomerCategory _category;
	private IBasket _basket = new Basket();
	private PaymentMethod _paymentMethod;
	private StatesInSupermarket _currState;
	private float _estimatedCosts = 0;

	public Customer(String name, CustomerCategory category, PaymentMethod method) {
		_name = name;
		_category = category;
		_paymentMethod = method;
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
			float maxAmount = products.get(index).getValue();
			float amount = chooseRandomAmount(maxAmount);
			if (amount != 0) {
				if (canTakeProduct(products.get(index).getKey(), amount)) {
					Pair<Product, Float> pair = new Pair<>(products.get(index).getKey(), products.get(index).getValue() - amount);
					products.set(index, pair);
					_basket.addProduct(products.get(index).getKey(), amount);

					return index;
				}
			}
		}

		return -1;
	}

	private int chooseRandomProductIndex(int arrLength) {
		Random rand = new Random();
		return rand.nextInt(arrLength);
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
}
