package testClasses;

import org.openqa.selenium.WebDriver;

public class threadSleep {

WebDriver driver;
	
	public threadSleep(WebDriver driver) {
		this.driver = driver;
	}
	
	public void sleep(){ 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}