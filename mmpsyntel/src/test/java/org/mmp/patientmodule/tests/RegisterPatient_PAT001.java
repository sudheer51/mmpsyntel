package org.mmp.patientmodule.tests;

import java.util.Calendar;
import java.util.Random;

import org.mmp.util.BaseClass;
import org.mmp.util.MMPLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegisterPatient_PAT001 extends BaseClass{



//	@Test
//	public void validate_fname_field()
//	{
//		MMPLibrary mmpLib = new MMPLibrary(driver);
//		mmpLib.launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");
//		driver.findElement(By.name("register")).click();
//		SoftAssert sa = new SoftAssert();
//
//		String actual = driver.findElement(By.id("firsterr")).getText();
//		String expected="please enter First name";
//		sa.assertEquals(actual, expected);
//
//		driver.findElement(By.id("firstname")).click();
//		driver.findElement(By.id("firstname")).sendKeys("12345");
//		driver.findElement(By.name("register")).click();
//		actual = driver.findElement(By.id("firsterr1")).getText();
//		expected="please enter only alphabets";
//		sa.assertEquals(actual,expected);
//
//		sa.assertAll();
//	}
	@Test
	public void registerPatient()
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.launchApplication("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");
		 
	}
	 

}
