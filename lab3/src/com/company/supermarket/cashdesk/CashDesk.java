package com.company.supermarket.cashdesk;

import com.company.customer.Customer;
import com.company.customer.enums.CustomerCategory;
import com.company.product.enums.ProductType;

public class CashDesk implements ICashDesk {
	private float _money;

	public CashDesk(float startQuantityOfMoney) {
		_money = startQuantityOfMoney;
	}

	@Override
	public float getMoney() {
		return _money;
	}

	@Override
	public void serveCustomer(Customer customer) {
		float sum = 0;
		boolean isChild = checkIsChild(customer.getCustomerCategory());
		for (int i = 0; i < customer.getProductsFromBasket().size(); ++i) {
			if (isChild && (customer.getProductsFromBasket().get(i).getProduct().getType() == ProductType.NOT_ALLOWED_FOR_CHILDREN)) {
				customer.returnProducts(i);
			} else {
				sum += customer.getProductsFromBasket().get(i).getProduct().getPrice() * customer.getProductsFromBasket().get(i).getQuantity();
			}
		}

		_money += customer.pay(sum);
	}

	private boolean checkIsChild(CustomerCategory category) {
		return (category == CustomerCategory.CHILD);
	}
}
