package org.mmp.patientmodule.tests;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.mmp.util.BaseClass;
import org.mmp.util.MMPLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScheduleAppointment_PAT004 extends BaseClass{
	@Parameters({ "username","password" })
	@Test
	public void validateBookAppointment(String username,String password)
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(username,password); 
		driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		driver.findElement(By.xpath("//h4[text()='Dr.Beth']/ancestor::ul/following-sibling::button")).click();
		
		//Switch to a iframe
		driver.switchTo().frame("myframe");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("datepicker")));
		
		driver.findElement(By.id("datepicker")).click();
		String result = getFutureDate(60,"MMMMM/dd/yyyy");
		System.out.println(result);
		String dateArr[]=result.split("/");
		String expectedMonth = dateArr[0];
		System.out.println("ExpectedMonth::" + expectedMonth);
		String expectedDate= dateArr[1];
		String expectedYear= dateArr[2];
		
		String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		System.out.println("actualMonth::" + actualMonth);
		String actualYear=  driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		while(!(actualYear.equals(expectedYear)))
		{
			System.out.println("in while loop of year");
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
			actualYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
		}
		while(!(actualMonth.equals(expectedMonth)))
		{
			System.out.println("in while loop of month");
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
			actualMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
		}
		driver.findElement(By.linkText(expectedDate)).click();
		
		//driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
		//driver.findElement(By.linkText("8")).click();
		
		Select timeSelect = new Select(driver.findElement(By.id("time")));
		timeSelect.selectByVisibleText("10Am");
		
		driver.findElement(By.id("ChangeHeatName")).click();
		driver.findElement(By.id("sym")).sendKeys("fever");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
	}
	public String getFutureDate(int noofdays,String pattern)
	{

		Calendar cal = 	Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, noofdays);
		Date d = cal.getTime();
		System.out.println("Current Date :" + d);
		SimpleDateFormat sdf = new SimpleDateFormat();
		String defaultformat = sdf.format(d);
		System.out.println(defaultformat);
		
		sdf = new SimpleDateFormat(pattern);
		String formatDate = sdf.format(d);
		System.out.println(formatDate);
		return formatDate;
	}

}
 
