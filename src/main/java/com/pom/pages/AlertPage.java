package com.pom.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePageObject {

	private By alertInfoButtonLocator = By.xpath("//button[text()='Click for JS Alert']");
	private By alertResultTextLocator = By.id("result");
	private By alertConfirmButtonLocator = By.xpath("//button[text()='Click for JS Confirm']");
	private By clickForJSPromptButtonLocator = By.xpath("//button[text()='Click for JS Prompt']");
	
	public AlertPage(WebDriver driver, Logger log) {
		super(driver, log);

	}

	public void alertButtonClick() {
		click(alertInfoButtonLocator);

	}
	public void alertConfirmButtonClick() {
		click(alertConfirmButtonLocator);

	}
	public void alertPromptEntryClick(){
		click(clickForJSPromptButtonLocator);
		
	}

	public String getAlertText() {
		
		Alert alert = popUpAlert();
		String alertMsg = alert.getText();
		log.info("Alert pops Up : " + alertMsg);
		return alertMsg;
	}

	public void alertAccept() {
		Alert alert = popUpAlert();
		alert.accept();
		log.info("Alert accepted ");
	}
	public void alertDismiss() {
		Alert alert = popUpAlert();
		alert.dismiss();
		log.info("Alert accepted ");
	}
	

	public String alertResultDisplay() {
		String alertResult = find(alertResultTextLocator).getText();
		log.info("Alert Result: " + alertResult);
		return alertResult;

	}
	
	public void alertPromtText(String text) {
	Alert alert = popUpAlert();
	alert.sendKeys(text);
	alert.accept();
	
		
	}
	
}
