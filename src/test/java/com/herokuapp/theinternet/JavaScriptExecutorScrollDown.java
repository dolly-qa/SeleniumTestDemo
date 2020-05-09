package com.herokuapp.theinternet;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptExecutorScrollDown {

	WebDriver driver;

	@Test
	public void scrollDown() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

		driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		sleep(2000);

		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		sleep(2000);
		driver.quit();

	}

	protected void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}