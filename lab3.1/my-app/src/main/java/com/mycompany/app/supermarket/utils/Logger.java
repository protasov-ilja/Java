package com.mycompany.app.supermarket.utils;

import com.mycompany.app.customer.Customer;
import com.mycompany.app.product.Product;
import com.mycompany.app.supermarket.timer.Timer;
import javafx.util.Pair;

import java.util.List;

public class Logger {
	public static void showCreatedProducts(List<Pair<Product, Float>> products) {
		System.out.println(" PRODUCTS CREATED:");
		for (int i = 0; i < products.size(); ++i) {
			System.out.println(products.get(i).getValue() + " : " + products.get(i).getKey().getInfo());
		}
	}

	public static void showCreatedCustomer(Customer customer) {
		System.out.println(" CUSTOMER ENTER:");
		System.out.println("  " + customer.getInfo());
	}

	public static void showProductsPeakedByCustomer(Customer customer, Product product, float amount) {
		System.out.println(" PRODUCT PEAKED BY : " + customer.getName());
		System.out.println("  " + amount + " : " + product.getInfo());
	}

	public static void showReturnedProducts(Customer customer, List<Pair<Product, Float>> products) {
		System.out.println(" PRODUCTS RETURNED BY : " + customer.getName());
		for (int i = 0; i < products.size(); ++i) {
			System.out.println("  " + products.get(i).getValue() + " : " + products.get(i).getKey().getInfo());
		}
	}

	public static void showCurrTime(Timer timer) {
		System.out.println(timer.getCurrTimeToString() + ":");
	}

	public static void showCustomerStayInQueue(Customer customer) {
		System.out.println(" " + customer.getName() + " STAYED IN QUEUE");
	}

	public static void showCustomerLeftSupermarket(Customer customer) {
		System.out.println(" " + customer.getName() + " LEFT SUPERMARKET");
	}

	public static void showProductBougtByCustomer(Customer customer, List<Pair<Product, Float>> products) {
		System.out.println(" PRODUCTS BOUGHT BY : " + customer.getName());
		for (int i = 0; i < products.size(); ++i) {
			System.out.println("  " + products.get(i).getValue() + " : " + products.get(i).getKey().getInfo());
		}
	}

	public static void showOpenTime(Timer timer) {
		System.out.println("SUPERMARKET OPENED AT: " + timer.getCurrTimeToString());
	}

	public static void showCloseTime(Timer timer) {
		System.out.println("SUPERMARKET CLOSE AT: " + timer.getCloseTimeToString());
	}
}
