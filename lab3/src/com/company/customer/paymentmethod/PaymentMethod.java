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

	@Override
	public float getBankCard() {
		return _bankCard;
	}

	@Override
	public float getBonuses() {
		return _bonuses;
	}

	@Override
	public float getAllMoney() {
		return _bonuses + _bankCard + _cash;
	}

	@Override
	public boolean processMoneyForPaying(float money) {
		if (money <= getAllMoney()) {
			float temp = _cash;
			if (money > 0) {
				_cash -= money;
				money -= temp;
			}

			if (money > 0) {
				temp = _bankCard;
				_bankCard -= money;
				money -= temp;
			}

			if (money > 0) {
				_bonuses -= money;
			}

			return true;
		}

		return false;
	}
}
