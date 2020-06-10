package com.herokuapp.theinternet;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.base.TestUtils;
import com.pom.pages.CheckboxPage;
import com.pom.pages.WelcomePage;

@Test
public class CheckBoxPageTest extends TestUtils{
	//CheckBox Testing
	//Sel Demo
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
