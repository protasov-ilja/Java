package com.company.supermarket;

import com.company.customer.Customer;
import com.company.customer.enums.StatesInSupermarket;
import com.company.product.Products;
import com.company.supermarket.cashdesk.CashDesk;
import com.company.supermarket.model.generators.CustomerGenerator;
import com.company.supermarket.model.processors.ProductProcessor;
import com.company.supermarket.model.generators.ProductsGenerator;
import com.company.supermarket.model.processors.QueueProcessor;
import com.company.supermarket.report.Report;
import com.company.supermarket.timer.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Supermarket implements ISupermarket {
	private CashDesk _cashDesk = new CashDesk(10000);
	private Report _report;
	private Timer _timer;
	private ProductProcessor _productProcessor;
	private CustomerGenerator _customerGenerator = new CustomerGenerator();
	private QueueProcessor _queueProcessor = new QueueProcessor();
	private List<Customer> _customers = new ArrayList<>();
	private Random _random = new Random();

	public Supermarket(String startTime, String endTime) {
		ProductsGenerator productsGenerator = new ProductsGenerator(10, 20);
		List<Products> products = productsGenerator.getListOfProducts();
		_productProcessor = new ProductProcessor(products);
		_timer = new Timer(startTime, endTime);
		System.out.println(_timer.getCurrTimeToString());
	}

	@Override
	public void work() {
		while (!_timer.checkEndOfTime())
		{
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

					System.out.println(_timer.getCurrTimeToString()  + " : " + _customers.get(i).getName() + " " + _customers.get(i).getCurrState().toString());
				} else if (_customers.get(i).getCurrState() == StatesInSupermarket.WANT_TO_EXIT) {
					System.out.println(_timer.getCurrTimeToString()  + " : " + _customers.get(i).getName() + " " + _customers.get(i).getCurrState().toString());
					List<Products> returningProducts = _customers.get(i).returnAllProducts();
					_productProcessor.addProducts(returningProducts);
					_customers.remove(i);
				} else if (_customers.get(i).getCurrState() == StatesInSupermarket.WANT_TO_STAY_IN_QUEUE) {
					System.out.println(_timer.getCurrTimeToString()  + " : " + _customers.get(i).getName() + " " + _customers.get(i).getCurrState().toString());
					_queueProcessor.addCustomer(_customers.remove(i));
				}
			}

			if (!_queueProcessor.isQueueEmpty()) {
				_cashDesk.serveCustomer(_queueProcessor.popCustomer());
				System.out.println(_timer.getCurrTimeToString()  + " : SERVED");
			}

			_timer.increaseTime();
		}

		System.out.println("Exit" + _timer.getCurrTimeToString());
	}

	private boolean isNeedToCreateNewCustomer() {
		return _random.nextBoolean();
	}
}
