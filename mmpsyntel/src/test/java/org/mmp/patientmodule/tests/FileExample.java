package org.mmp.patientmodule.tests;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileExample {
	
	public String testMethodName;
	
	  @BeforeMethod
	   public void name(Method method) {
	      System.out.println("Test name: " + method.getName());
	      testMethodName=method.getName();
	   }
	  
	@Test
	public void validateTitle() {
		
		File screenshotFile = new File(testMethodName+".PNG");
		System.out.println(screenshotFile.getAbsolutePath());
	}
	@Test
	public void validateString() {
		
		File screenshotFile = new File(testMethodName+".PNG");
		System.out.println(screenshotFile.getAbsolutePath());
	}

}
