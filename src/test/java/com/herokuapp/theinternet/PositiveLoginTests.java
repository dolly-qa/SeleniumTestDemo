package com.herokuapp.theinternet;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.base.CsvPositiveReader;
import com.pom.base.TestUtils;
import com.pom.pages.LoginPage;
import com.pom.pages.SecureAreaPage;
import com.pom.pages.WelcomePage;

public class PositiveLoginTests extends TestUtils{
	
	
	  @Test(priority=1,dataProvider = "csvPositiveReader", dataProviderClass =
	  CsvPositiveReader.class)
	  
	  public void PositiveLoginTest(Map<String, String> testData ) {
	  
	  String no=testData.get("no"); String userName=testData.get("userName");
	  String password=testData.get("password"); String
	  message=testData.get("message"); String
	  description=testData.get("description");
	  
	  log.info("Starting positiveLogInTest #" + no + " for " + description);
	  
	  WelcomePage welcomePage = new WelcomePage(driver, log);
	  welcomePage.openPage(); 
	  LoginPage loginPage = welcomePage.clickFormAuthenticationLink(); 
	  SecureAreaPage securePage = loginPage.logIn(userName, password);
	  String actualUrl = securePage.getPageUrl(); 
	  String expectedUrl = "http://the-internet.herokuapp.com/secure"; 
	  Assert.assertEquals(actualUrl,expectedUrl,"Acctual url does not match Expected url");
	  System.out.println("Url matches");
	  }
	  
	  
	 
			//----------
		  //String expectedMsg = "Your username is invalid!"; 
//		  loginPage.waitForErrorMessage();
//		  String actualMsg=loginPage.getErrorMessageText();
//		  Assert.assertTrue(actualMsg.contains(message), "message doesnot match");
//		  System.out.println(actualMsg);
		  //}

	
	/*
	 * @Test(priority =2, dataProvider = "csv", dataProviderClass =
	 * CsvReaderPractise.class)
	 * 
	 * public void PositiveLoginTest1(Object[] testData ) {
	 * 
	 * 
	 * 
	 * String userName = (String) testData[0]; String password = (String)
	 * testData[1];
	 * 
	 * WelcomePage welcomePage = new WelcomePage(driver, log);
	 * welcomePage.openPage(); LoginPage loginPage =
	 * welcomePage.authenticationClick(); secureAreaPage securePage =
	 * loginPage.logIn(userName, password); String actualUrl =
	 * securePage.getPageUrl(); String expectedUrl =
	 * "http://the-internet.herokuapp.com/secure"; Assert.assertEquals(actualUrl,
	 * expectedUrl,"Acctual url does not match Expected url");
	 * System.out.println("Url matches"); }
	 */
//@Test(priority=3,dataProvider = "data", dataProviderClass = DataProviderClass.class)

public void PositiveLoginTest2(String username, String password) {
	  
//	  String no=testData.get("no");
//	  String userName=testData.get("userName");
//	  String password=testData.get("password");
//	  String message=testData.get("message");
//	  String description=testData.get("description");
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
