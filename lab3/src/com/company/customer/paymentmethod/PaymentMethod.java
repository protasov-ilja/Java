package com.company.customer.paymentmethod;

public class PaymentMethod implements IPaymentMethod {
	private float _cash;
	private float _bankCard;
	private float _bonuses;

	public PaymentMethod(float cash, float bankCard, float bonuses) {
		_cash = cash;
		_bankCard = bankCard;
		_bonuses = bonuses;
	}

	public float getCash() {
		return _cash;
	}

	public float getBankCard() {
		return _bankCard;
	}

	public float getBonuses() {
		return _bonuses;
	}

	public float getAllMoney() {
		return _bonuses + _bankCard + _cash;
	}

	public void processMoneyForPaying(float money) {
		if (money - _cash <= 0) {
			_cash -= money;
		}
	}

//	private void ProcessMoney(float money, flaot currMoney) {
//
//	}
}
