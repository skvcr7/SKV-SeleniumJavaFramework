package com.automation.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleSearch {

	public static void main(String[] args) throws Exception {
		search();
	}
	
	public static void search() throws Exception {
		
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver",projectPath+"/drivers/geckodriver.exe");
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		System.out.println("task comp");
	}
}
