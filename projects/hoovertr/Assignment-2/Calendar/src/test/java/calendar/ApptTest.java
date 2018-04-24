/** A JUnit test class to test the class ApptTest. */

package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalendarUtil;
public class ApptTest  {

@Test(timeout = 4000)
 public void test00()  throws Throwable  {
      Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
      String string0 = appt0.toString();
      assertEquals(2, appt0.getRecurBy());
      assertFalse(appt0.isRecurring());
      assertEquals("\t14/9/2018 at 3:30pm ,Birthday Party, This is my birthday party\n", string0);
      assertEquals(0, appt0.getRecurIncrement());
      appt0.setValid();
  }
@Test(timeout = 4000)
 public void test01()  throws Throwable  {
	  Appt appt0 = new Appt(15, 30, 9, 12, 2018, null, null, null);
	  String string0 = appt0.toString();
	  int startHour = appt0.getStartHour();
	  int startMin = appt0.getStartMinute();
	  int startDay = appt0.getStartDay();
	  int startMonth = appt0.getStartMonth();
	  int startYear = appt0.getStartYear();
	  assertEquals(15, startHour);
	  assertEquals(30, startMin);
	  assertEquals(9, startDay);
	  assertEquals(12, startMonth);
	  assertEquals(2018, startYear);
	  appt0.setValid();
}
@Test(timeout = 4000)
  public void test02()	throws Throwable  {
		Appt appt0 = new Appt(9, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		appt0.setValid();
		appt0.getXmlElement();
		assertEquals("Birthday Party", appt0.getTitle());
		assertEquals("This is my birthday party", appt0.getDescription());
		assertEquals("xyz@gmail.com", appt0.getEmailAddress());
		
}

@Test(timeout = 4000)
  public void test03()  throws Throwable  {
		Appt appt0 = new Appt(9, 12, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
		String string0 = appt0.toString();
		assertTrue(appt0.isOn(9, 12, 2018));
		assertFalse(appt0.hasTimeSet());
}

@Test(timeout = 4000)
public void test04()  throws Throwable  {
		Appt appt0 = new Appt(12, 0, 11, 29, 2018, "Treys Birthday", "Its Trey's Birthday", "NotTreysEmail@gmail.com");
		String string0 = appt0.toString();
		appt0.setRecurrence(null, 10, 2, 5);
		assertEquals(10, appt0.getRecurBy());
		assertEquals(2, appt0.getRecurIncrement());
		assertEquals(5, appt0.getRecurNumber());
}

@Test(timeout = 4000)
public void test05()  throws Throwable  {
		Appt appt0 = new Appt(1, 1, 2000, "Millenium Party", "Its a new year", "TheFutureIsHere@yahoo.com");
		appt0.setValid();
		assertFalse(appt0.getValid());
}

@Test(timeout = 4000)
public void test06()  throws Throwable  {
	Appt appt0 = new Appt(25, 0, 1, 2, 2000, "Invalid Hour", "There are 25 hours in a day?", "TheFutureIsHere@yahoo.com");
	appt0.setValid();
	assertFalse(appt0.getValid());
}

@Test(timeout = 4000)
public void test07()  throws Throwable  {
	Appt appt0 = new Appt(12, 65, 1, 2, 2000, "Invalid Minute", "There are only 60 minutes in an hour", "xyz@gmail.com");
	appt0.setValid();
	assertFalse(appt0.getValid());
}

@Test(timeout = 4000)
public void test08()  throws Throwable  {
	Appt appt0 = new Appt(12, 30, 1, 2, -5, "Invalid Year", "Its 5 BC!", "xyz@gmail.com");
	appt0.setValid();
	assertFalse(appt0.getValid());
}

@Test(timeout = 4000)
public void test09()  throws Throwable  {
	Appt appt0 = new Appt(12, 0, 11, 29, 2018, "Treys Birthday", "Its Trey's Birthday", "NotTreysEmail@gmail.com");
	int[] recurDays = {2,3,4};
	appt0.setRecurrence(recurDays, 2, 1, Appt.RECUR_NUMBER_FOREVER);
	assertTrue(appt0.isRecurring());
}
}
