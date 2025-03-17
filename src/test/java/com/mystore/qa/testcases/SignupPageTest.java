package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.IndexPage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.MyAccountPage;
import com.mystore.qa.pages.SignupPage;
import com.mystore.qa.util.RandomNo;

public class SignupPageTest extends TestBase{
	
	IndexPage indexPage;
	SignupPage signupPage;
	MyAccountPage accountPage;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		indexPage = new IndexPage();
		signupPage = indexPage.clickOnCreateAccountBtn();
	}
	
	@Test(priority = 1)
	public void signupPageValidationTest() {
		String signupPageTitleHeader = signupPage.validateSignupPageTitle();
		String signupPageTitle = driver.getTitle();
		
		Assert.assertEquals(signupPageTitle, "Create New Customer Account");
		Assert.assertEquals(signupPageTitleHeader, "Create New Customer Account");
	}
	
	@Test(priority = 2)
	public void createNewAccountTest() {
		String email =  "sauravkr"+RandomNo.generateRandomNo()+"@gmail.com";
		accountPage = signupPage.createAcount("Saurav", "Gupta", email, "Sk@98765432", "Sk@98765432");
		Assert.assertEquals(accountPage.validateSuccessMessage(), "Thank you for registering with Main Website Store.");
		Assert.assertEquals(accountPage.validateWelcomeTxt(), "Welcome, Saurav Gupta!");
		loginPage = accountPage.signOut();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
