package com.listenerz;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(MyListenerClass.class)
public class ListnerzTest extends Base {

	@Test(testName = "fbpasstest",priority = 0)
	public void fbTestPass() {
		boolean flag = driver.findElement(By.name("login")).isDisplayed();
		Assert.assertTrue(flag);
	}
	
	@Test(testName = "fbfailtest",priority = 1)
	public void fbTestFail() {
		boolean flag = driver.findElement(By.name("login")).isDisplayed();
		Assert.assertFalse(flag);
	}
}
