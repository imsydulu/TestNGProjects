package com.sydulu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleTest extends AppUtils {

	@Parameters(value = { "username" })
	@Test(testName = "GmailLogin")
	public void gmailLoginTest(ITestContext context,String userName) throws Exception {
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		// path = //div[@class='header__aside']/a/span[text()='Sign in']

		driver.findElement(By.xpath("//div[@class='header__aside']/a/span[text()='Sign in']")).click();
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(userName);
		driver.findElement(By.xpath("//div[@class='O1Slxf']/div[1]/div/div/button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(39));

		if (driver.findElement(By.xpath("//a[@aria-label='Try again']")).isDisplayed()) {
			System.out.println("Try agian is displayed-------------");
			getScreeshot(context.getName(), timestamp("ddMMyyyyhhmmss"));
		}

	}

	public String timestamp(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat fomratter = new SimpleDateFormat(dateFormat);
		String reqDateFormat = fomratter.format(date);
		System.out.println(reqDateFormat);
		return reqDateFormat;
	}

	public void getScreeshot(String testname, String timestamp) throws IOException {
		String filename = testname.concat(timestamp);
		System.out.println("Filename " + filename);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source_file = screenshot.getScreenshotAs(OutputType.FILE);
		boolean isCreatedDir = new File("./Screenshots").mkdirs();
		File dest_file = new File("./Screenshots/" + filename + ".jpeg");
		if (isCreatedDir || new File("./Screenshots").exists()) {
			System.out.println("Saved File Name: " + dest_file.getName());
			FileHandler.copy(source_file, dest_file);
		} else {
			System.out.println("File is not created");
		}
	}

	@Test(enabled = false, priority = 1, testName = "facebooktest")
	public void facebooktest() {

		System.out.println("Nothing to execute");
		// driver.findElement()
	}

}
