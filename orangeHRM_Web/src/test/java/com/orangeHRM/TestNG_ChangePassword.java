package com.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import com.orangeHRM.TestNG_ChangePassword_PageElements;

public class TestNG_ChangePassword extends BaseTestSuite {

	JavascriptExecutor jse;
	
	@Test
	public void TestCase01_testAuthenticationSuccessPageRedirectionChangePassword() throws InterruptedException {
		
		impWait.ImplicitlyWait();
	    li.LogIn();
		
		TestNG_ChangePassword_PageElements.welcomeAdminLink(driver).click();
		impWait.ImplicitlyWait();
		
		TestNG_ChangePassword_PageElements.changePWLink(driver).click();
		Assert.assertTrue(driver.getCurrentUrl().endsWith("changeUserPassword"));
		impWait.ImplicitlyWait();
	}
	
	@Test
	public void TestCase02_testAuthenticationSuccessFormLabelsVisible() throws InterruptedException {
	
		WebElement modal2 = TestNG_ChangePassword_PageElements.changePWModalContents(driver);
		String Expectedlabel = modal2.getText();
		
		WebElement header = TestNG_ChangePassword_PageElements.changePWHeader(driver);
		String ActualResult = header.getText();
		String ExpectedResult = "Change Password";
		Boolean ExpectedResult2 = true;	

		Boolean Result1 = Expectedlabel.contains("Username");
		Boolean Result2 = Expectedlabel.contains("Admin");
		Boolean Result3 = Expectedlabel.contains("Current Password *");
		Boolean Result4 = Expectedlabel.contains("New Password *");
		Boolean Result5 = Expectedlabel.contains("For a strong password, please use a hard to guess combination of text with upper and lower case characters, symbols and numbers");
		Boolean Result6 = Expectedlabel.contains("Confirm New Password *");
		Boolean Result7 = Expectedlabel.contains("* Required field");
		
		sa.assertEquals(ActualResult, ExpectedResult);
		sa.assertEquals(ExpectedResult2, Result1);
		sa.assertEquals(ExpectedResult2, Result2);
		sa.assertEquals(ExpectedResult2, Result3);
		sa.assertEquals(ExpectedResult2, Result4);
		sa.assertEquals(ExpectedResult2, Result5);
		sa.assertEquals(ExpectedResult2, Result6);
		sa.assertEquals(ExpectedResult2, Result7);
		
		sa.assertAll();
	
	}

	@Test
	public void TestCase03_testAuthenticationSuccessEditCancelButtonsVisibleDefault() throws InterruptedException {

		boolean EditBtn = TestNG_ChangePassword_PageElements.editBtn(driver).isDisplayed();
		boolean expected = true;
		System.out.println(EditBtn);
		sa.assertEquals(expected, EditBtn);
		TestNG_ChangePassword_PageElements.editBtn(driver).click();
		

		boolean SvBtn = TestNG_ChangePassword_PageElements.saveBtn(driver).isDisplayed();
		boolean expected1 = true;
		System.out.println(SvBtn);
		sa.assertEquals(expected1, SvBtn);
		
		boolean CxlBtn = TestNG_ChangePassword_PageElements.cxlBtn(driver).isDisplayed();
		boolean expected2 = true;
		System.out.println(CxlBtn);
		sa.assertEquals(expected2, CxlBtn);
		
		sa.assertAll();
	}
	/*
	
	@Test
	public void TestCase04_testAuthenticationSuccessElementsInitiallyDisabledDefault() throws InterruptedException {
	
		WebElement cxBtn = driver.findElement(By.id("btnCancel"));

		boolean curPwActual = TestNG_ChangePassword_PageElements.curPwTxt(driver).isEnabled();
		System.out.println(curPwActual);
		boolean newPwActual = TestNG_ChangePassword_PageElements.newPwTxt(driver).isEnabled();
		System.out.println(newPwActual);
		boolean confPwActual = TestNG_ChangePassword_PageElements.conPwTxt(driver).isEnabled();
		System.out.println(confPwActual);
	
		boolean expected1 = false;
		boolean expected2 = false;
		boolean expected3 = false;
		//boolean expected4 = false;

		sa.assertEquals(curPwActual, expected1);
		sa.assertEquals(newPwActual, expected2);
		sa.assertEquals(confPwActual, expected3);
		// Assert.assertEquals(cxBtnActual, expected4);
		
		sa.assertAll();
	}

	@Test
	public void TestCase05_testAuthenticationElementsSuccessEnabledWhenEditTriggered() throws InterruptedException {
		
		
		String Expectedlabel = TestNG_ChangePassword_PageElements.chgPwClick(driver).getText();
		Boolean ExpectedResult = true;
		TestNG_ChangePassword_PageElements.editClick(driver).click();
		Boolean Result2 = Expectedlabel.contains("Admin");
		boolean curPwActual = TestNG_ChangePassword_PageElements.curPwTxtAfter(driver).isEnabled();
		System.out.println(curPwActual);
		boolean newPwActual = TestNG_ChangePassword_PageElements.newPwTxtAfter(driver).isEnabled();
		System.out.println(newPwActual);
		boolean confPwActual = TestNG_ChangePassword_PageElements.conPwTxtAfter(driver).isEnabled();
		System.out.println(confPwActual);
		// boolean cxBtnActual = cxBtn.isEnabled();

		boolean expected1 = true;
		boolean expected2 = true;
		boolean expected3 = true;
		// boolean expected4 = false;

		sa.assertEquals(ExpectedResult, Result2);
		sa.assertEquals(curPwActual, expected1);
		sa.assertEquals(newPwActual, expected2);
		sa.assertEquals(confPwActual, expected3);
		// Assert.assertEquals(cxBtnActual, expected4);
		
		sa.assertAll();
	}  
	*/
	@Test
	public void TestCase06_testAuthenticationSuccessTexBoxesMaxLength() throws InterruptedException {
	String curPWMaximumlength= TestNG_ChangePassword_PageElements.curPWLen(driver).getAttribute("maxlenght");
		System.out.println("Current Password max length is: " + curPWMaximumlength);
		sa.assertEquals(curPWMaximumlength,"64");
		
		String newPWMaximumlength= TestNG_ChangePassword_PageElements.newPWLen(driver).getAttribute("maxlenght");
		System.out.println("New Password max length is: " + newPWMaximumlength);
		sa.assertEquals(newPWMaximumlength,"64");
		
		String confPWMaximumlength= TestNG_ChangePassword_PageElements.conPwLen(driver).getAttribute("maxlenght");
		System.out.println("Confirm Password max length is: " + confPWMaximumlength);
		sa.assertEquals(confPWMaximumlength,"64");
		
		sa.assertAll();
	}
	
	@Test
	public void TestCase07_testAuthenticationSuccessTexBoxesMinLength() throws InterruptedException {
		String curPWMinimumlength = TestNG_ChangePassword_PageElements.curPWLen(driver).getAttribute("minlength");
		System.out.println("Current Password min length is: " + curPWMinimumlength);
		sa.assertEquals(curPWMinimumlength,"8");
		
		String newPWMinimumlength = TestNG_ChangePassword_PageElements.newPWLen(driver).getAttribute("minlength");
		System.out.println("New Password min length is: " + newPWMinimumlength);
		sa.assertEquals(newPWMinimumlength,"8");
		
		String confPWMinimumlength=  TestNG_ChangePassword_PageElements.conPwLen(driver).getAttribute("minlength");
		System.out.println("Confirm Password min length is: " + confPWMinimumlength);
		sa.assertEquals(confPWMinimumlength,"8");	
		sa.assertAll();
	}
	
	@Test
	public void TestCase08_testAuthenticationSuccessRedirectionOrangeHRMLink() throws InterruptedException {

		// Find Open Window button
		TestNG_ChangePassword_PageElements.ohrmRedirect(driver).click();
		impWait.ImplicitlyWait();
		
	} 
	
	@Test
	public void TestCase09_testAuthenticationSuccessFooterContent() throws InterruptedException {
		
		String ftrContent = TestNG_ChangePassword_PageElements.foot(driver).getText();
		Boolean ActualResult = true;
		Boolean expected1 = ftrContent.contains("OrangeHRM 4.1.1");
		Boolean expected2 = ftrContent.contains("© 2005 - 2019 OrangeHRM, Inc. All rights reserved.");
		// System.out.println(ftrContent);
		sa.assertEquals(ActualResult, expected1);
		sa.assertEquals(ActualResult, expected2);
		
		sa.assertAll();
	}
	
	@Test
	public void TestCase10_testAuthenticationSuccessFormContent() throws InterruptedException {
		
		String ftrContent = TestNG_ChangePassword_PageElements.foot(driver).getText();
		System.out.println(ftrContent);
		Boolean ActualResult = true;
		System.out.println(ftrContent);
		Boolean expected1 = ftrContent.contains("OrangeHRM 4.1.1");
		Boolean expected2 = ftrContent.contains("© 2005 - 2019 OrangeHRM, Inc. All rights reserved.");
		// System.out.println(ftrContent);
		sa.assertEquals(ActualResult, expected1);
		sa.assertEquals(ActualResult, expected2);
		
		sa.assertAll();
	}

}