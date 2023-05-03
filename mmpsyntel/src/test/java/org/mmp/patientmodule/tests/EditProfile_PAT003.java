package org.mmp.patientmodule.tests;

import org.mmp.util.BaseClass;
import org.mmp.util.MMPLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditProfile_PAT003 extends BaseClass{

	@Parameters({ "username","password" })
	@Test(description="TC_006 Validate clicking on the Profile tab displays all uneditable fields")
	public void TC_006_validate_uneditable_fields(String username,String password)
	{
		 
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(username,password); 
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(Boolean.parseBoolean(driver.findElement(By.id("fname")).getAttribute("readonly")));
		sa.assertTrue(Boolean.parseBoolean(driver.findElement(By.id("lname")).getAttribute("readonly")));
		sa.assertAll();
		 
	}

}
