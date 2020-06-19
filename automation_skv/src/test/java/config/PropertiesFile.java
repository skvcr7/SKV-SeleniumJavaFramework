package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.automation.testCases.GoogleSearchPageTest;

public class PropertiesFile {

	static Properties prop = new Properties();
	static String projectPath= System.getProperty("user.dir");
	
	public static void main(String[] args) {
		getProperties();
		setProperties();
		getProperties();
		// TODO Auto-generated method stub
	}
		public static void getProperties() {
			
			try {
				//Properties prop = new Properties();
				
				
				InputStream input= new FileInputStream(projectPath+"/src/test/java/config/config.properties");
				prop.load(input);
				String browser = prop.getProperty("browser");
				System.out.println(browser);
				GoogleSearchPageTest.browserName=browser;
				
			} catch (Exception exp) {
				System.out.println("i am inside catch block");
				System.out.println("message is : "+exp.getMessage());
				System.out.println("cause is : "+exp.getCause());
				exp.printStackTrace();
			}
			
		}
		public static void setProperties() {
			try {
			OutputStream output = new FileOutputStream(projectPath+"/src/test/java/config/config.properties");
			prop.setProperty("result", "pass");
			prop.store(output, null);
			}catch(Exception exp) {
				System.out.println("i am inside catch block");
				System.out.println("message is : "+exp.getMessage());
				System.out.println("cause is : "+exp.getCause());
				exp.printStackTrace();
	}
		}

}
