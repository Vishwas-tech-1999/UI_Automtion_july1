package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.contants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;


@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase {
//	HomePage homepage;
//	Logger logger = LoggerUtility.getLoger(this.getClass());
//	
//	@BeforeMethod
//	public void setUp() {
//		 homepage = new HomePage(Browser.CHROME, true);
//	}

	@Test(description = "Verify login with valid credentials", groups= {"e2e", "Sanity", "Regression"}, dataProviderClass = 
			com.ui.dataprovider.LoginDataProvider.class, dataProvider =   "LoginTestDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public  void loginTest(User user) {
		
		
	//	 homepage = new HomePage(Browser.CHROME);
		String username =homepage.gotoLoginPage().doLoginWithValidCredentials(user.getEmailAddress(), user.getPassword()).getUserName();
		Assert.assertEquals(username, "Vijay Kumar1");
	}
	
	@Test(description = "Verify login with valid credentials", groups= {"e2e", "Sanity", "Regression"}, dataProviderClass = 
			com.ui.dataprovider.LoginDataProvider.class, dataProvider =   "CsvLoginTestDataProvider")
	public  void loginCsvTest(User user) {
		
		logger.info("Started CSV test");
		// homepage = new HomePage(Browser.CHROME);
		String username =homepage.gotoLoginPage().doLoginWithValidCredentials(user.getEmailAddress(), user.getPassword()).getUserName();
		System.out.println(username);
		logger.info("Completed CSV test");
	}

}
