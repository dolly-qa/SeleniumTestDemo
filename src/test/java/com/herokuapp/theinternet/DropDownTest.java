package com.herokuapp.theinternet;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pom.base.TestUtils;
import com.pom.base.BaseTest;
import com.pom.pages.DropDownPage;
import com.pom.pages.JSErrorPage;
import com.pom.pages.WelcomePage;

public class DropDownTest extends TestUtils {

	@Test
	public void dropdownclick() {

		WelcomePage mainPage = new WelcomePage(driver, log);
		mainPage.openPage();

		DropDownPage dropDownPage = mainPage.dropdownclick();
		dropDownPage.selectItem("2");
		dropDownPage.getSelectedName();
		// To Get SEVERE log info Example....
//		List<LogEntry> logs = getBrowserLogs();
//		SoftAssert softAssert = new SoftAssert();
//		for (LogEntry logEntry : logs) {
//			if (logEntry.getLevel().toString().equals("SEVERE")) {
//				softAssert.fail("Severe error: " + logEntry.getMessage());
//			}
//		}
//		softAssert.assertAll();
	}
}
