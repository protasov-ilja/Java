package com.company.supermarket.cashdesk;

import com.company.customer.Customer;
import com.company.product.Product;
import javafx.util.Pair;

import java.util.List;

public interface ICashDesk {
	float getMoney();

	List<Pair<Product, Float>> serveCustomer(Customer customer);
}
