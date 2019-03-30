package com.orangeHRM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestNG_AboutUs_PageElements extends TestNG_About {
		
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
	
	//about Link
	public static WebElement aboutLink(WebDriver driver) {
		element = gm.getElement("//a[@id ='aboutDisplayLink']", "xpath");
		return element;
	}
	
	//About Modal
	
	public static WebElement AboutModal(WebDriver driver) {
		element = gm.getElement("//div[@class='modal hide in']", "xpath");
		return element;
	}
	
	//About Headers and Label Contents
	
	public static WebElement ModalHeader(WebDriver driver) {
		element = gm.getElement("//div[@class='modal-header']//h3", "xpath");
		return element;
	}
	
	public static WebElement ModalLabels(WebDriver driver) {
		element = gm.getElement("//div[@id='companyInfo']", "xpath");
		return element;
	}
	
	
	
}
