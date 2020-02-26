package com.darkly.lib.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CreateDriver {

	public static WebDriver getBrowserInstance() {

		WebDriver driver ;
		String browser = DataHandlers.getDataFromProperties("configuration", "browser");
		String url = DataHandlers.getDataFromProperties("configuration", "url");

		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./browser-servers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./browser-servers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./browser-servers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else {
			System.err.println("invalid browser option please check configuration property files");
			return null;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

		if(url.equalsIgnoreCase("prod")) {
			//driver.get("http://www.gcrit.com/build3/admin/");
			driver.get("https://demo.actitime.com/login.do");
		}else {
			driver.get("https://www.google.com");
		}
		return driver;
	}
}
