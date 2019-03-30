package testClasses;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class screenshot {
	
	WebDriver driver;
	
	public screenshot(WebDriver driver) {
		this.driver = driver;
	}
	
	public void screenshots() throws Exception {
		Date d = new Date(); // for timestamp >> (d.toString().replace(":", "_").replace(" ", "_"))
		String fileName = getRandomString(10) + (d.toString().replace(":", "_").replace(" ", "_")) + ".png";
		String directory = "C://Users//Abegail Bautista//Desktop//Automation_Screenshots//TestResult_Screenshots_Chrome//";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(sourceFile, new File(directory + fileName));
	}
	
	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i = 0; i < length; i++) {
			int index = (int) (Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

}