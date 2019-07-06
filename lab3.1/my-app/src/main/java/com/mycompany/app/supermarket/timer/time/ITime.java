package com.mycompany.app.supermarket.timer.time;

public interface ITime {
	boolean equals(Time time);

	int getHours();

	int getMinutes();

	void increaseMinutes();
}
