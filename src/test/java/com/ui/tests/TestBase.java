package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.contants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class TestBase {

	
	protected HomePage homepage; // it can be accessed in the child class
	Logger logger = LoggerUtility.getLoger(this.getClass());
	
	@BeforeMethod
	public void setUp() {
		 homepage = new HomePage(Browser.CHROME, true);
	}
	
	public BrowserUtility getInstance() {
		return homepage;
	}
}
