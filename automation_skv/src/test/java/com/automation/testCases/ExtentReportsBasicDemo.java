package com.automation.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicDemo {

	static WebDriver driver = null;
	
	public static void main(String[] args) throws Exception {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		 // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
        
        String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver",projectPath+"/drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		
		// log(Status, details)
        test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.pass("navigated");
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		test.pass("entered text");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test.pass("pressed enter");
		System.out.println("task comp");
		driver.close();
		test.info("task completed");
		// calling flush writes everything to the log file
        extent.flush();
	}
}
