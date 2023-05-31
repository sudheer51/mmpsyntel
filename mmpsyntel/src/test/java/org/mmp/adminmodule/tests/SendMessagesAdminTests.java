package org.mmp.adminmodule.tests;

import org.mmp.patientmodule.pages.SendMessagesPage;
import org.mmp.util.BaseClass;
import org.mmp.util.MMPLibrary;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SendMessagesAdminTests extends BaseClass{
 
	
	@Parameters({ "username","password" })
	@Test(description="TC_001 Login to Patient Module with valid credentails")
	public void TC_002_PAT004_validate_sendMessages_E2e(String username,String password)
	{
	 
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(username,password);
		SendMessagesPage messagesPage = new SendMessagesPage(driver);
		String actual = messagesPage.sendMessages("Monthly Visit", "Regular Checkup");
		String expected="Messages Successfully sent.";
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual,expected);
		
		/*
		 * login to Admin module
		 * validate the data displayed in the admin module by comparing   with the data send in the patient module
		 * 
		 * 
		 * 
		 */
		
		sa.assertAll();
		
	}

}
