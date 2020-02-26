package com.darkly.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.darkly.lib.ui.LoginPage;
import com.darkly.lib.util.CreateDriver;

public class TestSample{
	
	LoginPage login;
	WebDriver driver;
	
	@BeforeMethod
	public void preCondition() {
		driver=CreateDriver.getBrowserInstance();
		login=new LoginPage(driver);
	}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
	@Test
	public void testSample() {
		System.out.println("this is test sample");
		login.waitForLoginPageToLoad();
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		//String expTitle = "actiTIME - Login";
		//Assert.assertEquals(actTitle, expTitle);
	}
	
	
}