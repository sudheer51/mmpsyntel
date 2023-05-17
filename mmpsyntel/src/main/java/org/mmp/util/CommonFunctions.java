package org.mmp.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CommonFunctions {

	public static String getFutureDate(int noofdays,String pattern)
	{

		Calendar cal = 	Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noofdays);
		Date d = cal.getTime();
		System.out.println("Current Date :" + d);
		SimpleDateFormat sdf = new SimpleDateFormat();
		String defaultformat = sdf.format(d);
		System.out.println(defaultformat);
		
		sdf = new SimpleDateFormat(pattern);
		String formatDate = sdf.format(d);
		System.out.println(formatDate);
		return formatDate;
	}
	public long getRandomLicenseValue()
	{
		Calendar cal = Calendar.getInstance();
		return (cal.getTimeInMillis()%100000000);

	}
	public long getRandomSSNValue()
	{
		Calendar cal = Calendar.getInstance();
		return (cal.getTimeInMillis()%1000000000);

	}
	public String generateRandomString()
	{
	 
		Random rand = new Random();
		int randValue = 1+rand.nextInt(1000);
		System.out.println(randValue);


		//Generate Random Upper Case character
		int upperCaseValue = 65 + rand.nextInt(26);
		char upperCaseChar = (char)upperCaseValue;
		System.out.println(upperCaseChar);

		//Generate Random lower case Character
		int lowerCaseValue = 97+ rand.nextInt(26);
		char lowerCaseChar = (char)lowerCaseValue;
		System.out.println(lowerCaseChar);
		
		String name="QAAUTOMATION"+upperCaseChar+ lowerCaseChar+randValue;
		return name;


	}
}
