package listeners;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.TestNGListeners.class)
public class TestNGListenerDemo {
	
	@Test(groups={"Smoke"})
	public void test1() {
		System.out.println("inside 1");
	}
	//@Test(groups={"Sanity"})
	@Test(retryAnalyzer =listeners.MyRetry.class, groups={"Sanity"})
	public void test2() {
		System.out.println("inside 2");
		//Assert.assertFalse(true);
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver",projectPath+"/drivers/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Automation step by step");
		//System.out.println(driver.findElement(By.name("q")).getText());
		driver.findElement(By.name("abc")).sendKeys("Selenium with java");
		//Thread.sleep(1000);
		Assert.assertTrue(false);
//		
	}
	@Test(groups={"Smoke"})
	public void test3() {
		System.out.println("inside 3");
		throw new SkipException("this test is skipped");
	}
	@Test(retryAnalyzer =listeners.MyRetry.class,groups={"Sanity"})
	public void test4() throws Exception {
		System.out.println("inside 4");
		//Assert.assertFalse(true);
		String projectPath= System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver",projectPath+"/drivers/geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		driver.findElement(By.name("q")).sendKeys("A B C D");
		//driver.findElement(By.name("abc")).sendKeys("Automation step by step");
		Thread.sleep(1000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		Assert.assertTrue(false);
	}
}
