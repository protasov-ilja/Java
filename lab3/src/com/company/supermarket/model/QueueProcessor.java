package com.company.supermarket.model;

import com.company.customer.Customer;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueProcessor {
	private Deque<Customer> _queue = new ArrayDeque<>();

	private void addCustomer(Customer customer) {
		_queue.addLast(customer);
	}

	private Customer popCustomer() {
		return _queue.pollFirst();
	}
}
