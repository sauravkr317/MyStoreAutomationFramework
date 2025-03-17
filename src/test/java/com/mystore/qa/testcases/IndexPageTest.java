package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.IndexPage;
import com.mystore.qa.pages.LoginPage;

public class IndexPageTest extends TestBase{
	
	IndexPage indexPage;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		System.out.println("----browser open----");
		indexPage = new IndexPage();
	}
	
	@Test(priority = 1)
	public void indexPageValidationTest() {
		System.out.println("----on index page----");
		Assert.assertTrue(indexPage.validateWebsiteLogo());
		Assert.assertEquals(indexPage.validatePageTitleHeader(), "Home Page");
		Assert.assertEquals(indexPage.validatePageTitle(), "Home Page");
	}
	
	@Test(priority = 2)
	public void clickSiginBtnTest() {	
		loginPage = indexPage.clickOnSignInBtn();
		System.out.println("----clicked on signin btn----");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("----browser closed----");
		driver.quit();
	}
}
