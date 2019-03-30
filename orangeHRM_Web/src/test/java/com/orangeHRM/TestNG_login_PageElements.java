package com.orangeHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestNG_login_PageElements extends TestNG_login {

	public static WebElement element = null;

	// typing in username textbox
	public static WebElement usernameTextBox(WebDriver driver) {
		element = gm.getElement("//input[@name='txtUsername' and @id='txtUsername']", "xpath");
		return element;
	}

	// typing in password textbox
	public static WebElement passwordTextBox(WebDriver driver) {
		element = gm.getElement("//input[@name='txtPassword' and @id='txtPassword']", "xpath");
		return element;
	}

	// clicking login button
	public static WebElement clickLogin(WebDriver driver) {
		element = gm.getElement("//input[@name='Submit' and @id='btnLogin']", "xpath");
		return element;
	}

	// span error message
	public static WebElement checkError(WebDriver driver) {
		element = gm.getElement("spanMessage", "id");
		return element;
	}

	// orangeHRM link
	public static WebElement clickOrangeHRM(WebDriver driver) {
		element = gm.getElement("OrangeHRM, Inc", "linkText");
		return element;
	}

	// linkedin link
	public static WebElement clickLinkedIn(WebDriver driver) {
		element = gm.getElement(
				"//img[contains(@src,'/orangehrm-4.1.1/symfony/web/webres_5b361070cdbd61.13029450/themes/default/images/login/linkedin.png')]",
				"xpath");
		return element;
	}

	// facebook link
	public static WebElement clickFB(WebDriver driver) {
		element = gm.getElement(
				"//img[contains(@src,'/orangehrm-4.1.1/symfony/web/webres_5b361070cdbd61.13029450/themes/default/images/login/facebook.png')]",
				"xpath");
		return element;
	}

	// twitter link
	public static WebElement clickTwitter(WebDriver driver) {
		element = gm.getElement(
				"//img[contains(@src,'/orangehrm-4.1.1/symfony/web/webres_5b361070cdbd61.13029450/themes/default/images/login/twiter.png')]",
				"xpath");
		return element;
	}

	// youtube link
	public static WebElement clickYouTube(WebDriver driver) {
		element = gm.getElement(
				"//img[contains(@src,'/orangehrm-4.1.1/symfony/web/webres_5b361070cdbd61.13029450/themes/default/images/login/youtube.png')]",
				"xpath");
		return element;
	}

	// alternative login
	public static WebElement altLogin(WebDriver driver) {
		element = gm.getElement("openIDForm", "id");
		return element;
	}

	// success login authentication buttons visible and enabled
	public static WebElement buttonsVisible1(WebDriver driver) {
		element = gm.getElement("btnLogin", "id");
		return element;
	}

	// success login authentication buttons visible and enabled
	public static WebElement buttonsVisible2(WebDriver driver) {
		element = gm.getElement("openIdLogin", "id");
		return element;
	}

	// openID provider dropdown
	public static WebElement openID(WebDriver driver) {
		element = gm.getElement("openIdProvider", "id");
		return element;
	}

	// loginPlaceholders
	public static WebElement placeholdersUN(WebDriver driver) {
		element = gm.getElement("//div[@id='divUsername' and @class='textInputContainer']//span[@class='form-hint']", "xpath");
		return element;
	}

	public static WebElement placeholdersPW(WebDriver driver) {
		element = gm.getElement("//div[@id='divPassword' and @class='textInputContainer']//span[@class='form-hint']", "xpath");
		return element;
	}
}