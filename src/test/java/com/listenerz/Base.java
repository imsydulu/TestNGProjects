package com.listenerz;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

	public WebDriver driver;

	@BeforeClass
	void driverSetup() {
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}
	
	
	public void onTestFailure() {
		
		System.out.println("Failure Logic");
	}
	public void onTestSucces() {
		System.out.println("Success Logic");
	}
	public void onTestStart() {
		System.out.println("The test execution has started.............");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}


}
