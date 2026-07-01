package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.contants.Env.*;

import com.contants.Browser;
import com.utility.BrowserUtility;
import com.utility.PropertiesUtil;

public final class HomePage extends BrowserUtility {
	
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	
	public HomePage(String driver) {
		super(driver);
		goToWebsite(PropertiesUtil.readProperty(QA, "URL"));
	}
	
	
	public HomePage(Browser driver, boolean isHeadless) {
		super(driver, true);
		goToWebsite(PropertiesUtil.readProperty(QA, "URL"));
	}
	
	public LoginPage gotoLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
	}

}
