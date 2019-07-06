package com.mycompany.app.customer.paymentmethod;

public interface IPaymentMethod {
	void addBonuses(double bonuses);

	double getCash();

	double getBankCard();

	double getBonuses();

	double getAllMoney();

	boolean processMoneyForPaying(double money);
}
