package com.mycompany.app.supermarket.cashdesk;

import com.mycompany.app.customer.Customer;
import com.mycompany.app.product.Product;

import javafx.util.Pair;
import java.util.List;

public interface ICashDesk {
	float getMoney();

	List<Pair<Product, Float>> serveCustomer(Customer customer);
}
