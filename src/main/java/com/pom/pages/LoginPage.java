package com.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import net.bytebuddy.implementation.bind.annotation.Super;

import org.apache.logging.log4j.Logger;
public class LoginPage extends BasePageObject{

//	private WebDriver driver;
//	private Logger log;
	//private String pageurl = "";
	
	private By usernameLocator = By.id("username");
	private By passwordLocator = By.name("password");
	private By logInButtonLocator = By.tagName("button");
	private By invalidMsg = By.id("flash-messages");
	
	public LoginPage(WebDriver driver, Logger log) {
		super(driver,log);
		//this.driver = driver;
		//this.log = log;
	}
	 public SecureAreaPage logIn(String username, String password) {
		 //log.info("Logging in with" + username +"Passwor " + password);
//		 driver.findElement(usernameLocator).sendKeys(username);
//		 driver.findElement(passwordLocator).sendKeys(password);
//		 driver.findElement(logInButtonLocator).click();
		 type(username,usernameLocator);
		 type(password,passwordLocator);
		 click(logInButtonLocator);
		 return new SecureAreaPage(driver,log);
		 
	 }
	 
//	 public String invalidLoging(String username, String password) {
//		 
//		 type(username,usernameLocator);
//		 type(password,passwordLocator);
//		 click(logInButtonLocator);
//		 String errorMsg = find(invalidMsg).getText();
//		 return errorMsg;
//	 }

	 public String invalidLoging(String username, String password) {
		 
		 type(username,usernameLocator);
		 type(password,passwordLocator);
		 click(logInButtonLocator);
		 String errorMsg = find(invalidMsg).getText();
		 return errorMsg;
	 }
	 /** Wait for error message to be visible on the page */
		public void waitForErrorMessage() {
			waitForVisibilityOf(invalidMsg, 5);
		}

		public String getErrorMessageText() {
			return find(invalidMsg).getText();
		}

	 
	 //http://the-internet.herokuapp.com/login

}
