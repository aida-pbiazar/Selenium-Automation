package com.google.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;

import com.google.utils.DriverUtil;

/**
 * The class has all methods needed for test initialization
 * @author aida
 */
public class BaseTest {
	
	protected DriverUtil driverUtil;
	WebDriver drv;
	private static final Properties properties = new Properties();

	@BeforeMethod(alwaysRun = true, enabled = true)
	public void setup() throws Exception {
		try {

			String exePath = "src//test//resources//chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			 drv = new ChromeDriver();
			driverUtil = new DriverUtil(drv);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * the method initializes the test
	 * @param language passing to the method as a parameter
	 */
	//public WebDriver getDriver() {
	//	return drv;
	//}
	
	public void initializeTest(String language) throws Exception {
		try {
			  initProperties(language);
			  driverUtil.goToUrl(getUrl());
//drv.get(url);
			driverUtil.maximizeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * the method gets the url specified in dev.peroperties file under property src folder of the project
	 */
	private String getUrl() {
		ResourceBundle resource = ResourceBundle.getBundle(getEnvironment());
		return resource.getString("googleUrl");
	}

	private String getEnvironment() {
		String environment;	
			environment = System.getProperty("environment");		
		return environment;
	}
	
	 public void initProperties(String language) {
	     if (language.contains("en")) loadProperties("english.properties");
	    }
	 /**
	  * the method loads the property files  under source folder of the project for verifying texts in tests
	  */
	    private void loadProperties(String filePropertyName) {
	        try (InputStream input = ClassLoader.getSystemResourceAsStream(filePropertyName)) {
	        	properties.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	
	        }
	    }
	    
	    public String getValue(String key) {
	        return properties.getProperty(key);
	    } 	
}
