package com.orangeHRM;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;



//file utility
import java.io.File;  //io files (input and output)
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;

//web drivers
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

//desired capabilities selenium grid 
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.RemoteWebDriver; //remote web driver

//data driven testing
import utilities.Constants;				
import utilities.ExcelUtility;
import testClasses.GenericMethods;
import testClasses.ImplicitWait;
import testClasses.LoggingIn;
import testClasses.implicitWaiting;
import testClasses.screenshot;
import testClasses.threadSleep;
import testClasses.wait;

public class BaseTestSuite {
	
  //public RemoteWebDriver rmdriver; 		// remote web driver
	public WebDriver driver; 				// for ordinary web driver
	protected JavascriptExecutor jse;
	protected String baseUrl = "http://localhost/orangehrm-4.1.1/symfony/web/index.php/auth/login";  // baseUrl variable  to be accessed by child class
	protected String nodeURL; 				// for selenium grid
	protected static GenericMethods gm;  	//making GenericMethods class public
	protected SoftAssert sa; 				//making SoftAssert class public
	protected wait wt;						//making wait class public
	protected ImplicitWait impWait;			//making Implicit wait class public
	protected implicitWaiting slp;			//making implicitWaiting class public
	protected LoggingIn li; 
	protected threadSleep thread;
	protected screenshot sc;
	
	@BeforeClass
	public void setup() throws MalformedURLException {		
		//Enabled system property and driver when not using selenium grid
		
		System.setProperty("webdriver.chrome.driver", "C:/selenium/drivers/chromedriver_win32/latest/chromedriver.exe");
		driver = new ChromeDriver(); 
		
		/*
		System.setProperty("webdriver.gecko.driver", "C:/selenium/drivers/geckodriver/latest/geckodriver-v0.24.0-win64/geckodriver.exe");
		driver = new FirefoxDriver(); 
		
		//for IE explorer driver since there is an issue with slow sendkeys, used 32 bit driver instad of 64
		System.setProperty("webdriver.ie.driver", "C:/selenium/drivers/IEdriver/latest/IEDriverServer_x64_3.14.0/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", "C:/selenium/drivers/IEdriver/lates x32 bit/IEDriverServer_Win32_3.14.0/IEDriverServer.exe");
		driver = new InternetExplorerDriver(); 
		
		System.setProperty("webdriver.edge.driver", "C:/selenium/drivers/edgedriver/MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
		*/
		/*
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.WINDOWS);
	
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setBrowserName("firefox");
		dc.setPlatform(Platform.WINDOWS);
		
		DesiredCapabilities dc= new DesiredCapabilities();
		dc.setBrowserName("internet explorer");
		dc.setPlatform(Platform.WINDOWS);
		
		nodeURL="http://localhost:4444/wd/hub";
		WebDriver driver= new RemoteWebDriver(new URL(nodeURL),dc);
		*/
		//instantiating class to access it inside a method
		gm = new GenericMethods(driver); //accessing GenericMethod class instance inside a method
		wt = new wait(driver);  
		sa = new SoftAssert();  
		impWait = new ImplicitWait(driver);  
		slp = new implicitWaiting(driver);
		li = new LoggingIn(driver);
		thread = new threadSleep(driver);
		sc= new screenshot(driver);
		
		driver.get(baseUrl);
		
		// Tell the code about the location of Excel file for data driven testing
		try {
			ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "Inputs_Textboxes"); // data driven testing for login textboxes
		} catch (Exception e) {
			e.printStackTrace();
		} 

		driver.manage().window().maximize();
		impWait.ImplicitlyWait();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}	

	@AfterClass
	public void TearDown() throws InterruptedException{
		driver.quit();  
		
	}
	
	
}
