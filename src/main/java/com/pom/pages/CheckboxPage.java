package com.pom.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxPage extends BasePageObject {
	private By checkbox = By.xpath("//input[@type='checkbox']");

	// private String pageUrl = "http://the-internet.herokuapp.com/checkboxes";
	public CheckboxPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void selectAllCheckboxes() {
		List<WebElement> checkboxes = findAll(checkbox);

		
		for (WebElement checkbox : checkboxes) {
			
			if (!checkbox.isSelected())
				checkbox.click();
		}
		
	}

	public boolean isSelected() {
		List<WebElement> checkboxes = findAll(checkbox);
		for (WebElement checkbox : checkboxes) {
			if (!checkbox.isSelected()) {
				return false;
			}
		}
		return true;
	}
}