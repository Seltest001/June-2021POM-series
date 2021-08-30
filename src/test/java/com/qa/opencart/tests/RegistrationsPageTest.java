package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationsPageTest extends BaseTest {

	@BeforeClass
	public void regSetup() {
		regPage = loginPage1.navigateToRegisterPage();

	}
	
	public String getRandomEmail() {
		Random random =   new Random();
		String email = "testautomation" + random.nextInt(5000) +"@gmail.com";
		System.out.println(email);
		return email;
	}
	
	@DataProvider
	public Object [] [] getRegTestData() {
		return new Object [] [] {
			{"bhoomika","patel","9182345667","bhoomi@123","yes"},
			{"Tom","Peter","9090808090","tom@123","no"},
			{"Lisa","qa","9282928292","lisa@123","yes"},};			
			
		}
	
//	@DataProvider
//	public Object [] [] getRegTestData() {
//		return new Object [] [] {
//			{"bhoomika","patel","bhoomika101@gmail.com","9182345667","bhoomi@123","yes"},
//			{"Tom","Peter","tomqq@gmail818.com","9090808090","tom@123","no"},
//			{"Lisa","qa","lisaqa123@gmail270.com","9282928292","lisa@123","yes"},};			
//			
//		}
	
//	@Test ==> this data is only for 1 user, 
//       	  for multiple users we have to use data provider
	
//	public void registrationTest(String firstName,String lastName,String email,
//			                     String telephone,String password,String subscribe) {
//		
//		Assert.assertTrue(regPage.accountRegistration("bhumika122",  
//				                                      "patel", 
//				                                      "bhumika10@gmail.com", 
//				                                      "1234567890", 
//				                                      "bhumika@123", 
//				                                      "yes"));
		
//	}
	
//		@Test(dataProvider = "getRegTestData")
//		public void registrationTest(String firstName, 
//				                     String lastName, 
//				                     String email,        
//				                     String telephone, 
//				                     String password,
//				                     String subscribe) {
//
//			Assert.assertTrue(regPage.accountRegistration(firstName, lastName, email, telephone, password, subscribe));
//		}
	
		@Test(dataProvider = "getRegTestData")
		public void registrationTest(String firstName, String lastName, String telephone, String password,
				String subscribe) {

			Assert.assertTrue(
					regPage.accountRegistration(firstName, lastName, getRandomEmail(), telephone, password, subscribe));
		}

	}
