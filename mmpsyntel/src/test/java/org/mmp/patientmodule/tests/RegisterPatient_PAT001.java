package org.mmp.patientmodule.tests;

import java.util.Calendar;
import java.util.Random;

import org.mmp.util.BaseClass;
import org.mmp.util.MMPLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
		driver.findElement(By.name("register")).click();
		 
		driver.findElement(By.id("firstname")).sendKeys("QAAUTFNAME");
		driver.findElement(By.id("firstname")).click();
		driver.findElement(By.id("lastname")).sendKeys("QAAUTLNAME");
		driver.findElement(By.id("lastname")).click();
		driver.findElement(By.id("state")).sendKeys("QAAUTStates");
		driver.findElement(By.id("state")).click();
		driver.findElement(By.id("city")).sendKeys("QAAUTCITY");
		driver.findElement(By.id("city")).click();
		driver.findElement(By.id("address")).sendKeys("QAAUTAddress");
		driver.findElement(By.id("address")).click();
		driver.findElement(By.id("zipcode")).sendKeys("12345");
		driver.findElement(By.id("zipcode")).click();
		driver.findElement(By.id("datepicker")).sendKeys("20/01/1950");
		driver.findElement(By.id("datepicker")).click();
		 
		driver.findElement(By.cssSelector("body")).click();
		driver.findElement(By.id("ssn")).sendKeys(getRandomSSNValue()+"");
		driver.findElement(By.id("ssn")).click();
		driver.findElement(By.cssSelector("body")).click();
	 
		driver.findElement(By.id("age")).sendKeys("50");
		driver.findElement(By.id("age")).click();
		 
		driver.findElement(By.id("height")).sendKeys("90");
		driver.findElement(By.id("height")).click();
		 
		driver.findElement(By.id("weight")).sendKeys("150");
		driver.findElement(By.id("weight")).click();
	 
		driver.findElement(By.id("pharmacy")).sendKeys("quautpharmacy");
		driver.findElement(By.id("pharmacy")).click();
		driver.findElement(By.id("pharma_adress")).sendKeys("qaautaddress");
		driver.findElement(By.id("pharma_adress")).click();
		driver.findElement(By.id("email")).sendKeys(generateRandomString()+"@gmail.com");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("username")).sendKeys(generateRandomString());
		driver.findElement(By.id("username")).click();
		String password= generateRandomString();
		System.out.println("Random String Generated for Password" + password);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("password")).click();
		driver.findElement(By.id("confirmpassword")).sendKeys(password);
		driver.findElement(By.id("confirmpassword")).click();
		driver.findElement(By.id("security")).click();
		WebElement dropdown = driver.findElement(By.id("security"));
		dropdown.findElement(By.xpath("//option[. = 'What is your mother maiden name']")).click();
		driver.findElement(By.id("answer")).click();
		driver.findElement(By.id("answer")).sendKeys(generateRandomString());
		driver.findElement(By.name("register")).click();
		driver.findElement(By.id("license")).sendKeys("12345678");
		driver.findElement(By.id("license")).click();
		driver.findElement(By.name("register")).click();
		Alert alrt = driver.switchTo().alert();
		System.out.println(alrt.getText());
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
