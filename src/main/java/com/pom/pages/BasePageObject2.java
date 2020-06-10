package com.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BasePageObject2 {

//	protected WebDriver driver;
//	protected Logger log;
	
protected WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional ("Chrome") String brows) {
		// Create driver
		switch (brows) {
		case "Chrome": {
			
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			driver = new ChromeDriver();
			System.out.println("Starting Chrom");
			break;
		}
		case "Firefox": {
			
			System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
			driver = new FirefoxDriver();
			System.out.println("Starting Firefox");
			break;
		}
		default:
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			driver = new ChromeDriver();
			System.out.println("Default.....");
			break;
		}
	}		

	@AfterMethod(alwaysRun = true)
	public void closeDriver() {
		// close driver
		System.out.println("closing...");
		driver.quit();
	}
	
	protected void openUrl(String url) {
		driver.get(url);
	}
	
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	protected void click(By locator) {
		//driver.findElement(locator).click();
		find(locator).click();
	}
	protected void type(String text,By locator) {
	find(locator).sendKeys(text);
	}
	protected String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	
	
	
}

