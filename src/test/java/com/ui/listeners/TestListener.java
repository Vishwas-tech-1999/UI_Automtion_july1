package com.ui.listeners;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentSparkReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {

	Logger logger = LoggerUtility.getLoger(this.getClass());

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test Started : " + result.getMethod().getGroups());
		ExtentSparkReporterUtility.createExtentTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test Passed : " + result.getName());
		ExtentSparkReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error("Test Failed : " + result.getName());
		logger.error("Failure Reason : ", result.getThrowable());
		ExtentSparkReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + "FAILED");
		ExtentSparkReporterUtility.getTest().log(Status.FAIL, result.getThrowable() + "FAILED");

		Object testclass = result.getInstance();

		BrowserUtility browserUtility = ((TestBase) testclass).getInstance();
		String screenShotPath = BrowserUtility.getScrenShot(result.getName());
		ExtentSparkReporterUtility.getTest().addScreenCaptureFromPath(screenShotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn("Test Skipped : " + result.getName());
		ExtentSparkReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + "SKIPPED");
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Execution Started : " + context.getName());
		ExtentSparkReporterUtility.setupExtentSparkReporter("report.html");
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Execution Finished : " + context.getName());
		ExtentSparkReporterUtility.flushReport();
	}
}