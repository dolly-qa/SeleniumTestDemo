package com.herokuapp.theinternet;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.base.TestUtils;
import com.pom.pages.KeyHandlingPage;

public class KeyPressTest extends TestUtils {
@Test
	public void keyPress() {
		KeyHandlingPage page = new KeyHandlingPage(driver, log);
		page.openPage();
		// Push keyboard key
		page.typeText(Keys.ENTER);
		sleep(2000);
		// Get Results text
		String result = page.textResult();
		System.out.println(result);

		// Verify Result text is expected
		Assert.assertTrue(result.contains("You entered: ENTER"),
				"result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
	}

//	@Test
//	public void pressKeyWithActionsTest() {
//		log.info("Starting pressKeyWithActionsTest");
//
//		// open KeyPressesPage
//		KeyHandlingPage keyPressesPage = new KeyHandlingPage(driver, log);
//		keyPressesPage.openPage();
//
//		// Push keyboard key
//		keyPressesPage.pressKeyWithActions(Keys.SPACE);
//		sleep(2000);
//		// Get Results text
//		String result = keyPressesPage.textResult();
//		System.out.println(result);
//		sleep(2000);
//		// Verify Result text is expected
//		Assert.assertTrue(result.contains("You entered: "),
//				"result is not expected. \nShould be 'You entered: ENTER', but it is '" + result + "'");
//	}
}
