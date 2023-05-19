package org.mmp.patientmodule.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPatientPage {
	WebDriver driver;
	public RegisterPatientPage(WebDriver driver)
	{
		this.driver= driver;
		
	}
	public void enterFirstName(String fNameValue)
	{
		driver.findElement(By.id("firstname")).sendKeys(fNameValue);
		driver.findElement(By.id("firstname")).click();
	}
	public void enterLastName(String lNameValue)
	{
		driver.findElement(By.id("lastname")).sendKeys(lNameValue);
		driver.findElement(By.id("lastname")).click();
	}
	public void enterState(String stateValue)
	{
		driver.findElement(By.id("state")).sendKeys(stateValue);
		driver.findElement(By.id("state")).click();
	}
	public void enterCity(String cityValue)
	{
		driver.findElement(By.id("city")).sendKeys(cityValue);
		driver.findElement(By.id("city")).click();
	}
	public void enterAddress(String addressValue)
	{
		driver.findElement(By.id("address")).sendKeys(addressValue);
		driver.findElement(By.id("address")).click();
	}
	public boolean registerPatient()
	{
		driver.findElement(By.name("register")).click();
		 
		enterFirstName("QAAUTFNAME");
		enterLastName("QAAUTLNAME");
		enterState("QAAUTStates");
		enterCity("QAAUTCITY");
		enterAddress("QAAUTAddress");
//	 
//		driver.findElement(By.id("zipcode")).sendKeys("12345");
//		driver.findElement(By.id("zipcode")).click();
//		driver.findElement(By.id("datepicker")).sendKeys("20/01/1950");
//		driver.findElement(By.id("datepicker")).click();
//		 
//		driver.findElement(By.cssSelector("body")).click();
//		//driver.findElement(By.id("ssn")).sendKeys(getRandomSSNValue()+"");
//		driver.findElement(By.id("ssn")).click();
//		driver.findElement(By.cssSelector("body")).click();
//	 
//		driver.findElement(By.id("age")).sendKeys("50");
//		driver.findElement(By.id("age")).click();
//		 
//		driver.findElement(By.id("height")).sendKeys("90");
//		driver.findElement(By.id("height")).click();
//		 
//		driver.findElement(By.id("weight")).sendKeys("150");
//		driver.findElement(By.id("weight")).click();
//	 
//		driver.findElement(By.id("pharmacy")).sendKeys("quautpharmacy");
//		driver.findElement(By.id("pharmacy")).click();
//		driver.findElement(By.id("pharma_adress")).sendKeys("qaautaddress");
//		driver.findElement(By.id("pharma_adress")).click();
//		driver.findElement(By.id("email")).sendKeys(generateRandomString()+"@gmail.com");
//		driver.findElement(By.id("email")).click();
//		driver.findElement(By.id("username")).sendKeys(generateRandomString());
//		driver.findElement(By.id("username")).click();
//		String password= generateRandomString();
//		System.out.println("Random String Generated for Password" + password);
//		driver.findElement(By.id("password")).sendKeys(password);
//		driver.findElement(By.id("password")).click();
//		driver.findElement(By.id("confirmpassword")).sendKeys(password);
//		driver.findElement(By.id("confirmpassword")).click();
//		driver.findElement(By.id("security")).click();
//		WebElement dropdown = driver.findElement(By.id("security"));
//		dropdown.findElement(By.xpath("//option[. = 'What is your mother maiden name']")).click();
//		driver.findElement(By.id("answer")).click();
//		driver.findElement(By.id("answer")).sendKeys(generateRandomString());
//		driver.findElement(By.name("register")).click();
//		driver.findElement(By.id("license")).sendKeys("12345678");
//		driver.findElement(By.id("license")).click();
//		driver.findElement(By.name("register")).click();
//		Alert alrt = driver.switchTo().alert();
//		System.out.println(alrt.getText());
		return true;
	}

}
