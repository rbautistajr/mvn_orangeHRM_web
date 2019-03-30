package testClasses;

import org.openqa.selenium.WebDriver;
import com.orangeHRM.BaseTestSuite; //need to import BaseTestSuite because it is located from a different package
import com.orangeHRM.LoggingIn_PageElements;


public class LoggingIn extends BaseTestSuite{

		WebDriver driver;
		
		public LoggingIn(WebDriver driver) {
			this.driver = driver;
		}
		
		public void LogIn(){
			
			/*WebElement userName = gm.getElement("//input[@name='txtUsername' and @id='txtUsername']", "xpath");
			userName.click();
			userName.sendKeys("admin");*/
			LoggingIn_PageElements.userNameTextBox(driver).click();
			LoggingIn_PageElements.fillUsernameTextbox(driver,"admin");
			
			/*WebElement passWord = gm.getElement("//input[@name='txtPassword' and @id='txtPassword']", "xpath");
			passWord.click();
			passWord.sendKeys("Rpbjr@02");*/
			
			LoggingIn_PageElements.passwordTextBox(driver).click();
			LoggingIn_PageElements.fillPasswordTextbox(driver,"Rpbjr@02");
			
			//WebElement login = gm.getElement("//input[@name='Submit' and @id='btnLogin']", "xpath");
			//login.click();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			LoggingIn_PageElements.loginButton(driver).click();
			
		}
}
