package com.mycompany.app.supermarket.timer;

public interface ITimer {
	void increaseTime();

	boolean checkEndOfTime();

	String getCurrTimeToString();
}
