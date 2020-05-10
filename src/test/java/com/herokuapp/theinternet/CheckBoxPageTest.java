package com.herokuapp.theinternet;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.pom.base.TestUtils;
import com.pom.base.BaseTest;
import com.pom.pages.CheckboxPage;
import com.pom.pages.WelcomePage;

@Test
public class CheckBoxPageTest extends TestUtils{
	//CheckBox Testing
	public void checkboxclick() {
		WelcomePage basePage = new WelcomePage(driver, log);
		basePage.openPage();
		//screenShot();
		CheckboxPage checkboxPage =  basePage.checkboxclick();
		System.out.println("CheckBox found");
		checkboxPage.selectAllCheckboxes();
		Assert.assertTrue(checkboxPage.isSelected(), "Not selected");
		sleep(2000);
	}

}
