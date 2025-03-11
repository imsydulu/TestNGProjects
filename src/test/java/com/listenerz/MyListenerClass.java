package com.listenerz;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListenerClass extends Base implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("onTestStart: " + result.getTestName());
		onTestStart();
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("onTestSuccess: " + result.getTestName());
		onTestSucces();
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("onTestFailure: " + result.getTestName());
		onTestFailure();
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStart: " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		
		System.out.println("OnFinish: " + context.getName());
		
	}

}
