package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.democart.pages.AccountsPage;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.Errors;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage1.getLoginPageTitle();
		System.out.println("lp title is: " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, Errors.TITLE_ERROR_MESSG);
	}

	@Test(priority = 2)
	public void loginPageHeaderTest() {
		String header = loginPage1.getpageHeaderText();
		System.out.println("lp header is : " + header);
		Assert.assertEquals(header, Constants.PAGE_HEADER, Errors.HEADER_ERROR_MESSG);
	}

	@Test(priority = 3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage1.isForgotPwdLinkExist());
	}

	@Test(priority = 4)
	public void loginTest() {
		AccountsPage accPage = loginPage1.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}

}


