package com.pom.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePageObject{
private By dropbox = By.id("dropdown");
	public DropDownPage(WebDriver driver, Logger log) {
		super(driver,log);
		}
	
		public void selectItem(String value)
		{
			log.info("Selecting option "  +  value + " from dropdown");
			WebElement dropDownItem  = find(dropbox);
			Select dropboxItem = new Select(dropDownItem);
			dropboxItem.selectByValue(value);
		}
public String getSelectedName() {
	
	WebElement dropDownItem  = find(dropbox);
	Select dropboxItem = new Select(dropDownItem);
	String selectedOption = dropboxItem.getFirstSelectedOption().getText();

	log.info("This item is selectd" + selectedOption);
	return selectedOption;
}
}
