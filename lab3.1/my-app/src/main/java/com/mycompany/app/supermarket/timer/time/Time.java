package com.mycompany.app.supermarket.timer.time;

import com.mycompany.app.supermarket.utils.IInfo;

public class Time implements ITime, IInfo {
	private int _hours;
	private int _minutes;

	public Time(int hours, int minutes) {
		if (isHoursValid(hours) && isMinutesValid(minutes)) {
			_hours = hours;
			_minutes = minutes;
		} else {
			throw new IllegalArgumentException("incorrect time");
		}
	}

	public Time(String timeString) {
		String[] strArr = timeString.split(":");
		if (strArr.length == 2) {
			_hours = getNumberFromString(strArr[0], true);
			_minutes = getNumberFromString(strArr[1], false);
		} else {
			throw new IllegalArgumentException("incorrect time");
		}
	}

	@Override
	public boolean equals(Time time) {
		return (time._hours == _hours) && (time._minutes == _minutes);
	}

	private int getNumberFromString(String str, boolean isHours) throws IllegalArgumentException {
		int number = Integer.parseInt(str);
		if ((isHours && isHoursValid(number)) || (!isHours && isMinutesValid(number))) {
			return number;
		} else {
			throw new IllegalArgumentException("incorrect time");
		}
	}

	private boolean isMinutesValid(int number) {
		return !((number < 0) || (number > 59));
	}

	private boolean isHoursValid(int number) {
		return !((number < 0) || (number > 23));
	}

	@Override
	public int getHours() {
		return _hours;
	}

	@Override
	public int getMinutes() {
		return _minutes;
	}

	@Override
	public void increaseMinutes() {
		_minutes++;
		if (_minutes > 59) {
			increaseHours();
			_minutes = 0;
		}
	}

	private void increaseHours() {
		_hours++;
		if (_hours > 23) {
			_hours = 0;
		}
	}

	private String convertNumberToString(int value) {
		String str = "";
		if (value < 10) {
			str += 0;
		}

		str += value;

		return str;
	}

	@Override
	public String getInfo() {
		return convertNumberToString(getHours()) + ":" + convertNumberToString(getMinutes());
	}
}
