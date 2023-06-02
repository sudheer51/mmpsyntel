package org.mmp.patientmodule.tests;

import org.mmp.util.BaseClass;
import org.mmp.util.MMPLibrary;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTests_PAT002 extends BaseClass{
	
	 
	@Parameters({ "username","password" })
	@Test(description="TC_001 Login to Patient Module with valid credentails")
	public void TC_001_login_valid_creds(String username,String password)
	{
	 
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(username,password,pro.getProperty("patientURL"));
		String expectedResult="Patient Portal";
		String actualResult= driver.findElement(By.xpath("//h3[normalize-space()='Patient Portal']")).getText();
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Parameters({ "username","password" })
	@Test(description="TC_002 Login to Patient Module with valid credentails to verify the tabs")
	public void TC_002_login_valid_creds(String username,String password)
	{
		 
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(username,password,pro.getProperty("patientURL"));
		SoftAssert sa = new SoftAssert();
		String expectedtab1="HOME";
		String actualTab1=driver.findElement(By.xpath("//span[contains(text(),'HOME')]")).getText();
		sa.assertEquals(expectedtab1, actualTab1);
		sa.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).getText(), "Profile");
		sa.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).getText(), "Schedule Appointment");
		sa.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Information')]")).getText(), "Information");
		sa.assertEquals(driver.findElement(By.xpath("//span[contains(text(),'Fees')]")).getText(), "Fees");
		sa.assertAll();
		
	}
	@Parameters({ "username","invpassword" })
	@Test(description="TC_003 Login to Patient Module with valid username and invalid password")
	public void TC_003_login_invalid_creds(String username,String invpassword)
	{
		 
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(username,invpassword,pro.getProperty("patientURL"));
		String expectedResult="Wrong username and password.";
		Alert alrt = driver.switchTo().alert();
		String actualResult= alrt.getText().trim();
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Parameters({ "invusername","password" })
	@Test(description="TC_004 Login to Patient Module with invalid username and password")
	public void TC_004_login_invalid_creds(String invusername,String password)
	{
	 
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(invusername,password,pro.getProperty("patientURL"));
		String expectedResult="Wrong username and password.";
		Alert alrt = driver.switchTo().alert();
		String actualResult= alrt.getText().trim();
		Assert.assertEquals(actualResult, expectedResult);
	}

}
