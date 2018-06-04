package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 50 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setValid","isOn", "setRecurDays"};// The list of the of methods to be tested in the Appt class

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
     * Generate Random Tests that tests Appt Class.
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
				
				 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 24);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 60);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 31);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, -1, 2018);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data	 
				 //Construct a new Appointment object with the initial data	 
		         Appt appt = new Appt(startHour,
		                  startMinute ,
		                  startDay ,
		                  startMonth ,
		                  startYear ,
		                  title,
		                 description,
		                 emailAddress);
		         appt.setValid();
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);	
						   if (newTitle == null) {
							   assertTrue(appt.getTitle() == "");
						   }
						   else {
							   //assertTrue(appt.getTitle() == newTitle);
						   }
						}
					   else if (methodName.equals("setRecurDays")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int nullCheck=ValuesGenerator.getRandomIntBetween(random, 1, 2);
						   if(nullCheck == 1) {
							   int[] recurDays=null;
							   int recur=ApptRandomTest.RandomSelectRecur(random);
							   int recurIncrement = ValuesGenerator.RandInt(random);
							   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
							   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
							  // assertNull(appt.getRecurDays());
						   }
						   else {
							   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
							   int recur=ApptRandomTest.RandomSelectRecur(random);
							   int recurIncrement = ValuesGenerator.RandInt(random);
							   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
							   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
							   for( int j = 0; j < sizeArray; j++) {
								   assertEquals(recurDays[j], (appt.getRecurDays()[j]));
							   }
						   }
						}
					   else if (methodName.equals("setValid")) {
						   boolean expected = true;
						   int constructorNum=ValuesGenerator.getRandomIntBetween(random, 1, 2);
							   int newMinute=ValuesGenerator.getRandomIntBetween(random, -1, 60);
							   int newHour=ValuesGenerator.getRandomIntBetween(random, -1, 24);
							   int newDay=ValuesGenerator.getRandomIntBetween(random, 0, 30);
							   int newMonth=ValuesGenerator.getRandomIntBetween(random, 0, 12);
							   int newYear=ValuesGenerator.getRandomIntBetween(random, 0, 2018);
							   if(newMonth < 1 || newMonth > 13) {
								   expected = false;				
							   }
							   if (newHour < 0 || newHour > 23) {
								   expected = false;
							   }
							   if (newMinute < 0 || newMinute > 59) {
								   expected = false;
							   }
							   if (newYear <= 0) {
								   expected = false;
							   }
							   if(newDay < 1) {
								   expected = false;
							   }
							   if(newMonth == 2) {
								   if(newDay > 29) {
									   expected = false;
								   }
								   if(newYear%4 != 0 && newDay == 29) {
									   expected = false;
								   }
								   else {
									   if(newYear%100 == 0 && newYear%400 != 0 && newDay == 29) {
										   expected = false;
									   }
								   }
							   
							   }
							   appt.setStartDay(newDay);
							   appt.setStartHour(newHour);
							   appt.setStartMonth(newMonth);
							   appt.setStartMinute(newMinute);
							   appt.setStartYear(newYear);
							   appt.setValid();
							   assertEquals(expected, appt.getValid());
					   }
					   else if (methodName.equals("isOn")) {
						   int newDay=ValuesGenerator.getRandomIntBetween(random, 1, 31);
						   int newMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
						   int newYear=ValuesGenerator.getRandomIntBetween(random, -1, 2018);
						   appt.setStartDay(newDay);
						   appt.setStartMonth(newMonth);
						   appt.setStartYear(newYear);
						   assertTrue(appt.isOn(newDay, newMonth, newYear));
						   assertFalse(appt.isOn(newDay+1, newMonth, newYear));
						   assertFalse(appt.isOn(newDay, newMonth+1, newYear));
						   assertFalse(appt.isOn(newDay, newMonth, newYear+1));
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
	 
	/* @Test //test all the set/get methods
	  public void radnomtest2()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 try{ 
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {
					long randomseed =System.currentTimeMillis(); //10
					//System.out.println(" Seed:"+randomseed );
					Random random = new Random(randomseed);
					
					 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 24);
					 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 60);
					 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 31);
					 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
					 int startYear=ValuesGenerator.getRandomIntBetween(random, -1, 2018);
					 String title=(String) ValuesGenerator.getString(random);
					 String description=(String) ValuesGenerator.getString(random);
					 String emailAddress=(String) ValuesGenerator.getString(random);
 
					 //Construct a new Appointment object with the initial data	 
			         Appt appt = new Appt(startDay ,
			                  startMonth ,
			                  startYear ,
			                  title,
			                 description,
			                 emailAddress);
				 if(!appt.getValid())continue;
				for (int i = 0; i < NUM_TESTS; i++) {
						appt.setStartHour(startHour);
						appt.setStartMinute(startMinute);;
						if(title == null) {
							assertTrue(appt.getTitle() == "");
						}
						else {
							assertTrue(appt.getTitle() == title);
						}
						if(description == null) {
							assertTrue(appt.getDescription() == "");
						}
						else {
							assertTrue(appt.getDescription() == description);
						}
						if(emailAddress == null) {
							assertTrue(appt.getEmailAddress() == "");
						}
						else {
							assertTrue(appt.getEmailAddress() == emailAddress);
						}
						assertTrue(appt.getStartHour() == startHour);
						assertTrue(appt.getStartMinute() == startMinute);
						assertTrue(appt.getStartDay() == startDay);
						assertTrue(appt.getStartMonth() == startMonth);
						assertTrue(appt.getStartYear() == startYear);
				}	
					
					
					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				        if((iteration%10000)==0 && iteration!=0 )
				              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				 
				}
			}catch(NullPointerException e){
				
			}
		 
			 System.out.println("Done testing...");
		
	 }
	 
	 @Test //test toString
	  public void radnomtest3()  throws Throwable  {

		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 
		 System.out.println("Start testing...");
		 try{ 
				for (int iteration = 0; elapsed < TestTimeout; iteration++) {
					long randomseed =System.currentTimeMillis(); //10
					//System.out.println(" Seed:"+randomseed );
					Random random = new Random(randomseed);
					
					 int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 24);
					 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 60);
					 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 31);
					 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
					 int startYear=ValuesGenerator.getRandomIntBetween(random, -1, 2018);
					 String title=(String) ValuesGenerator.getString(random);
					 String description=(String) ValuesGenerator.getString(random);
					 String emailAddress=(String) ValuesGenerator.getString(random);

					 //Construct a new Appointment object with the initial data	 
			         Appt appt = new Appt(startHour,
			        		  startMinute, 
			        		  startDay ,
			                  startMonth ,
			                  startYear ,
			                  title,
			                 description,
			                 emailAddress);
				 if(appt.getValid()){
					 for (int i = 0; i < NUM_TESTS; i++) {
						 String buffer = "\t";
						 String day= appt.getStartMonth()+"/"+appt.getStartDay()+"/"+appt.getStartYear() + " at ";
						 buffer = buffer + day;
						 String half = (appt.getStartHour() > 11) ? "pm" : "am";
						 int hour = appt.getStartHour();
						 if(hour > 11) {
							 hour -= 12;
						 }
						 if(hour == 0) {
							 hour = 12;
						 }
						 buffer = buffer + hour + ":"+ appt.getStartMinute() + half;
						 if(title == null) {
							 buffer = buffer + " ,, ";
						 }
						 else {
							 buffer = buffer + " ," + title + ", ";
						 }
						 if(description == null) {
							 buffer = buffer + "\n";
						 }
						 else {
							 buffer = buffer + description + "\n";
						 }
						 assertEquals(buffer, appt.toString());
						
					 }
				 }
				
					
					
					 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				        if((iteration%10000)==0 && iteration!=0 )
				              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
				 
				}
			}catch(NullPointerException e){
				
			}
		 
			 System.out.println("Done testing...");
		
	 }*/


	
}
