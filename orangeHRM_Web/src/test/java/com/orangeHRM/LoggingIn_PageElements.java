package com.orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import testClasses.LoggingIn;

public class LoggingIn_PageElements extends LoggingIn {

	public LoggingIn_PageElements(WebDriver driver) {
		super(driver);
	}

	public static WebElement element = null;
	
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
}
