package org.mmp.patientmodule.pages;

import java.util.HashMap;

import org.mmp.util.CommonFunctions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendMessagesPage {
	WebDriver driver;
	HashMap<String,String> expectedHMap = new HashMap<String,String>();
	public SendMessagesPage(WebDriver driver)
	{
		this.driver= driver;
	}
	public String sendMessages(String reason,String subject)
	{
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		String fName=driver.findElement(By.id("fname")).getText();
		expectedHMap.put("fName", fName);
		expectedHMap.put("reason", reason);
		expectedHMap.put("subject", subject);
		String date = CommonFunctions.getFutureDate(0,"dd-MM-yyyy");
		expectedHMap.put("date", date);
		driver.findElement(By.xpath("//span[contains(text(),'Messages')]")).click();
		driver.findElement(By.id("subject")).sendKeys(reason);
		driver.findElement(By.id("message")).sendKeys(subject);
		driver.findElement(By.xpath("//input[@value='Send']")).click();
		Alert alrt = driver.switchTo().alert();
		String successMessage = alrt.getText();
		alrt.accept();
		return successMessage;
	 
	}
	public HashMap<String, String> fetchSendMessagesDetails()
	{
		return expectedHMap;
	}

}
