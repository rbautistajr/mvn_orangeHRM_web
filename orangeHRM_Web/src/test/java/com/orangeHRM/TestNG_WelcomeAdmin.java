package com.orangeHRM;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNG_WelcomeAdmin extends BaseTestSuite {

	JavascriptExecutor jse;
	
	
	@Test
	public void TestCase01_testAuthenticationSuccessWelcomeAdminLinkPresent() throws InterruptedException {
	
		impWait.ImplicitlyWait();
		li.LogIn();
		thread.sleep();
		TestNG_WelcomeAdmin_PageElements.welcomeAdminLink(driver).click();
	}

	@Test
	public void TestCase02_testAuthenticationSuccessAboutMenuPresent() throws InterruptedException {
		thread.sleep();
		Boolean textResult = true;
		Boolean result = TestNG_WelcomeAdmin_PageElements.AboutLink(driver).isDisplayed();
		System.out.println("About Menu is  Displayed: " + result);
		Assert.assertEquals(result, textResult);
	}

	@Test
	public void TestCase03_testAuthenticationSuccessChangePasswordMenuPresent() throws InterruptedException {

		Boolean textResult2 = true;
		Boolean result2 = TestNG_WelcomeAdmin_PageElements.ChangePWLink(driver).isDisplayed();
		System.out.println("Change Password Menu is  Displayed: " + result2);
		Assert.assertEquals(result2, textResult2);
	}

	@Test
	public void TestCase04_testAuthenticationSuccessLogoutMenuPresent() throws InterruptedException {

		Boolean textResult3 = true;
		Boolean result3 = TestNG_WelcomeAdmin_PageElements.Logout(driver).isDisplayed();
		System.out.println("Logout Menu is  Displayed: " + result3);
		Assert.assertEquals(result3, textResult3);
	}

}