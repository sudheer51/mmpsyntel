package org.mmp.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMPLibrary {

	WebDriver driver;
	public MMPLibrary(WebDriver driver)
	{
		this.driver= driver;
		 
	}
	
	public void login(String username,String password,String url)
	{
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Sign In']")).click();	
		
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
