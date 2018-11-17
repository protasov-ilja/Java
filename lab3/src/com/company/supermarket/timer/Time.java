package com.company.supermarket.timer;

public class Time {
	private int _hours;
	private int _minutes;
	private int _seconds;

	public Time(int hours, int minutes, int seconds) {
		_hours = hours;
		_minutes = minutes;
		_seconds = seconds;
	}

	public Time(String timeString) {
		String[] strArr = timeString.split(":");
		if (strArr.length == 3) {
			_hours = getNumberFormString(strArr[0], true);
			_minutes = getNumberFormString(strArr[1], false);
			_seconds = getNumberFormString(strArr[2], false);
		} else {
			throw new IllegalArgumentException();
		}
	}

	private int getNumberFormString(String str, boolean isHours) throws IllegalArgumentException {
		int number = Integer.parseInt(str);
		if (((number < 0) || (number > 60)) || ((isHours) && (number > 23))) {
			throw new IllegalArgumentException();
		} else {
			return number;
		}
	}

	public int getHours() {
		return _hours;
	}

	public int getMinutes() {
		return _minutes;
	}

	public int getSeconds() {
		return _seconds;
	}

	private String convertNumberToString(int value) {
		String str = "";
		if (value < 10) {
			str += 0;
		}

		str += value;

		return str;
	}

	public String getInfo() {
		return convertNumberToString(getHours()) + ":" + convertNumberToString(getMinutes()) + ":"
				+ convertNumberToString(getSeconds());
	}
}
