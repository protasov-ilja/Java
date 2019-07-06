package com.company.supermarket;

import com.company.customer.Customer;
import com.company.customer.enums.StatesInSupermarket;
import com.company.product.Product;
import com.company.supermarket.cashdesk.CashDesk;
import com.company.supermarket.model.generators.CustomerGenerator;
import com.company.supermarket.model.processors.ProductProcessor;
import com.company.supermarket.model.generators.ProductsGenerator;
import com.company.supermarket.report.Report;
import com.company.supermarket.timer.Timer;
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

	public Supermarket(String startTime, String endTime) {
		ProductsGenerator productsGenerator = new ProductsGenerator(10, 20);
		List<Pair<Product, Float>> products = productsGenerator.getListOfProducts();
		_productProcessor = new ProductProcessor(products);
		_timer = new Timer(startTime, endTime);
		_report = new Report();
	}

	@Override
	public void work() {
		while (!_timer.checkEndOfTime()) {
			if (isNeedToCreateNewCustomer()) {
				_customers.add(_customerGenerator.getNewCustomer());
			}

			for (int i = 0; i < _customers.size(); ++i) {
				_customers.get(i).chooseCurrState();
				if (_customers.get(i).getCurrState() == StatesInSupermarket.WANT_TO_TAKE_PRODUCT) {
					int index = _customers.get(i).putProductInBasket(_productProcessor.getProducts());
					if (index != -1) {
						_productProcessor.checkProductResidue(index);
					}

				} else if (_customers.get(i).getCurrState() == StatesInSupermarket.WANT_TO_EXIT) {
					List<Pair<Product, Float>> returningProducts = _customers.get(i).returnAllProducts();
					_productProcessor.addProducts(returningProducts);
					_customers.remove(i);
				} else if (_customers.get(i).getCurrState() == StatesInSupermarket.WANT_TO_STAY_IN_QUEUE) {
					_cashDesk.addCustomer(_customers.remove(i));
				}
			}

			if (!_cashDesk.isQueueEmpty()) {
				List<Pair<Product, Float>> returningProducts = _cashDesk.serveCustomer(_cashDesk.popCustomer());
				_productProcessor.addProducts(returningProducts);
			}

			_timer.increaseTime();
		}

		System.out.println("Exit" + _timer.getCurrTimeToString());
	}

	private boolean isNeedToCreateNewCustomer() {
		return _random.nextBoolean();
	}
}
