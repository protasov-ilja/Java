package com.mycompany.app.supermarket.cashdesk;

import com.mycompany.app.customer.Customer;
import com.mycompany.app.customer.enums.CustomerCategory;
import com.mycompany.app.product.Product;
import com.mycompany.app.product.enums.ProductType;

import com.mycompany.app.supermarket.cashdesk.bill.Bill;
import com.mycompany.app.supermarket.utils.Logger;
import javafx.util.Pair;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CashDesk implements ICashDesk {
	private float _money;
	private Deque<Customer> _queue;
	private List<Bill> _bills = new ArrayList<>();

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
		float tempBonuses = 0;
		Bill bill = new Bill();
		for (int i = 0; i < customer.getProductsFromBasket().size(); ++i) {
			if (isChild && (customer.getProductsFromBasket().get(i).getKey().getType() == ProductType.NOT_ALLOWED_FOR_CHILDREN)) {
				returnedList.add(customer.returnProducts(i));
			} else {
				if (customer.getCustomerCategory() == CustomerCategory.RETIRED && customer.getProductsFromBasket().get(i).getKey().isHasDiscount()) {
					sum += (customer.getProductsFromBasket().get(i).getKey().getPrice() * customer.getProductsFromBasket().get(i).getValue()) * customer.getProductsFromBasket().get(i).getKey().getDiscount();
				} else {
					sum += (customer.getProductsFromBasket().get(i).getKey().getPrice() * customer.getProductsFromBasket().get(i).getValue());
				}

				tempBonuses += customer.getProductsFromBasket().get(i).getKey().getBonusesForPurchasing() * customer.getProductsFromBasket().get(i).getValue();
				bill.add(customer.getProductsFromBasket().get(i));
			}
		}

		if (customer.pay(sum) && sum != 0) {
			_money += sum;
			customer.addBonuses(tempBonuses);
			bill.addMoney(sum);
			bill.addBonuses(tempBonuses);
			bill.showInfo();
			_bills.add(bill);
			Logger.showProductBougtByCustomer(customer, customer.getProductsFromBasket());
		} else {
			returnedList.addAll(customer.returnAllProducts());
		}

		return returnedList;
	}

	private boolean checkIsChild(CustomerCategory category) {
		return (category == CustomerCategory.CHILD);
	}

	public List<Bill> getBills() {
		return _bills;
	}
}
