package com.company.supermarket.cashdesk;

import com.company.customer.Customer;

public interface ICashDesk {
	float getMoney();

	void serveCustomer(Customer customer);
}
