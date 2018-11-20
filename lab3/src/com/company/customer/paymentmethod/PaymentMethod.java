package com.company.customer.paymentmethod;

public class PaymentMethod {
	private float _cash;
	private float _bankCard;
	private int _bonuses;

	public PaymentMethod(float cash, float bankCard, int bonuses) {
		_cash = cash;
		_bankCard = bankCard;
		_bonuses = bonuses;
	}
}
