/** A JUnit test class to test the class CalDay. */

package calendar;
import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;


public class CalDayTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  CalDay day01 = new CalDay();
	  assertFalse(day01.isValid());
	  assertNull(day01.iterator());
  }
  
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	  GregorianCalendar gDay = new GregorianCalendar(2000, 2, 1);
	  CalDay day01 = new CalDay(gDay);
	  assertTrue(day01.isValid());
	  assertEquals(2000, day01.getYear());
	  assertEquals(3, day01.getMonth());
	  assertEquals(1, day01.getDay());
  }

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
	  GregorianCalendar gDay = new GregorianCalendar(2000, 2, 1);
	  CalDay day01 = new CalDay(gDay);
	  Appt appt0 = new Appt(12, 30, 29, 11, 2018, "Trey's Birthday", "It's my birthday", "noemail@gmail.com");
	  appt0.setValid();
	  day01.addAppt(appt0);
	  assertEquals(1, day01.getSizeAppts());
  }
  
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
	  GregorianCalendar gDay = new GregorianCalendar(2000, 2, 1);
	  CalDay day01 = new CalDay(gDay);
	  assertTrue(day01.isValid());
	  Appt appt0 = new Appt(12, 30, 29, 11, 2018, "Trey's Birthday", "It's my birthday", "noemail@gmail.com");
	  appt0.setValid();
	  day01.addAppt(appt0);
	  Appt appt1 = new Appt(5, 5, 2015, "Something happens", "It was cool", "someone@somewhere.com");
	  day01.addAppt(appt1);
	  assertEquals(2, day01.getSizeAppts());
  }
  
  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
	  GregorianCalendar gDay = new GregorianCalendar(2000, 2, 1);
	  CalDay day01 = new CalDay(gDay);
	  Appt appt0 = new Appt(12, 30, 29, 11, 2018, "Trey's Birthday", "It's my birthday", "noemail@gmail.com");
	  appt0.setValid();
	  day01.addAppt(appt0);
	  Appt appt1 = new Appt(15, 30, 5, 5, 2015, "Something happens", "It was cool", "someone@somewhere.com");
	  day01.addAppt(appt1);
	  Appt appt2 = new Appt(13, 0, 6, 3, 2020, "Hour in the middle", "Will it place correctly", "hopeso@gmail.com");
	  day01.addAppt(appt2);
	  assertEquals(3, day01.getSizeAppts());
  }
  
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
	  GregorianCalendar gDay = new GregorianCalendar(2000, 2, 1);
	  CalDay day01 = new CalDay(gDay);
	  assertNotEquals("", day01.toString());
  }
  
  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
	  GregorianCalendar gDay = new GregorianCalendar(2000, 2, 1);
	  CalDay day01 = new CalDay(gDay);
	  String str1 = day01.getFullInfomrationApp(day01);
	  Appt appt0 = new Appt(12, 30, 5, 5, 2015, null, null, null);
	  day01.addAppt(appt0);
	  String str2 = day01.getFullInfomrationApp(day01);
	  assertNotEquals(str1, str2);
  }

 @Test(timeout = 4000)
  public void test07()  throws Throwable  {
	  GregorianCalendar gDay = new GregorianCalendar(2000, 2, 1);
	  CalDay day01 = new CalDay(gDay);
	  CalDay day02 = new CalDay(gDay);
	  
	  Appt appt0 = new Appt(13, 30, 5, 5, 2015, null, null, null);
	  day01.addAppt(appt0);
	  Appt appt1 = new Appt(0, 5, 5, 5, 2015, null, null, null);
	  day02.addAppt(appt1);
	  assertNotEquals(day01.getFullInfomrationApp(day01), day02.getFullInfomrationApp(day02));
  }
 
 @Test(timeout = 4000)
   public void test08()  throws Throwable  {
	  GregorianCalendar gDay = new GregorianCalendar(2000, 2, 1);
	  CalDay day01 = new CalDay(gDay);
	  Appt appt0 = new Appt(25, 0, 1, 1, -5, null, null, null);
	  appt0.setValid();
	  day01.addAppt(appt0);
	  assertEquals(0, day01.getSizeAppts());
  }
 
 @Test(timeout = 4000)
   public void test09()  throws Throwable  {
	 CalDay day01 = new CalDay();
	 String str1 = day01.toString();
	 assertEquals("",str1);
 }
 
 @Test(timeout = 4000)
   public void test10()  throws Throwable  {
	  GregorianCalendar gDay = new GregorianCalendar(2000, 2, 1);
	  CalDay day01 = new CalDay(gDay); 
	  Appt appt0 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  day01.addAppt(appt0);
	  Appt appt1 = new Appt(16, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  day01.addAppt(appt1);
	  assertEquals(2, day01.getSizeAppts());
	  assertTrue(day01.getAppts().get(0).getStartHour() < day01.getAppts().get(1).getStartHour());
 }
 
 @Test(timeout = 4000)
 public void test11()  throws Throwable  {
	  GregorianCalendar gDay = new GregorianCalendar(2000, 2, 1);
	  CalDay day01 = new CalDay(gDay); 
	  Appt appt0 = new Appt(16, 45, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  day01.addAppt(appt0);
	  Appt appt1 = new Appt(15, 15, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  day01.addAppt(appt1);
	  Appt appt2 = new Appt(17, 20, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  day01.addAppt(appt2);
	  assertTrue(day01.getAppts().get(1).getStartMinute() > day01.getAppts().get(2).getStartMinute());
	  assertTrue(day01.getAppts().get(0).getStartMinute() < day01.getAppts().get(1).getStartMinute());
	  assertTrue(day01.getAppts().get(0).getStartMinute() < day01.getAppts().get(2).getStartMinute());
}
 
@Test(timeout = 4000)
public void test12()  throws Throwable  {
	  GregorianCalendar Gday1 = new GregorianCalendar(2018,5,7);
	  CalDay day01 = new CalDay(Gday1);
	  Appt appt1 = new Appt(13, 30, 12, 3, 2015, "Hello there", "This is a test", "xyz@gmail.com");
	  day01.addAppt(appt1);
	  String buffer = "6-7-2018 \n\t1:30PM Hello there This is a test ";
	//  assertEquals(buffer, day01.getFullInfomrationApp(day01));
	  
	  GregorianCalendar Gday2 = new GregorianCalendar(2018,5,7);
	  CalDay day02 = new CalDay(Gday2);
	  Appt appt2 = new Appt(12, 30, 12, 3, 2018, "Hello there", "This is a test", "xyz@gmail.com");
	  day02.addAppt(appt2);
	  String buffer2 = "6-7-2018 \n\t0:30AM Hello there This is a test ";
	 // assertEquals(buffer2, day02.getFullInfomrationApp(day02));	
}

@Test(timeout = 4000)
public void test13()  throws Throwable  {
    GregorianCalendar Gday = new GregorianCalendar(2018, 5, 7);
    CalDay day01 = new CalDay(Gday);
    String theString = day01.toString();
    String buffer = "\t --- 7/7/2018 --- \n --- -------- Appointments ------------ --- \n\n";
    assertEquals(buffer, theString);
}

@Test(timeout = 4000)
public void test14()  throws Throwable  {
    GregorianCalendar Gday = new GregorianCalendar(2018, 5, 7);
    CalDay day01 = new CalDay(Gday);
    String buffer = "\t --- 6/7/2018 --- \n --- -------- Appointments ------------ --- \n\t";
    Appt appt = new Appt(12, 30, 12, 3, 2018, "Hello there", "This is a test", "xyz@gmail.com");
    day01.addAppt(appt);
    buffer += "3/12/2018 at 12:30pm ,Hello there, This is a test\n \n";
   // assertEquals(buffer, day01.toString());
}
@Test(timeout = 4000)
public void test15()  throws Throwable  {
GregorianCalendar Gday1 = new GregorianCalendar(2018,5,7);
CalDay day01 = new CalDay(Gday1);
Appt appt1 = new Appt(13, 10, 12, 3, 2015, "Hello there", "This is a test", "xyz@gmail.com");
day01.addAppt(appt1);
String buffer = "6-7-2018 \n\t1:10PM Hello there This is a test ";
//assertEquals(buffer, day01.getFullInfomrationApp(day01));
}

@Test(timeout = 4000)
public void test16()  throws Throwable  {
	  GregorianCalendar gDay = new GregorianCalendar(2000, 2, 1);
	  CalDay day01 = new CalDay(gDay); 
	  Appt appt0 = new Appt(15, 25, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  day01.addAppt(appt0);
	  Appt appt1 = new Appt(15, 30, 9, 14, 2018, "Birthday Party", "This is my birthday party", "xyz@gmail.com");
	  day01.addAppt(appt1);
	  assertEquals(2, day01.getSizeAppts());
	  assertTrue(day01.getAppts().get(0).getStartMinute() < day01.getAppts().get(1).getStartMinute());
}
}


