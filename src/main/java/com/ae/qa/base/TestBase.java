package com.ae.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.message.LoggerNameAwareMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.ae.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = LogManager.getLogger(TestBase.class);
	public TestBase(){
		try 
		{
		prop = new Properties();
		//FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/ae/qa/config/config.properties");
		FileInputStream ip=new FileInputStream("C:\\Users\\Kalyani\\eclipse-workspace\\AutomationEdgePortal\\src\\main\\java\\com\\ae\\qa\\config\\config.properties");
		prop.load(ip);	
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		log.debug("Execution started");
		String browserName = prop.getProperty("browser");
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Kalyani\\eclipse-workspace\\webdrivertraining\\test\\resources\\chromedriver_new.exe");
			driver=new ChromeDriver();
		} 
	   else if(browserName.contentEquals("Firefox")) {
 			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Kalyani\\eclipse-workspace\\webdrivertraining\\test\\resources\\geckodriver-64bit.exe");
			 driver= new FirefoxDriver();
		} 
	   else {
			System.out.println("No browser value is given");
		}
		log.info("Browser started successfully");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//Launch the Url
		driver.get(prop.getProperty("url"));
		log.info("User is navigated to AE portal");
	}
	
	

}
