package com.herokuapp.theinternet;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.base.CsvDataProvider;
import com.pom.base.TestUtils;
import com.pom.pages.LoginPage;
import com.pom.pages.WelcomePage;

public class NegativeLogInTests extends TestUtils {

	
	@Test(priority = 1, dataProvider = "csvReader", dataProviderClass = CsvDataProvider.class)
	public void negativeLogInTest(Map<String, String> testData) {
		// Data
		String no = testData.get("no");
		String username  = testData.get("userName");
		String password = testData.get("password");
		String expectedErrorMessage = testData.get("message");
		String description = testData.get("description");
		
		log.info("Starting negativeLogInTest #" + no + " for " + description);

		// open main page
		WelcomePage welcomePage = new WelcomePage(driver, log);
		welcomePage.openPage();

		// Click on Form Authentication link
		LoginPage loginPage = welcomePage.clickFormAuthenticationLink();

		// execute negative login
		loginPage.invalidLoging(username, password);

		// wait for error message
		loginPage.waitForErrorMessage();
		String message = loginPage.getErrorMessageText();

		// Verification
		Assert.assertTrue(message.contains(expectedErrorMessage), "Message doesn't contain expected text.");
	}
}
