package com.company.supermarket.cashdesk;

import com.company.customer.Customer;
import com.company.customer.enums.CustomerCategory;
import com.company.product.Product;
import com.company.product.enums.ProductType;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CashDesk implements ICashDesk {
	private float _money;
	private Deque<Customer> _queue;

	public CashDesk() {
		_money = 0;
		_queue = new ArrayDeque<>();
	}

	public void addCustomer(Customer customer) {
		_queue.addLast(customer);
	}

	public Customer popCustomer() {
		return _queue.pollFirst();
	}

	public boolean isQueueEmpty() {
		return _queue.isEmpty();
	}

	@Override
	public float getMoney() {
		return _money;
	}

	@Override
	public List<Pair<Product, Float>> serveCustomer(Customer customer) {
		List<Pair<Product, Float>> returnedList = new ArrayList<>();
		float sum = 0;
		boolean isChild = checkIsChild(customer.getCustomerCategory());
		for (int i = 0; i < customer.getProductsFromBasket().size(); ++i) {
			if (isChild && (customer.getProductsFromBasket().get(i).getKey().getType() == ProductType.NOT_ALLOWED_FOR_CHILDREN)) {
				returnedList.add(customer.returnProducts(i));
			} else {
				sum += customer.getProductsFromBasket().get(i).getKey().getPrice() * customer.getProductsFromBasket().get(i).getValue();
			}
		}

		if (customer.pay(sum)) {
			_money += sum;
		} else {
			returnedList.addAll(customer.returnAllProducts());
		}

		return returnedList;
	}

	private boolean checkIsChild(CustomerCategory category) {
		return (category == CustomerCategory.CHILD);
	}
}
