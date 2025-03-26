package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.IndexPage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.ProductLandingPage;
import com.mystore.qa.pages.ProductsPage;

public class SearchProductPageTest extends TestBase{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	ProductsPage productsPage;
	ProductLandingPage productLandingPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignInBtn();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test
	public void SearchProductTest() {
		String productName = "bag";
		productsPage = homePage.searchProduct(productName);
		String productsPageTitle = productsPage.validatePageTitle().toLowerCase();
		
		productLandingPage = productsPage.clickOnProduct();
		String actualProductName = productLandingPage.validateProductName().toLowerCase();
		System.out.println(actualProductName);
		Assert.assertTrue(productsPageTitle.contains(productName));
		Assert.assertTrue(actualProductName.contains(productName));	
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
