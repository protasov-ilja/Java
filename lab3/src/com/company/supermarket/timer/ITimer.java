package com.company.supermarket.timer;

public interface ITimer {
	void increaseTime();

	boolean checkEndOfTime();

	String getCurrTimeToString();
}
