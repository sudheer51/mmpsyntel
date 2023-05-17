package org.mmp.patientmodule.pages;

import java.time.Duration;

import org.mmp.util.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScheduleAppointmentPage {
	
	protected WebDriver driver;
	private By datePickerID = By.id("datepicker");
	private By arrowCSSSelector= By.cssSelector(".ui-icon.ui-icon-circle-triangle-e");
	private By datePickerYearXpath=By.xpath("//span[@class='ui-datepicker-year']");
	private By datePickerMonthXpath=By.xpath("//span[@class='ui-datepicker-month']");	
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
	}
    
	public void bookAppointment(String doctorName,int noofDays,String time)
	{
		driver.findElement(By.xpath("//span[contains(text(),'Schedule Appointment')]")).click();
		driver.findElement(By.xpath("//input[@value='Create new appointment']")).click();
		driver.findElement(By.xpath("//h4[text()='Dr."+doctorName+"']/ancestor::ul/following-sibling::button")).click();
		
		//Switch to a iframe
		driver.switchTo().frame("myframe");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("datepicker")));
		
		driver.findElement(datePickerID).click();
		String result = CommonFunctions.getFutureDate(noofDays,"MMMMM/dd/yyyy");
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
			driver.findElement(arrowCSSSelector).click();
			actualYear=driver.findElement(datePickerYearXpath ).getText();
			
		}
		while(!(actualMonth.equals(expectedMonth)))
		{
			System.out.println("in while loop of month");
			driver.findElement(arrowCSSSelector).click();
			actualMonth=driver.findElement(datePickerMonthXpath).getText();
			
		}
		driver.findElement(By.linkText(expectedDate)).click();
		
		//driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
		//driver.findElement(By.linkText("8")).click();
		
		Select timeSelect = new Select(driver.findElement(By.id("time")));
		timeSelect.selectByVisibleText(time);
		
		driver.findElement(By.id("ChangeHeatName")).click();
		driver.findElement(By.id("sym")).sendKeys("fever");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
	}
}
