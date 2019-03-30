package com.orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestNG_ChangePassword_PageElements extends TestNG_ChangePassword {
	
	public static WebElement element = null;
	/*
		//username textbox
		public static WebElement userNameTextBox(WebDriver driver) {
			element = gm.getElement("//input[@name='txtUsername' and @id='txtUsername']", "xpath");
			return element;
		}
		
		public static void fillUsernameTextbox(WebDriver driver, String un) {
			element = userNameTextBox(driver);
			element.sendKeys(un);
		}
		
		//password textbox
		public static WebElement passwordTextBox(WebDriver driver) {
			element = gm.getElement("//input[@name='txtPassword' and @id='txtPassword']", "xpath");
			return element;
		}
		
		public static void fillPasswordTextbox(WebDriver driver, String pw) {
			element = passwordTextBox(driver);
			element.sendKeys(pw);
		}
		
		//login button
		public static WebElement loginButton(WebDriver driver) {
			element = gm.getElement("//input[@name='Submit' and @id='btnLogin']", "xpath");
			return element;
		}
		*/
		//Welcome Admin link
		public static WebElement welcomeAdminLink(WebDriver driver) {
			element = gm.getElement("//a[@id='welcome']", "xpath");
			return element;
		}
		
		//change Password Link
		public static WebElement changePWLink(WebDriver driver) {
			element = gm.getElement("Change Password", "linktext");
			return element;
		}
		
		//change Password Header and Labels
		public static WebElement changePWModalContents(WebDriver driver) {
			element = gm.getElement("frmChangePassword", "id");
			return element;
		}
		
		public static WebElement changePWHeader(WebDriver driver) {
			element = gm.getElement("//div[@class='head']//h1[@id='UserHeading']", "xpath");
			return element;
		}
		
		//check save/cancel/edit button
		public static WebElement editBtn(WebDriver driver) {
			element = gm.getElement("btnSave", "id");
			return element;
		}
		
		public static WebElement saveBtn(WebDriver driver) {
			element = gm.getElement("//input[@id='btnSave'and @value='Save']", "xpath");
			return element;
		}
		
		public static WebElement cxlBtn(WebDriver driver) {
			element = gm.getElement("btnCancel", "id");
			return element;
		}
		
		//default status of current password, new password and confirm password text boxes
		
		public static WebElement curPwTxt(WebDriver driver) {
			element = gm.getElement("//input[contains(@name,'[newPassword]')]", "xpath");
			return element;
		}
		
		public static WebElement newPwTxt(WebDriver driver) {
			element = gm.getElement("//input[contains(@name,'[newPassword]')]", "xpath");
			return element;
		}
		
		public static WebElement conPwTxt(WebDriver driver) {
			element = gm.getElement("//input[contains(@name,'[confirmNewPassword]')]", "xpath");
			return element;
		}
		
		//status of current password, new password and confirm password text boxes after clicking edit button
		
		public static WebElement chgPwClick(WebDriver driver) {
			element = gm.getElement("frmChangePassword", "id");
			return element;
		}
		
		public static WebElement curPwTxtAfter(WebDriver driver) {
			element = gm.getElement("//input[contains(@name,'[newPassword]')]", "xpath");
			return element;
		}
		
		public static WebElement newPwTxtAfter(WebDriver driver) {
			element = gm.getElement("//input[contains(@name,'[newPassword]')]", "xpath");
			return element;
		}
		
		public static WebElement conPwTxtAfter(WebDriver driver) {
			element =  gm.getElement("//input[contains(@name,'[confirmNewPassword]')]", "xpath");
			return element;
		}
		
		public static WebElement editClick(WebDriver driver) {
			element =  gm.getElement("btnSave", "id");
			return element;
		}
		
		//check max length of text boxes
		
		public static WebElement curPWLen(WebDriver driver) {
			element = gm.getElement("//input[contains(@name,'[newPassword]')]", "xpath");
			return element;
		}
		
		public static WebElement newPWLen(WebDriver driver) {
			element = gm.getElement("//input[contains(@name,'[newPassword]')]", "xpath");
			return element;
		}
		
		public static WebElement conPwLen(WebDriver driver) {
			element =  gm.getElement("//input[contains(@name,'[confirmNewPassword]')]", "xpath");
			return element;
		}
		
		//OrangeHRM link text redirection
		public static WebElement ohrmRedirect(WebDriver driver) {
			element =  gm.getElement("OrangeHRM, Inc", "linktext");
			return element;
		}
		
		//footer
		public static WebElement foot(WebDriver driver) {
			element =  gm.getElement("footer", "id");
			return element;
		}
		
}