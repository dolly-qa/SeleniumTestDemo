package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pom.base.TestUtils;


public class DataProviderTest2 extends TestUtils{
	WebDriver driver;
	protected By chooseFile = By.id("file-upload");
	protected By uploadButton = By.id("file-submit");
	protected By textOfUpUplodedFile = By.id("uploaded-files");
	
	//Two way to use DataProvider----One is here "Data are in dataProvider class within same package" and other is in Example DataProviderTest
	@Test(dataProvider = "files")
	public void dataProviderTest2(int i, String name) {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/upload");
		String filePath = System.getProperty("user.dir") + "/src/main/resources/" + name;
		driver.findElement(chooseFile).sendKeys(filePath);
		sleep1(2000);
		driver.findElement(uploadButton).click();
		String text = driver.findElement(textOfUpUplodedFile).getText();
		System.out.println("File no" + i + "is:" + text);
		sleep(2000);
		Assert.assertTrue(filePath.contains(text),"File not found..");
		
		driver.quit();
	}
	
	protected void sleep1(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
