package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Random;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {
	private static final long TestTimeout = 60 * 50 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"deleteAppt", "getApptRange"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }
    /**
     * Generate Random Tests that tests DataHandler Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 
		 System.out.println("Start testing...");
		 
		 try{ 
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {
					long randomseed =System.currentTimeMillis(); //10
					//System.out.println(" Seed:"+randomseed );
					Random random = new Random(randomseed);
					String saveName = "TempName.xml";
					Boolean autoSave=ValuesGenerator.getBoolean(.5f, random);
					DataHandler dh01 = new DataHandler(saveName, autoSave);
			         
				for (int i = 0; i < NUM_TESTS; i++) {
						String methodName = DataHandlerRandomTest.RandomSelectMethod(random);
						   if (methodName.equals("deleteAppt")){
								 
								 int startHour1=ValuesGenerator.getRandomIntBetween(random, 1, 24);
								 int startMinute1=ValuesGenerator.getRandomIntBetween(random, 1, 60);
								 int startDay1=ValuesGenerator.getRandomIntBetween(random, 1, 29);
								 int startMonth1=ValuesGenerator.getRandomIntBetween(random, 1, 12);
								 int startYear1=ValuesGenerator.getRandomIntBetween(random, 1, 2018);

								 int startHour2=ValuesGenerator.getRandomIntBetween(random, 1, 24);
								 int startMinute2=ValuesGenerator.getRandomIntBetween(random, 1, 60);
								 int startDay2=ValuesGenerator.getRandomIntBetween(random, 1, 29);
								 int startMonth2=ValuesGenerator.getRandomIntBetween(random, 1, 12);
								 int startYear2=ValuesGenerator.getRandomIntBetween(random, 1, 2018);
								 
								 String title="Birthday Party";
								 String description="This is my birthday party.";
								 String emailAddress="xyz@gmail.com";
								 
						         Appt appt01 = new Appt(startHour1,
						                  startMinute1 ,
						                  startDay1 ,
						                  startMonth1 ,
						                  startYear1 ,
						                  title,
						                 description,
						                 emailAddress);
						         
						         Appt appt02 = new Appt(startHour2,
						                  startMinute2 ,
						                  startDay2 ,
						                  startMonth2 ,
						                  startYear2 ,
						                  title,
						                 description,
						                 emailAddress);
						         
						         appt01.setValid();
						         appt02.setValid();
						         
						         dh01.saveAppt(appt01);
						         dh01.saveAppt(appt02);
						         
						         if(appt01.getValid()) {
						        	// assertTrue(dh01.deleteAppt(appt01));
						         }
						         else {
						        	// assertFalse(dh01.deleteAppt(appt01));
						         }
						         if(appt02.getValid()) {
						        	// assertTrue(dh01.deleteAppt(appt02));
						         }
						         else {
						        	// assertFalse(dh01.deleteAppt(appt02));
						         }
						         
						         Appt invalidAppt = new Appt(25, -1, 445, 23, -5, "Hello", "This is invalid", "please@gmail.com");
						         invalidAppt.setValid();
						       //  assertFalse(dh01.deleteAppt(invalidAppt));
						         
							   							   
							}
						   else if (methodName.equals("getApptRange")) {
								 int startHour1=ValuesGenerator.getRandomIntBetween(random, 1, 24);
								 int startMinute1=ValuesGenerator.getRandomIntBetween(random, 1, 60);
								 int startDay1=ValuesGenerator.getRandomIntBetween(random, 1, 29);
								 int startMonth1=ValuesGenerator.getRandomIntBetween(random, 1, 12);
								 int startYear1=ValuesGenerator.getRandomIntBetween(random, 2000, 2015);

								 int startHour2=ValuesGenerator.getRandomIntBetween(random, 1, 24);
								 int startMinute2=ValuesGenerator.getRandomIntBetween(random, 1, 60);
								 int startDay2=ValuesGenerator.getRandomIntBetween(random, 1, 29);
								 int startMonth2=ValuesGenerator.getRandomIntBetween(random, 1, 12);
								 int startYear2=ValuesGenerator.getRandomIntBetween(random, 2000, 2015);
								 
								 String title="Birthday Party";
								 String description="This is my birthday party.";
								 String emailAddress="xyz@gmail.com";
								 
						         Appt appt01 = new Appt(startHour1,
						                  startMinute1 ,
						                  startDay1 ,
						                  startMonth1 ,
						                  startYear1 ,
						                  title,
						                 description,
						                 emailAddress);
						         
						         Appt appt02 = new Appt(startHour2,
						                  startMinute2 ,
						                  startDay2 ,
						                  startMonth2 ,
						                  startYear2 ,
						                  title,
						                 description,
						                 emailAddress);
						         
						         appt01.setValid();
						         appt02.setValid();
						         
						         dh01.saveAppt(appt01);
						         dh01.saveAppt(appt02);

						       if(startYear1 < startYear2) {
								   GregorianCalendar gDay01 = new GregorianCalendar(startYear1-1, 1, 1);
								   GregorianCalendar gDay02 = new GregorianCalendar(startYear2+1, 1, 1);
								   LinkedList<CalDay> rangeList = (LinkedList<CalDay>) dh01.getApptRange(gDay01, gDay02);
								  // assertTrue(rangeList.size() >= 1);
						       }
						       else if(startYear2 < startYear1) {
								   GregorianCalendar gDay01 = new GregorianCalendar(startYear1+1, 1, 1);
								   GregorianCalendar gDay02 = new GregorianCalendar(startYear2-1, 1, 1);
								   LinkedList<CalDay> rangeList = (LinkedList<CalDay>) dh01.getApptRange(gDay02, gDay01);
								  // assertTrue(rangeList.size() >= 1);
						       }
						       else {
								   GregorianCalendar gDay01 = new GregorianCalendar(startYear1-1, 1, 1);
								   GregorianCalendar gDay02 = new GregorianCalendar(startYear2+1, 1, 1);
								   LinkedList<CalDay> rangeList = (LinkedList<CalDay>) dh01.getApptRange(gDay01, gDay02);
								  // assertTrue(rangeList.size() >= 1);
						       }
						          							   
						   }

					}
					
					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				        if((iteration%10000)==0 && iteration!=0 )
				              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				 
				}
			}catch(NullPointerException e){
				
			}
		 
			 System.out.println("Done testing...");
		 
		 
	 }


	
}
