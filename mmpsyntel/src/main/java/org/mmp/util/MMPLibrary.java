package org.mmp.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMPLibrary {

	WebDriver driver;
	public MMPLibrary(WebDriver driver)
	{
		this.driver= driver;
		 
	}
	
	public void login(String username,String password)
	{
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.name("submit")).click();	
		
	}
	public void launchApplication(String url)
	{
		driver.get(url);
	}
	public void navigateToAModule(String moduleName)
	{
		 //"+var+"
		driver.findElement(By.xpath("//span[contains(text(),'"+moduleName+"')]")).click();
	}
}
