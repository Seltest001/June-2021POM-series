package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public static String highlight;
	private OptionsManager optionsManager;
	
	 /** 
	 * This method is used to initialize the driver
	 * @param browserName
	 * @return
	 */
	
	public WebDriver initDriver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		highlight = prop.getProperty("highlight");
		
		System.out.println("browser name is : "+ browserName);
		optionsManager = new OptionsManager(prop);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());			
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();			
		}
		else {
			System.out.println("please pass the correct browser : " +browserName);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
	    return driver;	    
	}
	
	 /**
	 * This method is used to initialize the properties 
	 * on the basis of given env name
	 * @return
	 */
	
	public Properties initProperties() {
		Properties prop = null;
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop = new Properties();
			prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}

}
