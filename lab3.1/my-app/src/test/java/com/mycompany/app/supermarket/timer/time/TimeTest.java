package com.mycompany.app.supermarket.timer.time;

import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
	@Test
	public void CreateTimeFromNumbers() {
		Time time = new Time(0, 59);
		assertEquals(time.getHours(), 0);
		assertEquals(time.getMinutes(), 59);
		time = new Time(23, 0);
		assertEquals(time.getHours(), 23);
		assertEquals(time.getMinutes(), 0);
	}

	@Test
	public void WhenCreateTimeFromNumbersWithMoreThan23Hours() throws IllegalArgumentException {
		try {
			Time time = new Time(24, 0);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException thrown) {
			assertEquals("incorrect time", thrown.getMessage());
		}
	}

	@Test
	public void WhenCreateTimeFromNumbersWithMoreThan59Minutes() throws IllegalArgumentException {
		try {
			Time time = new Time(22, 60);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException thrown) {
			assertEquals("incorrect time", thrown.getMessage());
		}
	}

	@Test
	public void WhenCreateTimeFromNumbersWithLessThanZeroMinutes() throws IllegalArgumentException {
		try {
			Time time = new Time(22, -1);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException thrown) {
			assertEquals("incorrect time", thrown.getMessage());
		}
	}

	@Test
	public void CreateTimeFromString() {
		Time time = new Time("00:59");
		assertEquals(time.getHours(), 0);
		assertEquals(time.getMinutes(), 59);
		time = new Time("23:0");
		assertEquals(time.getHours(), 23);
		assertEquals(time.getMinutes(), 0);
	}

	@Test
	public void WhenCreateTimeFromStringWithMoreThan23Hours() throws IllegalArgumentException {
		try {
			Time time = new Time("24:00");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException thrown) {
			assertEquals("incorrect time", thrown.getMessage());
		}
	}

	@Test
	public void WhenCreateTimeFromStringWithMoreThan59Minutes() throws IllegalArgumentException {
		try {
			Time time = new Time("22:60");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException thrown) {
			assertEquals("incorrect time", thrown.getMessage());
		}
	}

	@Test
	public void WhenCreateTimeFromStringWithLessThanZeroMinutes() throws IllegalArgumentException {
		try {
			Time time = new Time("22:-1");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException thrown) {
			assertEquals("incorrect time", thrown.getMessage());
		}
	}

	@Test
	public void WhenCreateTimeFromStringWithLessThanZeroHours() throws IllegalArgumentException {
		try {
			Time time = new Time("-1:30");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException thrown) {
			assertEquals("incorrect time", thrown.getMessage());
		}
	}

	@Test
	public void WhenCreateTimeFromStringWithLessThanTwoValues() throws IllegalArgumentException {
		try {
			Time time = new Time("22");
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException thrown) {
			assertEquals("incorrect time", thrown.getMessage());
		}
	}

	@Test
	public void IncreaseMinutesTest() {
		Time time = new Time("23:58");
		time.increaseMinutes();
		assertEquals(time.getMinutes(), 59);
		assertEquals(time.getHours(), 23);
		time.increaseMinutes();
		assertEquals(time.getMinutes(), 0);
		assertEquals(time.getHours(), 0);
		time = new Time("02:59");
		time.increaseMinutes();
		assertEquals(time.getMinutes(), 0);
		assertEquals(time.getHours(), 3);
	}

	@Test
	public void equals() {
		Time time1 = new Time("22:00");
		Time time2 = new Time("22:00");
		assertTrue(time1.equals(time2));
		time2 = new Time("22:01");
		assertFalse(time1.equals(time2));
	}

	@Test
	public void getHours() {
		Time time = new Time("22:00");
		assertEquals(time.getHours(), 22);
	}

	@Test
	public void getMinutes() {
		Time time = new Time("22:30");
		assertEquals(time.getMinutes(), 30);
	}

	@Test
	public void getInfo() {
		Time time = new Time("22:30");
		assertEquals(time.getInfo(), "22:30");
	}
}