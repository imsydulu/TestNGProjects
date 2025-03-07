package com.sydulu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class AppUtils {

	 WebDriver driver;

	@Parameters(value = { "browser", "url" })
	@BeforeClass
	public void driverUtils(String browser, String url) {

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("invalis browsername");
			break;
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);

	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("closing the browser");
		//driver.quit();
	}

}
