package org.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditProfilePage {

	protected  WebDriver driver;
	
    @FindBy(how = How.ID, using = "fname") 
	private WebElement fnameBy;
	
    @FindBy(how=How.ID,using="lname")
    private WebElement lnameBy;
	public EditProfilePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	public boolean readFNameAttribute()
	{
		return Boolean.parseBoolean( fnameBy.getAttribute("readonly"));
	}
	public boolean readLNameAttribute()
	{
		return Boolean.parseBoolean(lnameBy.getAttribute("readonly"));
	}

}
