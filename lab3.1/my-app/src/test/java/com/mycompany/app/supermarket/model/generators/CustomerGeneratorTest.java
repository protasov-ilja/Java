package com.mycompany.app.supermarket.model.generators;

import com.mycompany.app.customer.Customer;
import com.mycompany.app.customer.enums.CustomerCategory;
import com.mycompany.app.customer.paymentmethod.PaymentMethod;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerGeneratorTest {

	@Test
	public void getNewCustomer() {
		try {
			CustomerGenerator cG = new CustomerGenerator();
			Customer oldCustomer = new Customer("1", CustomerCategory.CHILD, new PaymentMethod(0,0,0));
			for (int i = 0; i < 10; ++i) {
				Customer customer = cG.getNewCustomer();
				assertNotEquals(customer, oldCustomer);
				oldCustomer = customer;
				assertTrue(true);
			}
		} catch (Exception ex) {
			fail("Exception" + ex.getMessage());
		}
	}
}