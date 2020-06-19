package com.automation.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThumpsUp {
    public static void main(String[] args) throws InterruptedException {									
    	//WebDriverManager.firefoxdriver().setup();
    	System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");	
    	WebDriver driver=new FirefoxDriver();			
        		
        //Launching the site.				
            driver.get("http://demo.guru99.com/popup.php");			
        driver.manage().window().maximize();	
}
}