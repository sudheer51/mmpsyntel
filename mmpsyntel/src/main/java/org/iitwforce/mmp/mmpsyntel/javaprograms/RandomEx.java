package org.iitwforce.mmp.mmpsyntel.javaprograms;

import java.util.Calendar;
import java.util.Random;
//cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
//http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php
public class RandomEx {

	public static void main(String[] args) throws InterruptedException {

		for(int i=0;i<20;i++)
		{
			Calendar cal = Calendar.getInstance();
			System.out.println(cal.getTimeInMillis()%100000000);
			Thread.sleep(50);

		}
		
		String s = 1234567+"";
		System.out.println(s);
		 
		
		
		//	Random rand = new Random();
		//		
		//	for(int i=0;i<20;i++)
		//	{
		//		//Generate random int value with a boundary of 100 - range [0..99]
		//		int value = 1+rand.nextInt(1000000000);
		//		System.out.println(value);
		//	}

		//		//Generate Random Upper Case character
		//		int upperCaseValue = 65 + rand.nextInt(26);
		//		char upperCaseChar = (char)upperCaseValue;
		//		System.out.println(upperCaseChar);
		//		
		//		//Generate Random lower case Character
		//		int lowerCaseValue = 97+ rand.nextInt(26);
		//		char lowerCaseChar = (char)lowerCaseValue;
		//		System.out.println(lowerCaseChar);
		//		
		//		String randomEmailID="iitworkforce"+upperCaseChar+lowerCaseChar+value+"@gmail.com";
		//		System.out.println(randomEmailID);



	}
}
/*
byte
short
int 
long
float
double
char
boolean
 */





