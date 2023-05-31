package org.mmp.patientmodule.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
/**
 * 
 * @author Total-QA
 *
 */
public class ExtentReportsEx {
	WebDriver driver;
	public String testMethodName;
	@Test
	public void verifyHomePageTitle() throws IOException
	{
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
 
		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(htmlReporter);
 
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("verifyHomePageTitle", "Checking the Title");
 
		driver = new ChromeDriver();
 
		// log(Status, details)
		test.log(Status.INFO, "Chrome Browser Launched Successfully");
 
		driver.get("http://total-qa.com");
		test.log(Status.INFO,"Navigated to URL");
 
		String actual = driver.getTitle();
		test.log(Status.INFO, "Actual Title returned :: " + actual);
 
		String expected = "Java Online Quiz- Test your knowledge Java Basics";
		test.log(Status.INFO, "Expected Title returned:: "+ expected);
 
		Assert.assertEquals(actual,expected);
 
		File screenshotFile = new File(testMethodName+".png");
		System.out.println(screenshotFile.getAbsolutePath());
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		//for file copy, absolute path starts from your project directory
		FileUtils.copyFile(src, screenshotFile);
		
		// test with snapshot
		test.addScreenCaptureFromPath(screenshotFile.getAbsolutePath());
 
		// calling flush writes everything to the log file
		extent.flush();
 
	}
	  @BeforeMethod
	   public void name(Method method) {
	      System.out.println("Test name: " + method.getName());
	      testMethodName=method.getName();
	   }
 
}