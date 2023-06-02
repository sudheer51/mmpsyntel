package org.mmp.adminmodule.pages;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendMessagesAdminPage {
	
	WebDriver driver;
	HashMap<String,String> actualHMap = new HashMap<String,String>();
	public SendMessagesAdminPage(WebDriver driver)
	{
		this.driver= driver;
	}
	public HashMap<String, String> fetchMessageDetails()
	{
		driver.findElement(By.xpath("//span[normalize-space()='Messages']")).click();
		actualHMap.put("fName", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[1]")).getText());
		actualHMap.put("reason", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[2]")).getText());
		Duration d =  Duration.ofSeconds(30);
		WebDriverWait wait = new WebDriverWait(driver, d);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']/tbody/tr[2]/td[3]")));
		actualHMap.put("date", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[2]/td[3]")).getText());
		actualHMap.put("subject", driver.findElement(By.xpath("//table[@class='table']/tbody/tr[3]/td[2]")).getText());
		return actualHMap;
	 
	}
}
