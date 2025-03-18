package com.mystore.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\mystore\\qa\\config\\config.properties");
			prop.load(fis);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		logger = LogManager.getLogger(TestBase.class);
		String browser = prop.getProperty("browser").toLowerCase().strip();
		System.out.println(browser);
		
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		
		case "edge":
			WebDriverManager.iedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
	}
	
	//To capture screenshorts
	public void failed(File screenshortFile) {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, screenshortFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
