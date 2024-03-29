package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductInfoTest extends BaseTest {
	
	@BeforeClass
	public void productInfoPageSetup() {
		accPage = loginPage1.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test
	public void productImagesTest() {
		accPage.doSearch("iMac");
		productInfoPage = resultsPage.selectProduct("iMac");
		productInfoPage.getProductImagesCount();
		Assert.assertEquals(productInfoPage.getProductImagesCount(), 3);

	}
	
	@Test
	public void productInfoTest() {
		resultsPage = accPage.doSearch("Macbook");
		productInfoPage = resultsPage.selectProduct("MacBook Pro");
		Map<String, String> actProductInfoMap = productInfoPage.getProductInfo();

		Assert.assertEquals(actProductInfoMap.get("name"), "MacBook Pro");
		Assert.assertEquals(actProductInfoMap.get("Brand"), "Apple");
		Assert.assertEquals(actProductInfoMap.get("Product Code"), "Product 18");
		Assert.assertEquals(actProductInfoMap.get("price"), "$2,000.00");
	}

}
