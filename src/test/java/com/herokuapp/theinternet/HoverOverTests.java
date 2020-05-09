package com.herokuapp.theinternet;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HoverOverTests {
//http://the-internet.herokuapp.com/hovers
	////div[@class='figure']
	////h5[text()='name: user1']
	////div[@class='figure']//h5[text()='name: user1']
	protected By hoverElementLocator = By.xpath("//div[@class='figure'][1]");
	//protected By hoveredLocator = By.xpath("//h5[text()='name: user1']");
	protected By hoveredLocator = By.xpath("//h5[text()='name: user1']//following::a[text()='View profile']");
	protected WebDriver driver;
	protected Logger log;
	@Test
	public void handOver() {
System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/hovers");
		Actions action = new Actions(driver);
		WebElement hoverElement = driver.findElement(hoverElementLocator);
		action.moveToElement(hoverElement).build().perform();
		sleep(2000);
		driver.findElement(hoveredLocator).click();
		sleep(2000);
		//driver.quit();
		
	}
	protected void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		//log.info("Close driver");
		// Close browser
		driver.quit();
	}
}
