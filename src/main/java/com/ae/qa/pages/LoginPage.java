package com.ae.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ae.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory
	@FindBy(xpath="//input[@id='uname']")
	WebElement username;
	@FindBy(xpath="//input[@id='pswd']")
	WebElement password;
	@FindBy(xpath="//button[@id='signin']")
	WebElement signInBtn;
	@FindBy(xpath="//span[contains(text(),'Forgot')]")
	WebElement forgotPwsdLink;
	@FindBy(xpath="//title")
	WebElement pageTitle;
	
	//initialize all this Object Repositary
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	//Actions
	public String validateLogInPageTitle(){
		return driver.getTitle();
	}
	//return type is object of TenantPage
	public TenantsPage login(String un,String pswd) {
	username.sendKeys(un);
	password.sendKeys(pswd);
	signInBtn.click();
	return new TenantsPage();
	
	}

}
