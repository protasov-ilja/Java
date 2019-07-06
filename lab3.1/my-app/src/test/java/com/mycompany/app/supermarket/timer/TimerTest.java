package com.mycompany.app.supermarket.timer;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimerTest {

	@Test
	public void increaseTime() {
		Timer timer = new Timer("00:00", "02:00");
		timer.increaseTime();
		assertEquals(timer.getCurrTimeToString(), "00:01");
	}

	@Test
	public void checkEndOfTime() {
		Timer timer = new Timer("01:00", "01:01");
		assertFalse(timer.checkEndOfTime());
		timer.increaseTime();
		assertTrue(timer.checkEndOfTime());
		assertEquals(timer.getCurrTimeToString(), "01:01");
		assertEquals(timer.getCloseTimeToString(), "01:01");
	}

	@Test
	public void getCurrTimeToString() {
		Timer timer = new Timer("00:00", "02:00");
		assertEquals(timer.getCurrTimeToString(), "00:00");
	}

	@Test
	public void getCloseTimeToString() {
		Timer timer = new Timer("00:00", "02:00");
		assertEquals(timer.getCloseTimeToString(), "02:00");
	}
}