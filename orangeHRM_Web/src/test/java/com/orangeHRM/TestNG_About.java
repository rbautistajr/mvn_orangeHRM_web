package com.orangeHRM;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangeHRM.TestNG_AboutUs_PageElements;

public class TestNG_About extends BaseTestSuite {

	JavascriptExecutor jse;
	
	@Test
	public void TestCase01_testAuthenticationSuccessAboutMenuPopUpPresent() throws InterruptedException {
		
		impWait.ImplicitlyWait();
		li.LogIn();
		
		thread.sleep();
		
		TestNG_AboutUs_PageElements.welcomeAdminLink(driver).click();	
		slp.Sleep();
		
		thread.sleep();
		
		TestNG_AboutUs_PageElements.aboutLink(driver).click();
		slp.Sleep();

		Boolean ExpectedResult = true;
		Boolean ActualResult = TestNG_AboutUs_PageElements.aboutLink(driver).isDisplayed();
		System.out.println("About Menu Pop-up is Displayed: " + ActualResult);
		Assert.assertEquals(ExpectedResult, ActualResult);	
	}

	@Test
	public void TestCase02_testAuthenticationSuccessLabelPresent() throws InterruptedException {
		
		String Expectedlabel = TestNG_AboutUs_PageElements.ModalHeader(driver).getText();
		System.out.println(Expectedlabel);
		String Expectedlabel2 = TestNG_AboutUs_PageElements.ModalLabels(driver).getText();
		System.out.println(Expectedlabel2);
		
		Boolean ExpectedResult = true;

		Boolean Result1 = Expectedlabel2.contains("Company Name:");
		Boolean Result2 = Expectedlabel2.contains("Version");
		Boolean Result3 = Expectedlabel2.contains("Active");
		Boolean Result4 = Expectedlabel2.contains("Terminated");
		Boolean Result5 = Expectedlabel.contains("About");
		
		
		sa.assertEquals(ExpectedResult, Result1);
		sa.assertEquals(ExpectedResult, Result2);
		sa.assertEquals(ExpectedResult, Result3);
		sa.assertEquals(ExpectedResult, Result4);
		sa.assertEquals(ExpectedResult, Result5);
		
		sa.assertAll();
	}

}