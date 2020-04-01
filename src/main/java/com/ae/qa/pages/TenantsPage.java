package com.ae.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ae.qa.base.TestBase;

public class TenantsPage extends TestBase {


	@FindBy(xpath="//div/h2[@class='page-title inline-item']")
	WebElement tenantsPageTitle;
	@FindBy(xpath="//button[@name='add-tenant']")
	WebElement addTenantBtn;
	@FindBy(xpath="//input[@id='tenantName']")
	WebElement tenantName;
	@FindBy(xpath="//div[@class='group-form-input']/textarea[@id='description']")
	WebElement descriptionOfTenant;
	@FindBy(xpath="//input[@id='orgCode']")
	WebElement organizationCode;
	@FindBy(xpath="//button[@name='submit']")
	WebElement createBtn;
	@FindBy(xpath="//button[@name='cancel']")
	WebElement cancelBtn;
	
	public TenantsPage() {
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateTenantsPageTitle() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(3000);
		return tenantsPageTitle.getText();
	}
	public void addNewTenants(String tName,String tDescription, String orgCode) {
		addTenantBtn.click();
		tenantName.sendKeys(tName);
		descriptionOfTenant.sendKeys(tDescription);
		organizationCode.sendKeys(orgCode);
		createBtn.click();
	}
}
