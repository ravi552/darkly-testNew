package com.darkly.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage{
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
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
			return driver.findElement(By.id("username"));
		}catch(Exception e) {
			return null;
		}
	}
	public WebElement getPasswordTextBox() {
		try {
			return driver.findElement(By.name("pwd"));
		}catch(Exception e) {
			return null;
		}
	}
	public WebElement getLoginButton() {
		try {
			return driver.findElement(By.xpath("//a[@id='loginButton"));
		}catch(Exception e) {
			return null;
		}
	}
	public WebElement getErrorMessage() {
		try {
			return driver.findElement(By.xpath("//span[text()='Username or Password is invalid. Please try again.']"));
		}catch(Exception e) {
			return null;
		}
	}
}