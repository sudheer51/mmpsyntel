package org.mmp.patientmodule.tests;

import org.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.mmp.util.BaseClass;
import org.mmp.util.MMPLibrary;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ScheduleAppointment_PAT004 extends BaseClass{
	@Parameters({ "username","password" })
	@Test
	public void validateBookAppointment(String username,String password)
	{
		MMPLibrary mmpLib = new MMPLibrary(driver);
		mmpLib.login(username,password,pro.getProperty("patientURL")); 
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		sPage.bookAppointment("Beth",60,"10Am");
	}
	 

}
 
