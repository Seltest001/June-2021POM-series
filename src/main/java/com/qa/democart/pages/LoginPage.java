package com.qa.democart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	

	// private By locators:
	private By emailId  = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
	private By header = By.xpath("//div[@id='logo']//a");

	// constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;		
	}
	
	// page actions:page actions/page methods will be always public
	// because this will define the behavior of the page.
	// or behavior of the application or behavior of the specific
	// page, functionality of the page.NO ASSERTIONS. page class
	// is not responsible for assertions.It's TestNG's responsibility
	

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public String getpageHeaderText() {
		return driver.findElement(header).getText();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void doLogin(String un, String pwd) {
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	}

}
