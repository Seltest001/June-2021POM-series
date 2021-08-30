package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage1 {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	// private By locators:
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
	private By header = By.xpath("//div[@id='logo']//a");
    
	private By registerLink = By.linkText("Register");
	
	// constructor:
	public LoginPage1(WebDriver driver) {
			this.driver = driver;
			elementUtil = new ElementUtil(driver);			
		}

	public String getLoginPageTitle() {
		return elementUtil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE,5);
    	}
	
	public String getpageHeaderText() {
		return elementUtil.doGetText(header);
	}
	
	public boolean isForgotPwdLinkExist() {
		return elementUtil.doIsDisplayed(forgotPwdLink);
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		elementUtil.doSendKeys(emailId, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		return new AccountsPage(driver);
	}
	
	public RegistrationsPage navigateToRegisterPage() {
		elementUtil.doClick(registerLink);
		return new RegistrationsPage(driver);
	}
	
}