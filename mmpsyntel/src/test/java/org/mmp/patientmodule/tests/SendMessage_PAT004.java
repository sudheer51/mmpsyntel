package org.mmp.patientmodule.tests;

import org.mmp.patientmodule.pages.SendMessagesPage;
import org.mmp.util.BaseClass;
import org.mmp.util.MMPLibrary;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SendMessage_PAT004 extends BaseClass{
	
	@Parameters({ "username","password" })
	@Test(description="TC_001 Login to Patient Module with valid credentails")
	public void TC_001_PAT004_validateSendMessages(String username,String password)
	{
	 
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(username,password,pro.getProperty("patientURL"));
		SendMessagesPage messagesPage = new SendMessagesPage(driver);
		String actual = messagesPage.sendMessages("Monthly Visit", "Regular Checkup");
		String expected="Messages Successfully sent.";
		Assert.assertEquals(actual,expected);
	}

}
