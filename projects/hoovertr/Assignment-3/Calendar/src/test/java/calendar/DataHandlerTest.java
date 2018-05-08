
/** A JUnit test class to test the class DataHandler. */


package calendar;

import org.junit.Test;
import static org.junit.Assert.*;
import calendar.Appt;
import calendar.CalDay;
import calendar.DataHandler;

import java.util.GregorianCalendar;
import java.util.LinkedList;


public class DataHandlerTest{

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
	  DataHandler dh01 = new DataHandler();
	  DataHandler dh02 = new DataHandler("Someplace");
	  GregorianCalendar day1 = new GregorianCalendar(2000, 5, 7);
	  GregorianCalendar day2 = new GregorianCalendar(2000, 5, 12);
	  assertNotEquals(dh01.getApptRange(day1,  day2), dh02.getApptRange(day1, day2));
 
	  
  }
  
  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
	  DataHandler dh01 = new DataHandler("Someplace else", true);
	  DataHandler dh02 = new DataHandler("Someplace");
	  GregorianCalendar day1 = new GregorianCalendar(2000, 5, 7);
	  GregorianCalendar day2 = new GregorianCalendar(2000, 5, 12);
	  assertNotEquals(dh01.getApptRange(day1,  day2), dh02.getApptRange(day1, day2));
	  
  }
  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
	  DataHandler dh01 = new DataHandler();
	  Appt appt01 = new Appt(17, 00, 23, 4, 2018, "Doing Homework", "Want to finish", "now@gmail.com");
	  dh01.saveAppt(appt01);
	  dh01.deleteAppt(appt01);
	  GregorianCalendar day1 = new GregorianCalendar(2000, 5, 7);
	  GregorianCalendar day2 = new GregorianCalendar(2000, 5, 12);
	  assertEquals(5, dh01.getApptRange(day1,  day2).size());
	  Appt appt02 = new Appt(25, 00, 8, 5, 2000, null, null, null);
	  appt02.setValid();
	  dh01.saveAppt(appt02);
	  dh01.deleteAppt(appt02);
	  assertEquals(5, dh01.getApptRange(day1,  day2).size());
	  
	  
  }
  
  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
	  DataHandler dh01 = new DataHandler("temp", false);
	  Appt appt01 = new Appt(17, 00, 23, 4, 2018, "Doing Homework", "Want to finish", "now@gmail.com");
	  int[] recurdays = {3, 4, 5};
	  appt01.setRecurrence(recurdays, 2, 2, 10);
	  dh01.saveAppt(appt01);
	  Appt appt02 = new Appt(25, 0, 8, 5, 200, null, null, null);
	  appt02.setValid();
	  dh01.deleteAppt(appt02);
	  assertEquals(true, dh01.deleteAppt(appt01));
	  
}
 @Test(timeout = 4000)
  public void test04()  throws Throwable  {
	 DataHandler dh01 = new DataHandler("temp", false);
	 Appt appt01 = new Appt(17, 00, 23, 4, 2018, "Doing Homework", "Want to finish", "now@gmail.com");
	 appt01.setXmlElement(null);
	 assertEquals(false, dh01.deleteAppt(appt01));
 }
  
  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      DataHandler dh01 = new DataHandler("temp", false);
      GregorianCalendar day1 = new GregorianCalendar(2010, 5, 10);
      GregorianCalendar day2 = new GregorianCalendar(2010, 6, 15);
      CalDay calDay1 = new CalDay(day1);
      CalDay calDay2 = new CalDay(day2);
      Appt appt01 = new Appt(4, 00, 12, 5, 2010, "Something happens", "description", "01@gmail.com");
      int[] recurDays = {0};
      appt01.setRecurrence(recurDays, 7, 7, 7);
      dh01.saveAppt(appt01);
      Appt appt02 = new Appt(9, 30, 23, 7, 2010, "Something else", "desc", "02@gmail.com");
      dh01.saveAppt(appt02);
      assertTrue(dh01.deleteAppt(appt01));
      try {
    	  assertNull(dh01.getApptRange(day2, day1));
      } catch (DateOutOfRangeException e){
    	  System.out.println("DateOutOfRangeException caught");
      }
      assertNotNull(dh01.getApptRange(day1, day2));
  }
  
  @Test(timeout = 4000)
  public void test06()  throws Throwable {
		Appt appt01 = new Appt(12,30,1,-1,2000,"Hello there", "This is a test", "xyz@gmail.com");
		DataHandler dh01 = new DataHandler("something", false);
		assertEquals(false, dh01.deleteAppt(appt01));
		assertEquals(true, dh01.save());
		assertEquals(true, dh01.saveAppt(appt01));
  }
  
  @Test(timeout = 4000)
  public void test07()  throws Throwable {
	  	Appt appt01 = new Appt(-100,-100,2,10,1000,"Hello there", "This is a test", "xyz@gmail.com");
		DataHandler dh01 = new DataHandler("\"something\n\n");
		assertEquals(false, dh01.deleteAppt(appt01));
		assertEquals(false, dh01.save());
		assertEquals(false, dh01.saveAppt(appt01));
	  
  }
  }
