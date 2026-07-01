package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.contants.Browser;

public abstract class BrowserUtility {

	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	

	public WebDriver getDriver() {
		return driver.get();
	}

	public void setDriver(WebDriver driver) {
		//this.driver = driver;
		this.driver.set(driver);
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}
	
	
	public BrowserUtility(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver.set(new  ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			//	driver = new  EdgeDriver();
				driver.set(new  EdgeDriver());
			}
		
	}
	
	public BrowserUtility(Enum browserName, boolean isheadless) {
		if(browserName == Browser.CHROME) {
			if(isheadless) {
			//driver = new  ChromeDriver();
			
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--headless=new");
			chromeOptions.addArguments("--window-size=1920,1080");
			driver.set(new  ChromeDriver());
			}
			else {
				driver.set(new  ChromeDriver());
			}

		}
		else if(browserName == Browser.EDGE) {
				//driver = new  EdgeDriver();
				
				if(isheadless) {
					EdgeOptions edgeOptions = new EdgeOptions();
					edgeOptions.addArguments("--headless=old");
					edgeOptions.addArguments("--disable-gpu");
					driver.set(new  EdgeDriver());
				}
				else {
					driver.set(new  EdgeDriver());
				}
			}
		
	}
	
	public BrowserUtility(Enum browserName) {
		if(browserName == Browser.CHROME) {
			//driver = new  ChromeDriver();
			driver.set(new  ChromeDriver());

		}
		else if(browserName == Browser.EDGE) {
				//driver = new  EdgeDriver();
				driver.set(new  EdgeDriver());
			}
		
	}
	public void goToWebsite(String Url) {
		driver.get().get(Url);
	}
	
	public void maximizeWindow() {
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		WebElement element = driver.get().findElement((locator));
		element.click();
	}
	public void enterText(By locator, String enterText) {
	 WebElement element = driver.get().findElement((locator));
	 element.sendKeys(enterText);
	}
	
	public String getVisibleText(By locator) {
		 WebElement element = driver.get().findElement((locator));
		return element.getText();
	}
	
	public static String  getScrenShot(String name) {
		
		TakesScreenshot screenshot = (TakesScreenshot)driver.get();
		File screenData = screenshot.getScreenshotAs(OutputType.FILE);
		
		String path = System.getProperty("user.dir")+ "//screenShot//"+name;
		File screenShotFile = new File(path);
		
		try {
			FileUtils.copyFile(screenData, screenShotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	
}
