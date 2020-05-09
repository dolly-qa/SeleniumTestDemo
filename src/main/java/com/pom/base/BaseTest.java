package com.pom.base;

import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestMethodFinder;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
@Listeners({com.pom.base.TestListner.class , com.pom.base.ExtentReporterNG.class})
//@Listeners({com.pom.base.ExtentReporterNG.class})

public class BaseTest{
	
	protected WebDriver driver;
	protected Logger log;
	
	protected String testSuiteName;
	protected String testName;
	protected String testMethodName;


	@Parameters({ "browser" , "chromeProfile", "deviceName"})
	@BeforeMethod(alwaysRun = true)
	
	public void setUp(Method method, @Optional("chrome") String browser, @Optional String profile,@Optional String deviceName, ITestContext ctx) {
		
		String testName = ctx.getName();
		log = LogManager.getLogger(testName);

		//			String testName = ctx.getCurrentXmlTest().getName();
//			log = LogManager.getLogger(testName);
			
			BaseDriverFactory factory = new BaseDriverFactory(browser, log);
			if(profile != null) {
				driver = factory.createChromeWithProfile(profile);
			} else if(deviceName != null) {
				driver = factory.createChromeWithMobileEmulation(deviceName);
			}
			else {
				driver = factory.createDriver();
				
			}
			
			// This sleep here is for instructor only. Students don't need this here
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			driver.manage().window().maximize();
			//this.testSuiteName = ctx.getSuite().getName();
			this.testName = testName;
			this.testMethodName = method.getName();
			
		}



	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		//log.info("Close driver");
		// Close browser
		driver.quit();
	}
	 
/////////
//	@Parameters({ "browser" })
//	@BeforeMethod(alwaysRun = true)
//	public void setUp(@Optional("chrome") String browser, ITestContext ctx) {
//		String testName = ctx.getCurrentXmlTest().getName();
//		log = LogManager.getLogger(testName);
//		createDriver(driver,log,browser);
////		BaseDriverFactory factory = new BaseDriverFactory(browser, log);
////		driver = factory.createDriver();
//		
//		// This sleep here is for instructor only. Students don't need this here
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		driver.manage().window().maximize();
//	}
//	public WebDriver createDriver(WebDriver driver, Logger log, String browser)
//	{
//		log.info("Create driver: " + browser);
//		switch (browser) {
//		case "chrome":
//			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//			driver.set(new ChromeDriver());
//			break;
//
//		case "firefox":
//			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
//			driver.set(new FirefoxDriver());
//			break;
//
//		default:
//			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
//			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//			driver.set(new ChromeDriver());
//			break;
//		}
//		return driver.get();
//
//	}
//	
//}

}
