package com.orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestNG_WelcomeAdmin_PageElements extends TestNG_WelcomeAdmin{
	
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
			
			//About Display link
			public static WebElement AboutLink(WebDriver driver) {
				element = gm.getElement("Change Password", "linktext");
				return element;
			}
			
			//Change Password Display link
			public static WebElement ChangePWLink(WebDriver driver) {
			element = gm.getElement("Change Password", "linktext");
			return element;
			}
			
			//Log out Display link
			public static WebElement Logout(WebDriver driver) {
			element = gm.getElement("Logout", "linktext");
			return element;
			}
}