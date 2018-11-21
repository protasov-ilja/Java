package com.company.supermarket;

import com.company.customer.Customer;
import com.company.customer.enums.StatesInSupermarket;
import com.company.product.Product;
import com.company.product.enums.ProductMeasuringType;
import com.company.product.enums.ProductType;
import com.company.supermarket.cashdesk.CashDesk;
import com.company.supermarket.model.CustomerGenerator;
import com.company.supermarket.model.ProductProcessor;
import com.company.supermarket.model.ProductsGenerator;
import com.company.supermarket.model.QueueProcessor;
import com.company.supermarket.report.Report;
import com.company.supermarket.timer.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Supermarket {
	private CashDesk _cashDesk;
	private Report _report;
	private Timer _timer;
	private ProductProcessor _productProcessor;
	private CustomerGenerator _customerGenerator = new CustomerGenerator();
	private QueueProcessor _queueProcessor = new QueueProcessor();
	private List<Customer> _customers = new ArrayList<>();
	private Random _random = new Random();

	public Supermarket(String startTime, String endTime) {
		ProductsGenerator productsGenerator = new ProductsGenerator(10, 20);
		List<Product> products = productsGenerator.getListOfProducts();
		_productProcessor = new ProductProcessor(products);
		_timer = new Timer(startTime, endTime);
		System.out.println(_timer.getCurrTimeToString());
	}

	public void work() {
		while (!_timer.checkEndOfTime())
		{
			if (isNeedToCreateNewCustomer()) {
				_customers.add(_customerGenerator.getNewCustomer());
			}

			for (int i = 0; i < _customers.size(); ++i) {
				_customers.get(i).chooseCurrState();
				_customers.get(i).decreaseTime();
				if (_customers.get(i).getCurrState() == StatesInSupermarket.WANT_TO_TAKE_PRODUCT) {
					//_customers.get(i).takeSomeProducts();
					_customers.get(i).setWaitTimeInMinutes(10);
					System.out.println(_timer.getCurrTimeToString()  + " : " + _customers.get(i).getName() + " " + _customers.get(i).getCurrState().toString());
				}

				if (_customers.get(i).getCurrState() == StatesInSupermarket.WANT_TO_EXIT) {
					//_customers.get(i).exitFromSupermarket();
					System.out.println(_timer.getCurrTimeToString()  + " : " + _customers.get(i).getName() + " " + _customers.get(i).getCurrState().toString());
				}

				if (_customers.get(i).getCurrState() == StatesInSupermarket.WANT_TO_STAY_IN_QUEUE) {
					//_customers.get(i).stayInQueue();
					System.out.println(_timer.getCurrTimeToString()  + " : " + _customers.get(i).getName() + " " + _customers.get(i).getCurrState().toString());
				}
			}

			//processOnePersonInQueue();
			_timer.increaseTime();
		}

		System.out.println("Exit" + _timer.getCurrTimeToString());
	}

	private boolean isNeedToCreateNewCustomer() {
		return _random.nextBoolean();
	}
}
