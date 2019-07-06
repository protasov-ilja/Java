package com.company.supermarket.timer;

import com.company.supermarket.timer.time.Time;

public class Timer implements ITimer {
	private Time _endTime;
	private Time _currTime;

	public Timer(String startTimeStr, String endTimeStr) {
		try {
			_currTime = new Time(startTimeStr);
			_endTime = new Time(endTimeStr);
		} catch (Exception er) {

		}

	}

	@Override
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

	@Override
	public boolean checkEndOfTime() {
		return _currTime.equals(_endTime);
	}

	@Override
	public String getCurrTimeToString() {
		return _currTime.getInfo();
	}
}
