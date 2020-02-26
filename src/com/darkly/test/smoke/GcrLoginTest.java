package com.darkly.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.darkly.lib.ui.GcrLoginPage;
import com.darkly.lib.util.CreateDriver;

public class GcrLoginTest {
	WebDriver driver;
	GcrLoginPage gcrlogin;
	
	@BeforeMethod
	public void preCondition() {
		driver=CreateDriver.getBrowserInstance();
		gcrlogin=new GcrLoginPage(driver);
	}
	@AfterMethod
	public void postCondition() {
		//driver.close();
		driver.quit();
	}
	@Test
	public void testSample() {
		//System.out.println("this is test sample 1");
		gcrlogin.waitForLoginPageToLoad();
		String actTitle = driver.getTitle();
		String expTitle = "GCR Shop";
		Assert.assertEquals(actTitle, expTitle);
	}

}

