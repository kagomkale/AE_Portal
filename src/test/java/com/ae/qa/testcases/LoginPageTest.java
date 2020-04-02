package com.ae.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.base.TestBase1;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.TenantsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class LoginPageTest extends TestBase1{
	LoginPage loginpage;
	TenantsPage tenantspage;
	ExtentTest extentTest;
	ExtentReports extent;
	//WebDriver driver;
	//to initialize the prop files in TestBase class
public LoginPageTest() {
		super();
}
	
	/*
	 * @BeforeMethod public void setUp() { initialization(); //all the methods in
	 * the login page class are non-static that's why object creation is important.
	 * loginpage=new LoginPage(); }
	 */
	@Test(priority=1)
	public void loginPageTitleTest() {
		loginpage=new LoginPage();
		//extentTest = extent.createTest("AETitleTest");
		String actual_Title = loginpage.validateLogInPageTitle();
		//String actual_Title=driver.getTitle();
		System.out.println(actual_Title);
		Assert.assertEquals(actual_Title, "AutomationEdge");
		log.info("AE title validated");
		
	}
	/*
	 * @Test(priority=2) public void logInTest() { extentTest =
	 * extent.createTest("AELoginTest");
	 * tenantspage=loginpage.login(prop.getProperty("username"),prop.getProperty(
	 * "password")); log.info("User Login in AE successfully"); }
	 */
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
}
