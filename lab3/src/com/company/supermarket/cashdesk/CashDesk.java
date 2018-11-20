package com.company.supermarket.cashdesk;

public class CashDesk {
	private float _money;

	public CashDesk(float startQuantityOfMoney) {
		_money = startQuantityOfMoney;
	}

	public float getMoney() {
		return _money;
	}

	public void setMoney(float value) {
		_money = value;
	}
}
