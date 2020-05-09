package com.herokuapp.theinternet;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.base.TestUtils;
import com.pom.pages.AlertPage;
import com.pom.pages.WelcomePage;

public class AlertTests extends TestUtils{
@Test
	public void alertInfoTest() {
	
		WelcomePage mainPage = new WelcomePage(driver, log);
		mainPage.openPage();
		AlertPage alertPage = mainPage.clickAlert();
		alertPage.alertButtonClick();
		String alertText = alertPage.getAlertText();
		alertPage.alertAccept();
		String resultText = alertPage.alertResultDisplay();
		sleep(3000);
		Assert.assertTrue(alertText.contains("I am a JS Alert"), "Alert does not match...");
		Assert.assertTrue(resultText.contains("You successfuly clicked an alert"), "Alert result does not match...");
		
		
	}
@Test
public void alertAcceptTest() {
	WelcomePage mainPage = new WelcomePage(driver, log);
	mainPage.openPage();
	AlertPage alertPage = mainPage.clickAlert();
	alertPage.alertConfirmButtonClick();
	String alertText = alertPage.getAlertText();
	alertPage.alertDismiss();
	String resultText = alertPage.alertResultDisplay();
	sleep(3000);
	Assert.assertEquals(alertText, "I am a JS Confirm", "Alert does not match...");
	
}
@Test
public void alertPromptText() {
	WelcomePage mainPage = new WelcomePage(driver, log);
	mainPage.openPage();
	AlertPage alertPage = mainPage.clickAlert();
	alertPage.alertPromptEntryClick();
	String alertText = alertPage.getAlertText();
	
	alertPage.alertPromtText("Hello..");
	String resultText = alertPage.alertResultDisplay();
	sleep(3000);
	Assert.assertEquals(alertText, "I am a JS prompt", "Alert does not match...");
	Assert.assertEquals(resultText,"You entered: Hello..","Alert msg does not match...");
}

}
