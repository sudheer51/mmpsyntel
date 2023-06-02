package org.mmp.adminmodule.tests;

import java.util.HashMap;

import org.mmp.adminmodule.pages.SendMessagesAdminPage;
import org.mmp.patientmodule.pages.SendMessagesPage;
import org.mmp.util.BaseClass;
import org.mmp.util.MMPLibrary;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SendMessagesAdminTests_PAT004 extends BaseClass{
 
	
	@Parameters({ "username","password" })
	@Test(description="TC_001 Login to Patient Module with valid credentails")
	public void TC_002_PAT004_validate_sendMessages_E2e(String username,String password)
	{
	 
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(username,password,pro.getProperty("patientURL"));
		SendMessagesPage messagesPage = new SendMessagesPage(driver);
		String actual = messagesPage.sendMessages("Monthly Visit", "Regular Checkup");
		String expected="Messages Successfully sent.";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual,expected);
		HashMap<String,String> expectedHMap = messagesPage.fetchSendMessagesDetails();
		
		/*
		 * login to Admin module
		 * validate the data displayed in the admin module by comparing   with the data send in the patient module
	     */
		mmpLib.login(pro.getProperty("adminUsername"),pro.getProperty("adminPassword"),pro.getProperty("adminURL"));
		SendMessagesAdminPage messagesAdminPage = new SendMessagesAdminPage(driver);
		HashMap<String,String> actualHMap = messagesAdminPage.fetchMessageDetails();
		sa.assertEquals(actualHMap, expectedHMap);
		sa.assertAll();
		
	}

}
