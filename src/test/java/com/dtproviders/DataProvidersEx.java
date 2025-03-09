package com.dtproviders;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.AppUtils;

public class DataProvidersEx extends AppUtils {

	/*
	 * @Test(dataProvider = "logincred") public void loginTest(String user, String
	 * pass) { System.out.println(user + " " + pass); }
	 * 
	 * @DataProvider(name = "logincred") public String[][] loginData() {
	 * 
	 * String data[][] = new String[][] { { "user1", "pass1" }, { "user2", "pass2" }
	 * };
	 * 
	 * return data; }
	 */

	@Test(dataProvider = "readXLData",dataProviderClass = com.utils.ExcelUtils.class)
	public void loginDataCheck(String username, String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		new Actions(driver).scrollByAmount(0, 500).build().perform();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[text()='Login']")).click();
		boolean flag = driver.findElement(By.xpath("//div/b[contains(text(),'invalid!')]")).isDisplayed();
		Assert.assertFalse(flag, "incorrect message is displayed....");

	}

	@DataProvider()
	public String[][] loginData() {
		String data[][] = { { "abc@hotmail.com", "password" }, { "xyz@hotmail.com", "password2" } };

		return data;
	}

}
