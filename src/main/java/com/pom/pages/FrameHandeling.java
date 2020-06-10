package com.pom.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameHandeling extends BasePageObject {
	private By frameLocator = By.tagName("iframe");
	private By frameEditorLocator = By.id("tinymce");

	public FrameHandeling(WebDriver driver, Logger log) {
		super(driver, log);
	}
	public void writeInFrameEditor(String text) {
		//switchToFrame(frameLocator);
		type(text,frameEditorLocator);
		
	}

	public String frameEditorContent() {
		//switchToFrame(frameLocator);
		String frameEditor = find(frameEditorLocator).getText();
		return frameEditor;
	}
	
	public void frameEditor() {
		switchToFrame(frameLocator);
	}
}
