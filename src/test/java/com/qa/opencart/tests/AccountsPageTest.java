package com.qa.opencart.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest {
	
	@BeforeClass
	public void accPageSetUp() {
		loginPage1.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void accPageTitleTest() { 
	      String title = accPage.getAccPageTitle();
	      System.out.println("acc page title is: " + title );
	      Assert.assertEquals(title,Constants.ACCOUNT_PAGE_TITLE); 		 			 
	}
	
	@Test(priority=2)
	public void accPageUrlTest() {
	String url = accPage.getAccPageUrl(); 
		Assert.assertEquals(url,Constants.ACCOUNT_PAGE_URL);			
	}
	
	@Test(priority=3)
	public void accPageHeaderTest() {
	String header = accPage.getAccPageHeader(); 
	Assert.assertEquals(header, Constants.PAGE_HEADER);	
	}
	
	@Test(priority=4)
	public void accSectionsListTest() {
	   List<String>actAccSecList = accPage.getAccountSectionsList();
	   System.out.println("actual sections: " + actAccSecList);
	   Assert.assertEquals(actAccSecList, Constants.EXPECTED_ACC_SEC_LIST);		
	}
	
	@Test(priority=5)
	public void logoutLinkExistTest() {
	boolean flag = accPage.isLogoutLinkExist(); 
	Assert.assertEquals(flag, true);	
	}
	
	@DataProvider
	public Object[] [] getSearchData() {
		return new Object [] [] {{"Macbook Pro"},
			                     {"Macbook Air"},
			                     {"iPhone"},
			                     {"Apple"}};
		}
	
	
	@Test(priority=6, dataProvider = "getSearchData")
	public void searchTest(String productName) {
		resultsPage = accPage.doSearch(productName);
		String resultHeader = resultsPage.getSearchPageHeader();
		System.out.println("result header is : " + resultHeader);
		Assert.assertTrue(resultHeader.contains(productName));
		
	}
	
	@DataProvider
	public Object [] [] getProductSelectData() {
		return new Object [] [] {			
			{"Macbook", "MacBook Air"},
			{"Macbook", "MacBook Pro"},
			{"Apple", "Apple Cinema 30\""}
			};
		}
	
	@Test(priority = 6,dataProvider = "getProductSelectData")
	public void selectProductTest(String productName, String mainProductName) {
		resultsPage = accPage.doSearch(productName);
		productInfoPage = resultsPage.selectProduct(mainProductName);
	    String header = productInfoPage.getProductHeaderText();
	    System.out.println("product header :" + header);
	    Assert.assertEquals(header, mainProductName);
	}
	
}
