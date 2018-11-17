package com.company.supermarket.cashdesk;

public class CashDesk {
	private float _money = 0;

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
