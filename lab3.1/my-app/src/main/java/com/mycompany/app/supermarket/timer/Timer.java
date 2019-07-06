package com.mycompany.app.supermarket.timer;

import com.mycompany.app.supermarket.timer.time.Time;
import com.mycompany.app.supermarket.timer.ITimer;

public class Timer implements ITimer {
	private Time _endTime;
	private Time _currTime;

	public Timer(String startTimeStr, String endTimeStr) {
		_currTime = new Time(startTimeStr);
		_endTime = new Time(endTimeStr);
	}

	@Override
	public void increaseTime() {
		_currTime.increaseMinutes();
	}

	@Override
	public boolean checkEndOfTime() {
		return _currTime.equals(_endTime);
	}

	@Override
	public String getCurrTimeToString() {
		return _currTime.getInfo();
	}

	public String getCloseTimeToString() {
		return _endTime.getInfo();
	}
}
