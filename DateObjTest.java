package hw4;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DateObjTest {

	@Test
	public void isLeapYear_Test() {
		assertTrue(new DateObj(2000, 1, 1).isLeapYear());
		assertFalse(new DateObj(2001, 1, 1).isLeapYear());
		assertFalse(new DateObj(2002, 1, 1).isLeapYear());
		assertFalse(new DateObj(2003, 1, 1).isLeapYear());
		assertTrue(new DateObj(2004, 1, 1).isLeapYear());
		assertFalse(new DateObj(2005, 1, 1).isLeapYear());
		assertFalse(new DateObj(2006, 1, 1).isLeapYear());
		assertFalse(new DateObj(2007, 1, 1).isLeapYear());
		assertTrue(new DateObj(2008, 1, 1).isLeapYear());
		
		assertFalse(new DateObj(1400, 1, 1).isLeapYear());

	}
	
	@Test
	public void nextDate_leapYearTest() {
		DateObj leapDay1 = new DateObj(2024, 2, 29);
		DateObj leapDay2 = new DateObj(2020, 2, 29);
		DateObj leapDay3 = new DateObj(2016, 2, 29);

		assertEquals("2024-3-1", new DateObj(2024, 2, 29).nextDate().toString());
		assertEquals("2020-3-1", new DateObj(2020, 2, 29).nextDate().toString());
		assertEquals("2016-3-1", new DateObj(2016, 2, 29).nextDate().toString());
	}
	
	
	@Test
	public void nextDate_YearTest() {
		assertEquals("2000-1-1", new DateObj(1999, 12, 31).nextDate().toString());
	}
	
	@Test
	public void nextDate_MonthTest() {
		assertEquals("1999-2-1", new DateObj(1999, 1, 31).nextDate().toString());
		assertEquals("1999-4-1", new DateObj(1999, 3, 31).nextDate().toString());
		assertEquals("1999-5-1", new DateObj(1999, 4, 30).nextDate().toString());
		assertEquals("2000-1-1", new DateObj(1999, 12, 31).nextDate().toString());
	}
	
	@Test
	public void nextDate_DayTest() {
		// next day
		assertEquals("1999-11-2", new DateObj(1999, 11, 1).nextDate().toString());
	
	    // next day of last day-of-month	
		assertEquals("1999-12-1", new DateObj(1999, 11, 30).nextDate().toString());
		
		// not leap year, next day of 2-28
		assertEquals("1999-3-1", new DateObj(1999, 2, 28).nextDate().toString());
		
		// leap year, next day of 2-29
		assertEquals("2020-3-1", new DateObj(2020, 2, 29).nextDate().toString());

		// leap/non-leap year, next day of rest
		assertEquals("1999-2-12", new DateObj(1999, 2, 11).nextDate().toString());
	}
	
	@Test
	public void validateOkTest() {
		// day >= 1
		new DateObj(1999, 1, 1);
		new DateObj(1999, 1, 30);

       // not leap year, month == 2, day <= 28
		new DateObj(1999, 2, 28);		

	    // not leap year, month == 2, day <= 29
		new DateObj(2000, 2, 29);

		// month != 2, day <= monthLength[day -1]
		new DateObj(1999, 1, 31);
		new DateObj(1999, 3, 31);
		new DateObj(1999, 4, 30);
		new DateObj(1999, 5, 31);
		new DateObj(1999, 6, 30);
		new DateObj(1999, 7, 31);
		new DateObj(1999, 8, 31);
		new DateObj(1999, 9, 30);
		new DateObj(1999, 10, 31);
		new DateObj(1999, 11, 30);
		new DateObj(1999, 12, 31);
		

		// 1 <= month <= 12)
		new DateObj(1999, 1, 1);
		new DateObj(1999, 2, 2);
		new DateObj(1999, 11, 11);
		new DateObj(1999, 12, 12);
		
		// day past, future
		new DateObj(0, 1, 1);
		new DateObj(0, 1, 1);
		new DateObj(3000, 1, 1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void validateThrowException_Month0Test() {
		new DateObj(1999, 0, 1);
	
	}

	@Test(expected=IllegalArgumentException.class)
	public void validateThrowException_Month13Test() {
		new DateObj(1999, 13, 1);
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void validateThrowException_Day0Test() {
		new DateObj(1999, 1, 0);		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void validateThrowException_Month2_LeapYear_Day30Test() {
		new DateObj(2000, 2, 30);		
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void validateThrowException_MonthNot2_Day31Test() {
		new DateObj(1999, 1, 32);
		new DateObj(1999, 3, 32);
		new DateObj(1999, 4, 31);
		new DateObj(1999, 5, 32);
		new DateObj(1999, 6, 31);
		new DateObj(1999, 7, 32);
		new DateObj(1999, 8, 32);
		new DateObj(1999, 9, 31);
		new DateObj(1999, 10, 32);
		new DateObj(1999, 11, 31);
		new DateObj(1999, 12, 32);
	}
}
