package com.herokuapp.theinternet;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.base.TestUtils;
import com.pom.pages.LoginPage;
import com.pom.pages.SecureAreaPage;
import com.pom.pages.WelcomePage;

public class PositiveDatasFromDataProvider extends TestUtils{
@Test(priority=1,dataProvider = "data", dataProviderClass = DataProviderClass.class)
	
	public void PositiveLoginTest(String username, String password) {
		  
//		  String no=testData.get("no");
//		  String userName=testData.get("userName");
//		  String password=testData.get("password");
//		  String message=testData.get("message");
//		  String description=testData.get("description");
//		  
		 //log.info("Starting positiveLogInTest #" + no + " for " + description);

		  WelcomePage welcomePage = new WelcomePage(driver, log);
		  welcomePage.openPage();
		  LoginPage loginPage = welcomePage.clickFormAuthenticationLink();
		  SecureAreaPage securePage = loginPage.logIn(username, password);
		  String actualUrl = securePage.getPageUrl();
			String expectedUrl = "http://the-internet.herokuapp.com/secure";
			Assert.assertEquals(actualUrl, expectedUrl,"Acctual url does not match Expected url");
			System.out.println("Url matches");
	}
			
}
