package com.ae.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ae.qa.base.TestBase;
import com.ae.qa.pages.LoginPage;
import com.ae.qa.pages.TenantsPage;
import com.ae.qa.util.TestUtil;

public class TenantsPageTest extends TestBase {
    LoginPage loginpage;
    TenantsPage tenantspage;
    String sheetName="TenantsDetails";

	public TenantsPageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		//all the methods in the login page class are non-static that's why object creation is important.
		loginpage=new LoginPage();	
		tenantspage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		tenantspage=new TenantsPage();
	}

	@Test(priority=1)
	public void validateTenantsPageTitleTest() throws Exception {
	String actual_Title = tenantspage.validateTenantsPageTitle();
	System.out.println(actual_Title);
	Assert.assertEquals(actual_Title, "Tenants","Home Page title not matched");
	log.info("Tenants Page title is validated");
	}
	@DataProvider
	public Object[][] getTenantsTestData() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority=2, dataProvider="getTenantsTestData")
	public void validateAddNewTenant(String tname,String tdescription, String torgcode) {
		tenantspage.addNewTenants(tname,tdescription,torgcode);
		log.info("New Tenant created successfully");
		
	}
	

	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
