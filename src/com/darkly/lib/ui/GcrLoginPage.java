package com.darkly.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GcrLoginPage {
	WebDriver driver;
	public GcrLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void waitForLoginPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(getUserNameTextBox()));
		wait.until(ExpectedConditions.visibilityOf(getPasswordTextBox()));
		wait.until(ExpectedConditions.visibilityOf(getLoginButton()));
	}
	public WebElement getUserNameTextBox() {
		try {
			return driver.findElement(By.name("username"));
		}catch(Exception e) {
			return null;
		}
	}
	public WebElement getPasswordTextBox() {
		try {
			return driver.findElement(By.name("password"));
		}catch(Exception e) {
			return null;
		}
	}
	public WebElement getLoginButton() {
		try {
			return driver.findElement(By.xpath("//span[text()='Login']"));
		}catch(Exception e) {
			return null;
		}
	}
	public WebElement getErrorMessage() {
		try {
			return driver.findElement(By.xpath("//td[@class='messageStackError']"));
		}catch(Exception e) {
			return null;
		}
	} 
}
