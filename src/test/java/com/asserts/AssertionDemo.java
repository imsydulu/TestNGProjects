package com.asserts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utils.AppUtils;

public class AssertionDemo extends AppUtils {
	Actions action;
	// LoginTest with valid credentials

	@Parameters(value = { "username", "password" })
	@Test
	public void loginTest(String username, String password) {
		action = new Actions(driver);
		// action.scrollToElement(driver.findElement(By.xpath("//button[text()='Login']"))).perform();
		action.scrollByAmount(0, 500).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		String act = driver.findElement(By.xpath("//div[@id='flash']/b")).getText();
		String exp = "You logged into a secure area!";

		/*
		 * boolean flag =
		 * driver.findElement(By.xpath("//i[text()=' Logout']")).isDisplayed();
		 * Assert.assertTrue(flag);
		 */
		action.scrollByAmount(0, 500).perform();
		driver.findElement(By.xpath("//i[text()=' Logout']")).click();
		driver.navigate().refresh();
		Assert.assertEquals(act, exp, "Test is passed");
		System.out.println("hard assertion");//if test failed execution halt 
	}

	// Soft assertion
	@Parameters(value = { "username", "password" })
	@Test(testName = "SoftAssertionTest",dependsOnMethods = "loginTest")
	public void loginTestwithInvalid(String username, String password) {
		action = new Actions(driver);
		// action.scrollToElement(driver.findElement(By.xpath("//button[text()='Login']"))).perform();
		action.scrollByAmount(0, 500).perform();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		String act = driver.findElement(By.xpath("//div[@id='flash']/b")).getText();
		String exp = "You logged into a secure area!";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(act, exp);
		System.out.println("soft assertion1");
		softAssert.assertAll();
		System.out.println("soft assertion2");
	}

}
