package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class ExcelDataProvider {
	
	WebDriver driver =null;
	
	@BeforeTest
	public void SetUpTest() throws Exception{
		String projectPath= System.getProperty("user.dir");
		PropertiesFile.getProperties();

				System.setProperty("webdriver.gecko.driver",projectPath+"/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
	}
	
	@Test(dataProvider="test1data")
	public void test1(String username, String password) {
		System.out.println(username+"   "+password);
	}
	
	@DataProvider(name="test1data")
	public Object[][] getData() {
		String excelPath="C:/selenium_sl_workspace/automation_skv/Excel/data.xlsx";
		Object data[][]=testData(excelPath, "Sheet1");
		return data;
	}

	public static Object[][] testData(String excelPath,String sheetName) {
		ExcelUtils excel = new ExcelUtils(excelPath,sheetName);
		int rowCount= excel.getRowCount();
		int colCount= excel.getColCount();
		
		Object data[][] =new Object[rowCount-1][colCount];
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				String cellData= excel.getCellDataString(i, j);
				data[i-1][j] = cellData;
				//System.out.println(cellData);
			}
		}
		return data;
	}


}
