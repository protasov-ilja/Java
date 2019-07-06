package com.mycompany.app.customer.paymentmethod;

public class PaymentMethod implements IPaymentMethod {
	private double _cash;
	private double _bankCard;
	private double _bonuses;

	public PaymentMethod(double cash, double bankCard, double bonuses) {
		if (checkNumberNotNegative(cash) && checkNumberNotNegative(bankCard) && checkNumberNotNegative(bonuses)) {
			_cash = cash;
			_bankCard = bankCard;
			_bonuses = bonuses;
		}
	}

	@Override
	public void addBonuses(double bonuses) {
		_bonuses += bonuses;
	}

	@Override
	public double getCash() {
		return _cash;
	}

	@Override
	public double getBankCard() {
		return _bankCard;
	}

	@Override
	public double getBonuses() {
		return _bonuses;
	}

	@Override
	public double getAllMoney() {
		return _bonuses + _bankCard + _cash;
	}

	@Override
	public boolean processMoneyForPaying(double money) {
		if (money <= getAllMoney()) {
			double temp = _cash;
			if (money > 0) {
				_cash -= money;
				if (_cash < 0) {
					_cash = 0;
				}

				money -= temp;
			}

			if (money > 0) {
				temp = _bankCard;
				_bankCard -= money;
				if (_bankCard < 0) {
					_bankCard = 0;
				}
				money -= temp;
			}

			if (money > 0) {
				_bonuses -= money;
			}

			return true;
		}

		return false;
	}

	private boolean checkNumberNotNegative(double number) {
		return number > 0;
	}
}
