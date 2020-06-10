package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.main.BaseClass;


public class LoginTests extends BaseClass{

	//private WebDriver driver;
//
//	@Parameters("browser")
//
//	@BeforeMethod(alwaysRun = true)
//	private void setUp(@Optional("Chrome") String brows) { // Create driver
//
//		switch (brows) {
//		case "Chrome": {
//
//			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//			driver = new ChromeDriver();
//			System.out.println("Starting Chrom");
//			break;
//		}
//		case "Firefox": {
//
//			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
//			driver = new FirefoxDriver();
//			System.out.println("Starting Firefox");
//			break;
//		}
//		default:
//			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//			driver = new ChromeDriver();
//			System.out.println("Default.....");
//			break;
//		}
//
//	}

	@Test(priority = 1, groups = { "positiveTests", "smokeTests" })
	public void positiveLoginTest() {

		System.out.println("Page starting...");

		// Create driver
		// System.setProperty("webdriver.chrome.driver",
		// "src/main/resources/chromedriver");
		// WebDriver driver = new ChromeDriver();

		// System.setProperty("webdriver.gecko.driver",
		// "src/main/resources/geckodriver");
		// WebDriver driver = new FirefoxDriver();
		// sleep(3000);

		// WebDriverWait wait = new WebDriverWait(driver, 10);

//		open test page
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is opened.");
		
		//Set Cookies...
		
		Cookie ck = new Cookie("username", "tomsmith", "the-internet.herokuapp.com", "/", null);
		driver.manage().addCookie(ck);
		System.out.println("Cookie added..." + ck.getName());

//		enter username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");

//		enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");

//		click login button
		driver.findElement(By.xpath("//button[@class='radius']")).click();

//		verificatins:
//		 1.new url
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://the-internet.herokuapp.com/secure";

		Assert.assertEquals(actualUrl, expectedUrl, "Acctual url does not match Expected url");
		System.out.println("Url matches");

//		 2.logout button is visible
		WebElement loginButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(loginButton.isDisplayed(), "Log out button is not visisble");
		System.out.println("LogOut button is visible");

		// succesful login message
		String expectedMsg = "You logged into a secure area!";
		String actualMsg = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		System.out.println(actualMsg);
		// Assert.assertEquals(actualMsg, expectedMsg, "Success message does not
		// match");
		Assert.assertTrue(actualMsg.contains(expectedMsg), "Success message does not match");

		System.out.println("Success message matches....");

//		 succesful login message
		// driver.findElement(By.xpath("//div[@id='flash']"));
		// driver.findElement(By.className("['flash.success']"));
		sleep(3000);

	}

	@Parameters({ "userName", "password", "expectedMsg" })
	@Test(priority = 2, groups = { "negativeTests", "smokeTests" })
	public void negativLoginTests(@Optional("tomsmith") String username, @Optional("sss") String password,
			@Optional("Your password is invalid!") String expectedMsg) {

		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "src/main/resources/chromedriver"); WebDriver driver = new ChromeDriver();
		 */

		// System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver");
		// WebDriver driver = new FirefoxDriver();
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);

		System.out.println("Page is opened.");

		/*
		 * NegativeTests n1 = new NegativeTests(); n1.openPage();
		 */
		// enter username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		// enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		// click login button
		driver.findElement(By.xpath("//button[@class='radius']")).click();

		// String expectedMsg = "Your username is invalid!";
		String actualMsg = driver.findElement(By.xpath("//div[@id='flash']")).getText();
		System.out.println(actualMsg);
		Assert.assertTrue(actualMsg.contains(expectedMsg), "Message does not match");
		// n1.closePage();
		// driver.quit();

	}
//
//	  @AfterMethod(alwaysRun = true)
//	  private void closeDriver() { 
//		  // close driver
//	  System.out.println("closing..."); driver.quit();
//	  }
//	 

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
