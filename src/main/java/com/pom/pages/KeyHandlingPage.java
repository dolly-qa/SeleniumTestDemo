package com.pom.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyHandlingPage extends BasePageObject{

	String url = "http://the-internet.herokuapp.com/key_presses";
	protected WebDriver driver;
	protected Logger log;
	//private By textboxLocator = By.xpath("//input[@id='target']");
	private By textboxResultLocator = By.id("result");
	private By body = By.xpath("//body");
	public KeyHandlingPage(WebDriver driver, Logger log) {
		super(driver,log);
	}

	public void openPage() {
		openUrl(url);

	}
	public void typeText(Keys key) {
	find(body).sendKeys(key);
	
	}
	public String textResult() {
		String text = find(textboxResultLocator).getText();
		return text;
}
}