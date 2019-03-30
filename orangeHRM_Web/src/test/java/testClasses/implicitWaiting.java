package testClasses;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class implicitWaiting{
	
	WebDriver driver;
	
	public implicitWaiting(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Sleep(){
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	}

}