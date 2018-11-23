package com.company.supermarket.model.processors;

import com.company.customer.Customer;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueProcessor {
	// TODO: remove uneccessary class move to CashDesk
	private Deque<Customer> _queue = new ArrayDeque<>();

	public void addCustomer(Customer customer) {
		_queue.addLast(customer);
	}

	public Customer popCustomer() {
		return _queue.pollFirst();
	}

	public boolean isQueueEmpty() {
		return _queue.isEmpty();
	}
}
