package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.IndexPage;
import com.mystore.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignInBtn();
	}
	
	@Test(priority = 1)
	public void loginPageValidationTest() {
		String loginPageTitle = loginPage.validateLoginPageTitle();
		String loginPageHeader = loginPage.validateLoginPageHeader();
		
		Assert.assertEquals(loginPageTitle, "Customer Login");
		Assert.assertEquals(loginPageHeader, "Customer Login");
	}
	
	@Test(priority = 2)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		homePage.signOut();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
