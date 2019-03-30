package testClasses;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

public class ImplicitWait{
	
	WebDriver driver;
	
	public ImplicitWait(WebDriver driver) {
		this.driver = driver;
	}
	
	public void ImplicitlyWait(){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}



}