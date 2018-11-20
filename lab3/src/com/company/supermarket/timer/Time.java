package com.company.supermarket.timer;

public class Time {
	private int _hours;
	private int _minutes;

	public Time(int hours, int minutes) {
		_hours = hours;
		_minutes = minutes;
	}

	public Time(String timeString) {
		String[] strArr = timeString.split(":");
		if (strArr.length == 2) {
			_hours = getNumberFromString(strArr[0], true);
			_minutes = getNumberFromString(strArr[1], false);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public boolean equals(Time time) {
		return (time._hours == _hours) && (time._minutes == _minutes);
	}

	private int getNumberFromString(String str, boolean isHours) throws IllegalArgumentException {
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

	public void setHours(int hours) {
		_hours = hours;
	}

	public void setMinutes(int minutes) {
		_minutes = minutes;
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
		return convertNumberToString(getHours()) + ":" + convertNumberToString(getMinutes());
	}
}
