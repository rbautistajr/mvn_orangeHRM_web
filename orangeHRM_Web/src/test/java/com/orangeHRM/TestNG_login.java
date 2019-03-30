package com.orangeHRM;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangeHRM.BaseTestSuite;
import utilities.ExcelUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;   


public class TestNG_login extends BaseTestSuite {
	
	@Test
	public void TestCase01_testAuthenticationSuccessWhenProvidingCorrectUsernameAndPassword() throws Exception {
		
	
		TestNG_login_PageElements.usernameTextBox(driver).click();
		TestNG_login_PageElements.usernameTextBox(driver).sendKeys("admin");
		
		TestNG_login_PageElements.passwordTextBox(driver).click();
		TestNG_login_PageElements.passwordTextBox(driver).sendKeys("Rpbjr@02");
	
		//Implementation of explicit wait. It will wait for login button to be visible for 3 seconds before clicking on it
		wt.waitForElement(By.xpath("//input[@name='Submit' and @id='btnLogin']"), 3);
		TestNG_login_PageElements.clickLogin(driver).click();
		
		impWait.ImplicitlyWait();
		thread.sleep();
		
		//Assert.assertTrue(driver.getCurrentUrl().endsWith("dashboard"));
		
		//String actual = driver.getCurrentUrl();
		//String expected = "http://localhost/orangehrm-4.1.1/symfony/web/index.php/dashboard";
		//Assert.assertEquals(actual, expected);
		//sc.screenshots();
		
		driver.navigate().back();
		driver.navigate().refresh();
		driver.get(baseUrl);
	}
	
	@Test
	public void TestCase02_testAuthenticationSuccessDashboardRedirection() throws InterruptedException{

	
		TestNG_login_PageElements.usernameTextBox(driver).click();
		TestNG_login_PageElements.usernameTextBox(driver).sendKeys("admin");
		
		TestNG_login_PageElements.passwordTextBox(driver).click();
		TestNG_login_PageElements.passwordTextBox(driver).sendKeys("Rpbjr@02");
		
		wt.waitForElement(By.xpath("//input[@name='Submit' and @id='btnLogin']"), 3);
		TestNG_login_PageElements.clickLogin(driver).click();
		
		impWait.ImplicitlyWait();
		thread.sleep();
	
			Assert.assertTrue(driver.getCurrentUrl().endsWith("dashboard"));
			driver.navigate().back();
			driver.navigate().refresh();
			
		driver.get(baseUrl);
	}

	@Test
	public void TestCase03_testAuthenticationFailedWhenProvidingIncorrectUsername() throws InterruptedException {

		TestNG_login_PageElements.usernameTextBox(driver).click();
		TestNG_login_PageElements.usernameTextBox(driver).sendKeys("admin12");
		
		WebElement passWord = gm.getElement("//input[@name='txtPassword' and @id='txtPassword']", "xpath");
		passWord.click();
		passWord.sendKeys("Rpbjr@02");
		
		TestNG_login_PageElements.clickLogin(driver).click();
		impWait.ImplicitlyWait();

		thread.sleep();
		
		Assert.assertTrue(driver.getCurrentUrl().endsWith("validateCredentials"));
		driver.navigate().back();
		driver.navigate().refresh();
		driver.get(baseUrl);
	}

	@Test
	public void TestCase04_testAuthenticationFailedWhenProvidingIncorrectPassword() throws InterruptedException {
		
	
		TestNG_login_PageElements.usernameTextBox(driver).click();
		TestNG_login_PageElements.usernameTextBox(driver).sendKeys("admin");
		
		TestNG_login_PageElements.passwordTextBox(driver).click();
		TestNG_login_PageElements.passwordTextBox(driver).sendKeys("Rpbjr@03");
		
		TestNG_login_PageElements.clickLogin(driver).click();

		impWait.ImplicitlyWait();
		thread.sleep();
		
		Assert.assertTrue(driver.getCurrentUrl().endsWith("validateCredentials"));
		driver.navigate().back();
		driver.navigate().refresh();
		driver.get(baseUrl);
	}
	
	@Test
	public void TestCase05_testAuthenticationFailedWhenProvidingIncorrectUsernameAndPassword() throws InterruptedException {

		
		TestNG_login_PageElements.usernameTextBox(driver).click();
		TestNG_login_PageElements.usernameTextBox(driver).sendKeys("admin11");
	
		TestNG_login_PageElements.passwordTextBox(driver).click();
		TestNG_login_PageElements.passwordTextBox(driver).sendKeys("Rpbjr@00");
		
		TestNG_login_PageElements.clickLogin(driver).click();

		impWait.ImplicitlyWait();

		thread.sleep();
		Assert.assertTrue(driver.getCurrentUrl().endsWith("validateCredentials"));
		
		driver.get(baseUrl);
	}
	
	@Test
	public void TestCase06_testAuthenticationFailedEmptyUsername() throws InterruptedException {

		
		TestNG_login_PageElements.usernameTextBox(driver).click();
		TestNG_login_PageElements.usernameTextBox(driver).sendKeys("");
		
		TestNG_login_PageElements.passwordTextBox(driver).click();
		TestNG_login_PageElements.passwordTextBox(driver).sendKeys("Rpbjr@02");
		
		TestNG_login_PageElements.clickLogin(driver).click();
	
		impWait.ImplicitlyWait();

		thread.sleep();
		
		
		String message = TestNG_login_PageElements.checkError(driver).getText();
		System.out.println(message);
		
		Assert.assertEquals(message,"Username cannot be empty");
		driver.navigate().refresh();
		impWait.ImplicitlyWait();
	
	}

	@Test
	public void TestCase07_testAuthenticationFailedEmptyUsernameAndPassword() throws InterruptedException {

		
		TestNG_login_PageElements.usernameTextBox(driver).click();
		TestNG_login_PageElements.usernameTextBox(driver).sendKeys("");
		
		TestNG_login_PageElements.passwordTextBox(driver).click();
		TestNG_login_PageElements.passwordTextBox(driver).sendKeys("");
		
		TestNG_login_PageElements.clickLogin(driver).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		thread.sleep();
		
		String message = TestNG_login_PageElements.checkError(driver).getText();
		System.out.println(message);
		
		Assert.assertEquals(message,"Username cannot be empty");
		driver.navigate().refresh();
	} 
	
	@Test
	public void TestCase08_testAuthenticationFailedEmptyPassword() throws InterruptedException {

		TestNG_login_PageElements.usernameTextBox(driver).click();
		TestNG_login_PageElements.usernameTextBox(driver).sendKeys("admin");
		
		TestNG_login_PageElements.passwordTextBox(driver).click();
		TestNG_login_PageElements.passwordTextBox(driver).sendKeys("");
	
		TestNG_login_PageElements.clickLogin(driver).click();
		impWait.ImplicitlyWait();
		
		thread.sleep();
	
		String message = TestNG_login_PageElements.checkError(driver).getText();
		System.out.println(message);
		
		Assert.assertEquals(message,"Password cannot be empty");
		driver.navigate().refresh();
		driver.get(baseUrl);
	} 
	/*
	@Test
	public void TestCase09_testAuthenticationSuccessRedirectionOrangeHRMLink() throws InterruptedException {

		String currentPageHandle = driver.getWindowHandle();
		//driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		//WebElement link = gm.getElement("OrangeHRM, Inc", "linkText");
		TestNG_login_PageElements.clickOrangeHRM(driver).click();
		//link.click();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		impWait.ImplicitlyWait();

		thread.sleep();
		ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());

		//String pageTitle = "HR Management System | OrangeHRM l HR Management Software";
		String pageTitle = "OrangeHRM";
		boolean myNewTabFound = false;
		
		String result = driver.getTitle();
		System.out.println(result);
		
		for (String eachHandle : tabHandles) {
			driver.switchTo().window(eachHandle);

			// Check Your Page Title
			if (driver.getTitle().equalsIgnoreCase(pageTitle)) {

				System.out.println("The Page Title is: " + pageTitle); 
				driver.close(); // Close the current tab, Note driver.quit() will close all tabs
			}
		}
		driver.get(baseUrl);
	}*/
	
	@Test
	public void TestCase10_testAuthenticationSuccessLinkedInSocialsRedirection() throws InterruptedException {

		String currentPageHandle = driver.getWindowHandle();
		
		TestNG_login_PageElements.clickLinkedIn(driver).click();
		impWait.ImplicitlyWait();

		ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());

		String pageTitle = "LinkedIn";
		boolean myNewTabFound = false; //initialization

		for (String eachHandle : tabHandles) {
			driver.switchTo().window(eachHandle);

			// Check Your Page Title
			if (driver.getTitle().equalsIgnoreCase(pageTitle)) {

				System.out.println("The Page Title is: " + pageTitle); 
				driver.close(); // Close the current tab, Note driver.quit() will close all tabs
				driver.switchTo().window(currentPageHandle); // Switch focus toOld tab
				myNewTabFound = true; 
				driver.navigate().refresh();
			}
		}
		driver.get(baseUrl);
	}
	
	@Test
	public void TestCase11_testAuthenticationSuccessFacebookSocialsRedirection() throws InterruptedException {
	  
	  String currentPageHandle = driver.getWindowHandle();
	
	  TestNG_login_PageElements.clickFB(driver).click();
	  impWait.ImplicitlyWait();
	  thread.sleep();
	  
	  ArrayList<String> tabHandles = new
	  ArrayList<String>(driver.getWindowHandles());
	  
	  String pageTitle = "OrangeHRM - World's Most Popular Opensource HRIS - Home | Facebook"; 
	  boolean myNewTabFound = false;
	  
	  for (String eachHandle : tabHandles) {
	  driver.switchTo().window(eachHandle);
	 
	  if (driver.getTitle().equalsIgnoreCase(pageTitle)) {
	 
	  System.out.println("The Page Title is: " + pageTitle); 
	  driver.close(); 
	  driver.switchTo().window(currentPageHandle); // Switch focus to Old tab
	  myNewTabFound = true; 
	  driver.navigate().refresh();
	   } 
	}
 }

	@Test
	public void TestCase12_testAuthenticationSuccessTwitterSocialsRedirection() throws InterruptedException {

		String currentPageHandle = driver.getWindowHandle();
		
		TestNG_login_PageElements.clickTwitter(driver).click();
		
		impWait.ImplicitlyWait();

		ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());

		String pageTitle = "OrangeHRM Inc. (@orangehrm) | Twitter";
		boolean myNewTabFound = false;

		for (String eachHandle : tabHandles) {
			driver.switchTo().window(eachHandle);

			// Check Your Page Title
			if (driver.getTitle().equalsIgnoreCase(pageTitle)) {

				System.out.println("The Page Title is: " + pageTitle); 
				driver.close(); // Close the current tab, Note driver.quit() will close all tabs
				driver.switchTo().window(currentPageHandle); // Switch focus to Old tab
				myNewTabFound = true;
				driver.navigate().refresh();
				impWait.ImplicitlyWait();
			}
		}
		driver.get(baseUrl);
	}
	
	@Test
	public void TestCase13_testAuthenticationSuccessYoutubeSocialsRedirection() throws InterruptedException {

		String currentPageHandle = driver.getWindowHandle();
		
		WebElement youtube = gm.getElement("//img[contains(@src,'/orangehrm-4.1.1/symfony/web/webres_5b361070cdbd61.13029450/themes/default/images/login/youtube.png')]", "xpath");
		TestNG_login_PageElements.clickYouTube(driver).click();
		impWait.ImplicitlyWait();
		thread.sleep();
		
		ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());

		String pageTitle = "OrangeHRM Inc-YouTube";
		boolean myNewTabFound = false;

		for (String eachHandle : tabHandles) {
			driver.switchTo().window(eachHandle);
			// Check Your Page Title
			if (driver.getTitle().equalsIgnoreCase(pageTitle)) {

				System.out.println("The Page Title is: " + pageTitle); 
				driver.close(); // Close the current tab, Note driver.quit() will close all tabs
				driver.switchTo().window(currentPageHandle); // Switch focus to Old tab
				myNewTabFound = true;
				driver.navigate().refresh();
			}
	    }
		driver.get(baseUrl);
	}
	
	@Test
	public void TestCase14_testAuthenticationSuccessOpenIdVisible() throws InterruptedException {
		
		String text = TestNG_login_PageElements.altLogin(driver).getText();
		System.out.println(text);
		boolean expectedResult=true;
		boolean Result1 = text.contains("Alternative Login :");
		boolean Result2 = text.contains("-- Select --");
		
		Assert.assertEquals(expectedResult,Result1);
		Assert.assertEquals(expectedResult,Result2);	
	}
	
	@Test
	public void TestCase15_testAuthenticationSuccessLoginButtonsVisible() throws InterruptedException {
	
		boolean resultLogin = TestNG_login_PageElements.buttonsVisible1(driver).isDisplayed();
		boolean resultOpenLogin = TestNG_login_PageElements.buttonsVisible2(driver).isDisplayed();
		
		boolean expectedLogin = true;
		boolean expectedOpenIDB = true;
		
		sa.assertEquals(expectedLogin,resultLogin);
		sa.assertEquals(expectedOpenIDB,resultOpenLogin);
		
		sa.assertAll();
	}
	
	@Test
	public void TestCase17_testAuthenticationSuccessProviderdropdown() throws InterruptedException {
	
		WebElement openIdProvider = TestNG_login_PageElements.openID(driver);
		openIdProvider.click();
		
		
		Select sel = new Select(openIdProvider);
		List<WebElement> options = sel.getOptions();
		int size = options.size();
		
		for (int i=0; i<size; i++) {
			String optionName = options.get(i).getText();
			System.out.println(optionName);
			
		boolean resultSelect = openIdProvider.isDisplayed();
		String resultOptionName = ("-- Select --");
		
		boolean expectedSelect = true;
		String expectedName=optionName;
		
		sa.assertEquals(expectedSelect, resultSelect);
		sa.assertEquals(expectedName, resultOptionName);
		
		sa.assertAll();
		
		}
	} 
	
	@Test
	public void TestCase18_testAuthenticationSuccessPlacholders() throws InterruptedException {
	
		WebElement userName = TestNG_login_PageElements.placeholdersUN(driver);
		WebElement passWord = TestNG_login_PageElements.placeholdersPW(driver);
		String expectedUNPlaceholder = "Username";
		String expectedPWPlaceholder = "Password";
		
		String actualUNPlaceholder = userName.getText();
		String actualPWPlaceholder = passWord.getText();
		
		System.out.println(actualUNPlaceholder);
		System.out.println(actualPWPlaceholder);
		
		sa.assertEquals(expectedUNPlaceholder, actualUNPlaceholder);
		sa.assertEquals(expectedPWPlaceholder, actualPWPlaceholder);
		
		sa.assertAll();
		}
	@Test
	public void TestCase16_testAuthenticationSuccessLoginButtonsEnabled() throws InterruptedException {
		
		boolean resultLogin = TestNG_login_PageElements.buttonsVisible1(driver).isEnabled();
		boolean resultOpenLogin = TestNG_login_PageElements.buttonsVisible2(driver).isEnabled();
		
		boolean expectedLogin = true;
		boolean expectedOpenIDB = false;
		
		sa.assertEquals(expectedLogin,resultLogin);
		sa.assertEquals(expectedOpenIDB,resultOpenLogin);
		
		sa.assertAll();
	}

	@DataProvider(name = "loginData")
	public Object[][] dataProvider() {
		Object[][] testData = ExcelUtility.getTestData("Inputs_Textboxes_Login");
		return testData;
	}

	@Test(dataProvider = "loginData")	
	public void TestCase19_testAuthenticationSuccessLoginTextboxesInputs(String username, String password) throws Exception {
		//Thread.sleep(2000);
		impWait.ImplicitlyWait();
		// Enter username
		TestNG_login_PageElements.usernameTextBox(driver).sendKeys(username);
		impWait.ImplicitlyWait();
		// Enter password
		TestNG_login_PageElements.passwordTextBox(driver).sendKeys(password);
		impWait.ImplicitlyWait();
		//click login
		driver.findElement(By.xpath("//input[@name='Submit' and @id='btnLogin']")).click();
		
		// Find if error messages exist
		boolean result = driver.findElements(By.xpath("//div[@id='divLoginButton']//span['spanMessage']")).size() != 0;
		Assert.assertTrue(result);

	} 
	
}
