package com.herokuapp.theinternet;

import org.testng.annotations.Test;

import com.pom.base.TestUtils;
import com.pom.pages.DropDownPage;
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
