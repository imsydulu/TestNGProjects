package com.testngdemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGDemo {
	int count=0;
	@BeforeSuite
	public void mathod() {
		System.out.println("@BeforeSuite");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass");
	}

	@Test(testName = "SecondTest", priority = 1)
	public void myTestOne() {
		System.out.println("@Test:SecondTest");
	}

	@AfterSuite
	public void afteSuit() {
		System.out.println("@AfterSuite");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod");
	}

	@Test(testName = "FirstTest",invocationCount = 3,groups = "reg,sanity")
	public void myTestZero() {
		
		count++;
		System.out.println("@Test:FirstTest"+count);
	}

	@AfterMethod
	public void afterMethod() {

		System.out.println("@AfterMethod");

	}

}
