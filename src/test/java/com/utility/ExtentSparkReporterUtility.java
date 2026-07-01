package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentSparkReporterUtility {
	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	
	public static void setupExtentSparkReporter(String reportname) {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//"+reportname);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
		
	}
	
	public static void createExtentTest(String testName) {
	ExtentTest test = extentReports.createTest(testName);
	extentTest.set(test);
		
	}
	
	public  static ExtentTest getTest() {
		return extentTest.get();
	}
	public static void flushReport() {
		extentReports.flush();
	}

}
