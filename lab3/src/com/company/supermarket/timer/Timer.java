package com.company.supermarket.timer;

public class Timer {
	private Time _startTime;
	private Time _endTime;
	private Time _currTime;

	public Timer(Time startTime, Time endTime) {
		_startTime = startTime;
		_currTime = startTime;
		_endTime = endTime;
	}

	public Timer(String startTimeStr, String endTimeStr) {
		_startTime = new Time(startTimeStr);
		System.out.println("curr" + _startTime.getInfo());
		_currTime = _startTime;
		_endTime = new Time(endTimeStr);
		System.out.println("end" + _endTime.getInfo());
	}

	public void increaseTime() {
		if (_currTime.getMinutes() == 59) {
			_currTime.setMinutes(0);
			if (_currTime.getHours() == 23) {
				_currTime.setHours(0);
			} else {
				_currTime.setHours(_currTime.getHours() + 1);
			}
		} else {
			_currTime.setMinutes(_currTime.getMinutes() + 1);
		}

		System.out.println(_currTime.getInfo());
	}

	public boolean checkEndOfTime() {
		return _currTime.equals(_endTime);
	}

	public String getCurrTimeToString() {
		return _currTime.getInfo();
	}

}
