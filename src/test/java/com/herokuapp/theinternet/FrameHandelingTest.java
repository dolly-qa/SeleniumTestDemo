package com.herokuapp.theinternet;

import org.testng.annotations.Test;

import com.pom.base.TestUtils;
import com.pom.pages.FrameHandeling;
import com.pom.pages.WelcomePage;

public class FrameHandelingTest extends TestUtils{
@Test
	public void frameTest() {
		WelcomePage mainPage = new WelcomePage(driver, log);
		mainPage.openPage();
		FrameHandeling framePage = mainPage.frameClick();
		framePage.frameEditor();
		framePage.writeInFrameEditor("Hello....");
		sleep(2000);
		String frameContent = framePage.frameEditorContent();
		System.out.println(frameContent);
		sleep(2000);
		
	}
}
