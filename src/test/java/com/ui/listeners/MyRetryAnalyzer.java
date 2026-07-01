package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.contants.Env;
import com.utility.PropertiesUtil;

public class MyRetryAnalyzer implements IRetryAnalyzer {
private static final int MAX_NO_OF_ATTEMPTS=Integer.parseInt(PropertiesUtil.readProperty(Env.QA, "MAX_NO_OF_ATTEMPTS"));
private int currentAttempt =1;
	@Override
	public boolean retry(ITestResult result) {
if(currentAttempt<=MAX_NO_OF_ATTEMPTS) {
	currentAttempt++;
	return true;
}
		return false;
	}

}
