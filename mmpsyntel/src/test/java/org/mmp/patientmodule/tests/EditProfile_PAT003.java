package org.mmp.patientmodule.tests;

import org.mmp.patientmodule.pages.EditProfilePage;
import org.mmp.util.BaseClass;
import org.mmp.util.MMPLibrary;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditProfile_PAT003 extends BaseClass{

	@Parameters({ "username","password" })
	@Test(description="TC_006 Validate clicking on the Profile tab displays all uneditable fields")
	public void TC_006_validate_uneditable_fields(String username,String password)
	{
		 
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(username,password,pro.getProperty("patientURL")); 
		mmpLib.navigateToAModule("Profile");
		SoftAssert sa = new SoftAssert();
		EditProfilePage editProfile = new EditProfilePage(driver);
		sa.assertTrue(editProfile.readFNameAttribute());
		sa.assertTrue(editProfile.readLNameAttribute());
		sa.assertAll();
		
		driver.navigate();
		
		
	}

}
