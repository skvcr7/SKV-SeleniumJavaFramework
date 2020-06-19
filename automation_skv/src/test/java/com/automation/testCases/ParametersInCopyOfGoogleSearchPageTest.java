package com.automation.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import config.PropertiesFile;
import pages.GoogleSearchPageObjects;

public class ParametersInCopyOfGoogleSearchPageTest {
	static WebDriver driver = null;
	//public static String browserName=null;
	
	@BeforeTest
	@Parameters("BrowserName")
	public void SetUpTest(String BrowserName) throws Exception{
			System.out.println("Thread is : "+Thread.currentThread().getId());
		String projectPath= System.getProperty("user.dir");
		//PropertiesFile.getProperties();
		if(BrowserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("firefox"))
				System.setProperty("webdriver.gecko.driver",projectPath+"/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
	}
		//driver.get("http://google.com");
	//GoogleSearchTest();	
	@Test
	public void GoogleSearchTest() throws Exception {
		
		
		
		GoogleSearchPageObjects searchPageObj= new GoogleSearchPageObjects(driver);
		driver.get("http://google.com");
		searchPageObj.setTextInSearchBox("A B C D");
		Thread.sleep(1000);
		searchPageObj.clickSearchButton();
	}
	@AfterTest
	public void tearDownTest() {
		driver.close();
		System.out.println("task completed successfully");
		PropertiesFile.setProperties();
	}
	
}

