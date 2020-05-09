package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.main.BaseClass;


public class ExceptionDemo extends BaseClass{
	//private WebDriver driver;

//	@BeforeMethod(alwaysRun = true)
//	public void setUp() {
//		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver"); driver = new ChromeDriver();	
//	
//	}
	/*
	 * @Parameters("browser")
	 * 
	 * @BeforeMethod(alwaysRun = true) private void setUp(String brows) { // Create
	 * driver switch (brows) { case "Chrome": {
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * "src/main/resources/chromedriver"); driver = new ChromeDriver();
	 * System.out.println("Starting Chrom"); break; } case "Firefox": {
	 * 
	 * System.setProperty("webdriver.gecko.driver","src/main/resources/geckodriver")
	 * ; driver = new FirefoxDriver(); System.out.println("Starting Firefox");
	 * break; } default: System.setProperty("webdriver.chrome.driver",
	 * "src/main/resources/chromedriver"); driver = new ChromeDriver();
	 * System.out.println("Default....."); break; }
	 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); }
	 */
	@Test(priority = 2)
	public void notVisible() {
		String url = "http://the-internet.herokuapp.com/dynamic_loading/1";
		driver.get(url);
		System.out.println("Page is opened.");
		sleep(3000);
		WebElement btn = driver.findElement(By.xpath("//div[@id='start']/button"));
		btn.click();
		//sleep(3000);
		// //h4[text()='Hello World!']
		
		String expected = "Hello World!";
		WebElement getLabel = driver.findElement(By.id("finish"));
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(getLabel));
		
		String actual = getLabel.getText();
		Assert.assertTrue(expected.contains(actual), "Not same");
	}
	
	@Test(priority = 1)
	public void noSuchElementFound() {
		String url = "http://the-internet.herokuapp.com/dynamic_loading/2";
		driver.get(url);
		System.out.println("Page is opened.");
		sleep(3000);
		WebElement btn = driver.findElement(By.xpath("//div[@id='start']/button"));
		btn.click();
		//sleep(3000);
		// //h4[text()='Hello World!']
		
		String expected = "Hello World!";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement getLabel = driver.findElement(By.id("finish"));
		
		
		WebElement getLabel=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
		
		String actual = getLabel.getText();
		Assert.assertTrue(expected.contains(actual), "Not same");
	}
	@Test(priority = 3)
	public void timeOut() {
		String url = "http://the-internet.herokuapp.com/dynamic_loading/1";
		driver.get(url);
		System.out.println("Page is opened.");
		sleep(3000);
		WebElement btn = driver.findElement(By.xpath("//div[@id='start']/button"));
		btn.click();
		//sleep(3000);
		// //h4[text()='Hello World!']
		
		String expected = "Hello World!";
		WebElement getLabel = driver.findElement(By.id("finish"));
		
		WebDriverWait wait = new WebDriverWait(driver, 3);
		
		try {
		getLabel = wait.until(ExpectedConditions.visibilityOf(getLabel));
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("Time out...");
			sleep(2000);
		}
		
		String actual = getLabel.getText();
		Assert.assertTrue(expected.contains(actual), "Not same");
	}
	@Test
	public void staleElementTest() {
		driver.get("http://the-internet.herokuapp.com/dynamic_controls");

		WebElement checkbox = driver.findElement(By.id("checkbox"));
		WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));
		WebDriverWait wait = new WebDriverWait(driver, 20);

		removeButton.click();
		String actual = "It's gone!";
		WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		String expected = msg.getText();
		System.out.println(expected);
		Assert.assertTrue(actual.contains(expected), "Message displayed");
		////////////////////////////////////////////
		/*WebElement checkbox = driver.findElement(By.id("checkbox"));
		WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(),'Remove')]"));

		WebDriverWait wait = new WebDriverWait(driver, 10);

		removeButton.click();
//		wait.until(ExpectedConditions.invisibilityOf(checkbox));
//		Assert.assertFalse(checkbox.isDisplayed());

//		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(checkbox)),
//				"Checkbox is still visible, but shouldn't be");

		Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(checkbox)),
				"Checkbox is still visible, but shouldn't be");
		
		WebElement addButton = driver.findElement(By.xpath("//button[contains(text(),'Add')]"));
		addButton.click();
		
		WebElement checkbox2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
		Assert.assertTrue(checkbox2.isDisplayed(), "Checkbox is not visible, but it should be");
*/
	}
	@Test
	public void enableTextbox() {
		//button[contains(text(),'Enable')]
		driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		WebElement enableButton = driver.findElement(By.xpath("//button[contains(text(),'Enable')]"));
		enableButton.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement textBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
		textBox.sendKeys("Hello");
		
		System.out.println(textBox.getAttribute("value"));
		Assert.assertEquals(textBox.getAttribute("value"),"Hello");
		
	}
	
//	@AfterMethod(alwaysRun = true)
//	private void closeDriver() {
//		// close driver
//		System.out.println("closing...");
//		driver.quit();     
//	}

	private void sleep(long m) {
		try {
			Thread.sleep(m);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
