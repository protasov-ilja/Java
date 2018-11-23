package com.company.customer.paymentmethod;

import com.company.customer.enums.StatesInSupermarket;

public interface IPaymentMethod {
	float getBankCard();

	float getBonuses();

	float getAllMoney();

	void processMoneyForPaying(float money);
}
