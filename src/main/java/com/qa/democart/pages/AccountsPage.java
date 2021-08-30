package com.qa.democart.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//private By locators
	private By accSections  = By.cssSelector("div#content h2");	
	private By searchField  = By.xpath("//input[@name='search']");
	private By searchButton = By.cssSelector("div#search button");
	private By logoutLink   = By.linkText("Logout");
	private By headerYS     = By.cssSelector("div#logo h1 a");   
	
	//constructor:
		public AccountsPage(WebDriver driver) {
			this.driver = driver;
			elementUtil = new ElementUtil(driver);
		}
			
	//create page actions	
			
		public String getAccPageTitle() {
			 return elementUtil.waitForTitleIs(Constants.ACCOUNT_PAGE_TITLE, 5);			 
		}
		
		public String getAccPageUrl() {
			return elementUtil.waitForUrlContains(Constants.ACCOUNT_PAGE_URL,5);
		}
		
		public String getAccPageHeader() {
			return elementUtil.doGetText(headerYS);
		}
		
		public List<String> getAccountSectionsList() {
			List<String> accSecValueList = new ArrayList<String>();
			List<WebElement>accSecList = elementUtil.getElements(accSections);
			for(WebElement e : accSecList) {
				accSecValueList.add(e.getText());
			}
			//Collections.sort(accSecValueList);
			return accSecValueList;
			}
		
		public boolean isLogoutLinkExist() {
			return elementUtil.doIsDisplayed(logoutLink);
		}
		
		public ResultsPage doSearch(String productName) {
			System.out.println("searching the product: " + productName);
			elementUtil.doSendKeys(searchField, productName);
			elementUtil.doClick(searchButton);	
			return new ResultsPage(driver);
		}
		
		
		
		
			
			
			
		


}
