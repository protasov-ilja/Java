package com.mycompany.app.supermarket;

import com.mycompany.app.customer.Customer;
import com.mycompany.app.customer.enums.StatesInSupermarket;
import com.mycompany.app.product.Product;
import com.mycompany.app.supermarket.cashdesk.CashDesk;
import com.mycompany.app.supermarket.model.generators.CustomerGenerator;
import com.mycompany.app.supermarket.model.processors.ProductProcessor;
import com.mycompany.app.supermarket.model.generators.ProductsGenerator;
import com.mycompany.app.supermarket.report.Report;
import com.mycompany.app.supermarket.timer.Timer;
import com.mycompany.app.supermarket.utils.Logger;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Supermarket implements ISupermarket {
	private CashDesk _cashDesk = new CashDesk();
	private Report _report;
	private Timer _timer;
	private ProductProcessor _productProcessor;
	private CustomerGenerator _customerGenerator = new CustomerGenerator();
	private List<Customer> _customers = new ArrayList<>();
	private Random _random = new Random();

	public Supermarket(String startTime, String endTime) throws IllegalArgumentException {
		ProductsGenerator productsGenerator = new ProductsGenerator(10, 20);
		List<Pair<Product, Float>> products = productsGenerator.getListOfProducts();
		Logger.showCreatedProducts(products);
		_productProcessor = new ProductProcessor(products);
		_timer = new Timer(startTime, endTime);
		Logger.showCurrTime(_timer);
		Logger.showCloseTime(_timer);
	}

	@Override
	public void work() {
		while (!_timer.checkEndOfTime()) {
			Logger.showCurrTime(_timer);
			if (isNeedToCreateNewCustomer()) {
				addNewCustomer(1);
			}

			for (int i = 0; i < _customers.size(); ++i) {
				_customers.get(i).chooseCurrState();
				if (_customers.get(i).getCurrState() == StatesInSupermarket.WANT_TO_TAKE_PRODUCT) {
					wantToTakeProducts(i);
				} else if (_customers.get(i).getCurrState() == StatesInSupermarket.WANT_TO_EXIT) {
					exitCustomerFromSupermarket(i);
				} else if (_customers.get(i).getCurrState() == StatesInSupermarket.WANT_TO_STAY_IN_QUEUE) {
					StayedCustomerInQueue(_customers.remove(i));
				}
			}

			if (!_cashDesk.isQueueEmpty()) {
				processQueue(_cashDesk.popCustomer());
			}

			_timer.increaseTime();
		}

		for (int i = 0; i < _customers.size(); ++i) {
			exitCustomerFromSupermarket(i);
		}

		Logger.showCloseTime(_timer);
		showReport();
	}

	private void addNewCustomer(int amount) {
		for (int i = 0; i < amount; ++i) {
			Customer customer = _customerGenerator.getNewCustomer();
			Logger.showCreatedCustomer(customer);
			_customers.add(customer);
		}
	}

	private void StayedCustomerInQueue(Customer customer) {
		Logger.showCustomerStayInQueue(customer);
		_cashDesk.addCustomer(customer);
	}

	private void exitCustomerFromSupermarket(int index) {
		List<Pair<Product, Float>> returningProducts = _customers.get(index).returnAllProducts();
		Logger.showReturnedProducts(_customers.get(index), returningProducts);
		_productProcessor.addProducts(returningProducts);
		Logger.showCustomerLeftSupermarket(_customers.get(index));
		_customers.remove(index);
	}

	private void wantToTakeProducts(int index) {
		int pickedIndex = _customers.get(index).putProductInBasket(_productProcessor.getProducts());
		if (pickedIndex != -1) {
			_productProcessor.checkProductResidue(pickedIndex);
		}
	}

	private void processQueue(Customer customer) {
		List<Pair<Product, Float>> returningProducts = _cashDesk.serveCustomer(customer);
		Logger.showReturnedProducts(customer, returningProducts);
		_productProcessor.addProducts(returningProducts);
	}

	private void showReport() {
		_report = new Report();
		_report.create(_cashDesk.getBills());
	}

	private boolean isNeedToCreateNewCustomer() {
		return _random.nextBoolean();
	}
}
