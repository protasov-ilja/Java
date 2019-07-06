package com.mycompany.app.customer;

import com.mycompany.app.customer.enums.CustomerCategory;
import com.mycompany.app.customer.enums.StatesInSupermarket;
import com.mycompany.app.customer.paymentmethod.PaymentMethod;
import com.mycompany.app.product.Product;
import com.mycompany.app.product.enums.ProductMeasuringType;
import com.mycompany.app.product.enums.ProductType;
import javafx.util.Pair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CustomerTest {

	@Test
	public void createCustomer() {
		PaymentMethod method = new PaymentMethod(100,100, 100);
		Customer customer = new Customer("customer", CustomerCategory.CHILD, method);
		assertEquals(customer.getName(), "customer");
		assertEquals(customer.getCustomerCategory(), CustomerCategory.CHILD);
		assertEquals(customer.getCurrState(), StatesInSupermarket.WALK);
	}

	@Test
	public void getCustomerCategory() {
		PaymentMethod method = new PaymentMethod(100,100, 100);
		Customer customer = new Customer("customer", CustomerCategory.ADULT, method);
		assertEquals(customer.getCustomerCategory(), CustomerCategory.ADULT);

		customer = new Customer("customer", CustomerCategory.RETIRED, method);
		assertEquals(customer.getCustomerCategory(), CustomerCategory.RETIRED);

		customer = new Customer("customer", CustomerCategory.CHILD, method);
		assertEquals(customer.getCustomerCategory(), CustomerCategory.CHILD);
	}

	@Test
	public void returnAllProducts() {
		PaymentMethod method = new PaymentMethod(100,100, 100);
		Customer customer = new Customer("customer", CustomerCategory.ADULT, method);
		List<Pair<Product, Float>> tempList = new ArrayList<>();
		Product product1 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product2 = new Product("product2", 1, ProductType.NOT_ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_QUANTITY);
		Product product3 = new Product("product2", 1, ProductType.NOT_ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_QUANTITY);
		Product product4 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product5 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product6 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product7 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product8 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product9 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product10 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);

		Pair<Product, Float> tempPair1 = new Pair<>(product1, 2f);
		Pair<Product, Float> tempPair2 = new Pair<>(product2, 2f);
		Pair<Product, Float> tempPair3 = new Pair<>(product3, 2f);
		Pair<Product, Float> tempPair4 = new Pair<>(product4, 2f);
		Pair<Product, Float> tempPair5 = new Pair<>(product5, 2f);
		Pair<Product, Float> tempPair6 = new Pair<>(product6, 2f);
		Pair<Product, Float> tempPair7 = new Pair<>(product7, 2f);
		Pair<Product, Float> tempPair8 = new Pair<>(product8, 2f);
		Pair<Product, Float> tempPair9 = new Pair<>(product9, 2f);
		Pair<Product, Float> tempPair10 = new Pair<>(product10, 2f);

		tempList.add(tempPair1);
		tempList.add(tempPair2);
		tempList.add(tempPair3);
		tempList.add(tempPair4);
		tempList.add(tempPair5);
		tempList.add(tempPair6);
		tempList.add(tempPair7);
		tempList.add(tempPair8);
		tempList.add(tempPair9);
		tempList.add(tempPair10);
		customer.putProductInBasket(tempList);
		customer.returnAllProducts();
		assertTrue(true);
	}

	@Test
	public void returnProducts() {
		PaymentMethod method = new PaymentMethod(100,100, 100);
		Customer customer = new Customer("customer", CustomerCategory.ADULT, method);
		List<Pair<Product, Float>> tempList = new ArrayList<>();
		Product product1 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product2 = new Product("product2", 1, ProductType.NOT_ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_QUANTITY);
		Product product3 = new Product("product2", 1, ProductType.NOT_ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_QUANTITY);
		Product product4 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product5 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product6 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product7 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product8 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product9 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
		Product product10 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);

		Pair<Product, Float> tempPair1 = new Pair<>(product1, 2f);
		Pair<Product, Float> tempPair2 = new Pair<>(product2, 2f);
		Pair<Product, Float> tempPair3 = new Pair<>(product3, 2f);
		Pair<Product, Float> tempPair4 = new Pair<>(product4, 2f);
		Pair<Product, Float> tempPair5 = new Pair<>(product5, 2f);
		Pair<Product, Float> tempPair6 = new Pair<>(product6, 2f);
		Pair<Product, Float> tempPair7 = new Pair<>(product7, 2f);
		Pair<Product, Float> tempPair8 = new Pair<>(product8, 2f);
		Pair<Product, Float> tempPair9 = new Pair<>(product9, 2f);
		Pair<Product, Float> tempPair10 = new Pair<>(product10, 2f);

		tempList.add(tempPair1);
		tempList.add(tempPair2);
		tempList.add(tempPair3);
		tempList.add(tempPair4);
		tempList.add(tempPair5);
		tempList.add(tempPair6);
		tempList.add(tempPair7);
		tempList.add(tempPair8);
		tempList.add(tempPair9);
		tempList.add(tempPair10);
		customer.putProductInBasket(tempList);

		int index = customer.getProductsFromBasket().size() - 1;
		if (index >= 0) {
			customer.returnProducts(0);
		}

		assertTrue(true);
	}

	@Test
	public void pay() {
		PaymentMethod method = new PaymentMethod(100,100, 100);
		Customer customer = new Customer("customer", CustomerCategory.CHILD, method);
		assertTrue(customer.pay(300));
		assertFalse(customer.pay(1));
	}

	@Test
	public void putProductInBasket() {
		try {
			PaymentMethod method = new PaymentMethod(100,100, 100);
			Customer customer = new Customer("customer", CustomerCategory.ADULT, method);
			List<Pair<Product, Float>> tempList = new ArrayList<>();
			Product product1 = new Product("product1", 1, ProductType.ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_WEIGHT);
			Product product2 = new Product("product2", 1, ProductType.NOT_ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_QUANTITY);
			Product product3 = new Product("product2", 1, ProductType.NOT_ALLOWED_FOR_CHILDREN, ProductMeasuringType.BY_QUANTITY);

			Pair<Product, Float> tempPair1 = new Pair<>(product1, 2f);
			Pair<Product, Float> tempPair2 = new Pair<>(product2, 2f);
			Pair<Product, Float> tempPair3 = new Pair<>(product3, 2f);
			tempList.add(tempPair1);
			tempList.add(tempPair2);
			tempList.add(tempPair3);
			customer.putProductInBasket(tempList);
			assertEquals(customer.getProductsFromBasket().size(), 0);
			assertTrue(true);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	@Test
	public void addBonuses() {
		try {
			PaymentMethod method = new PaymentMethod(100,100, 100);
			Customer customer = new Customer("customer", CustomerCategory.ADULT, method);
			customer.addBonuses(100);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	@Test
	public void chooseCurrState() {
		try {
			PaymentMethod method = new PaymentMethod(100,100, 100);
			Customer customer = new Customer("customer", CustomerCategory.CHILD, method);
			customer.chooseCurrState();
			assertTrue(true);
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	@Test
	public void getCurrState() {
		PaymentMethod method = new PaymentMethod(100,100, 100);
		Customer customer = new Customer("customer", CustomerCategory.CHILD, method);
		assertEquals(customer.getCurrState(), StatesInSupermarket.WALK);
	}

	@Test
	public void getName() {
		PaymentMethod method = new PaymentMethod(100,100, 100);
		Customer customer = new Customer("customer", CustomerCategory.CHILD, method);
		assertEquals(customer.getName(), "customer");
	}

	@Test
	public void getInfo() {
		PaymentMethod method = new PaymentMethod(100,100, 100);
		Customer customer = new Customer("customer", CustomerCategory.CHILD, method);
		assertEquals(customer.getInfo(), "name: customer category: CHILD money: 300,00");
	}
}