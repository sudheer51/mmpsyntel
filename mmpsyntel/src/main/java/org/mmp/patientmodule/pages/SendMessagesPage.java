package org.mmp.patientmodule.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMessagesPage {
	WebDriver driver;
	public SendMessagesPage(WebDriver driver)
	{
		this.driver= driver;
	}
	public String sendMessages(String reason,String subject)
	{
		
		driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).click();
		driver.findElement(By.id("subject")).sendKeys(reason);
		driver.findElement(By.id("message")).sendKeys(subject);
		Alert alrt = driver.switchTo().alert();
		String message = alrt.getText();
		alrt.accept();
		return message;
	 
	}

}
