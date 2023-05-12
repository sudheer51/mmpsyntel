package org.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditProfilePage {

	protected  WebDriver driver;
	private By fnameBy = By.id("fname");
	private By lnameBy = By.id("lname");
	public EditProfilePage(WebDriver driver)
	{
		this.driver= driver;
	}
	public boolean readFNameAttribute()
	{
		return Boolean.parseBoolean(driver.findElement(fnameBy).getAttribute("readonly"));
	}
	public boolean readLNameAttribute()
	{
		return Boolean.parseBoolean(driver.findElement(lnameBy).getAttribute("readonly"));
	}

}
