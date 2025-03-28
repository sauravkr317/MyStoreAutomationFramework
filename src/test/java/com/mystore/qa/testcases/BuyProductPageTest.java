package com.mystore.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.pages.CheckoutPage;
import com.mystore.qa.pages.HomePage;
import com.mystore.qa.pages.IndexPage;
import com.mystore.qa.pages.LoginPage;
import com.mystore.qa.pages.ProductLandingPage;
import com.mystore.qa.pages.ProductsPage;
import com.mystore.qa.pages.SuccessPage;
import com.mystore.qa.testdata.CheckoutPageDataProvider;

public class BuyProductPageTest extends TestBase {

	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	ProductsPage productsPage;
	ProductLandingPage productLandingPage;
	CheckoutPage checkoutPage;
	SuccessPage successPage;

	@BeforeMethod
	public void setUp() {
		initialization();
		indexPage = new IndexPage();
		loginPage = indexPage.clickOnSignInBtn();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test(priority = 1, dataProvider = "testDataProvider2", dataProviderClass = CheckoutPageDataProvider.class)
	public void buyProductTest(String company, String address, String city, String state, String zip, String country,
			String phoneNo) throws InterruptedException {
		String productName = "Tank";
		String productSize = "M";
		String productColor = "Orange";
		String qty = "1";
		productsPage = homePage.searchProduct(productName);
		productLandingPage = productsPage.clickOnProduct();
		System.out.println("product landing page open");
		productLandingPage.selectProductSize(productSize);
		System.out.println("product size is selected");
		productLandingPage.selectProductColor(productColor);
		System.out.println("product color is selected");
		Thread.sleep(2000);
		productLandingPage.selectProductQuantity(qty);
		System.out.println("product qty is selected");
		boolean flag = productLandingPage.AddToCart();
		Assert.assertTrue(flag);

		checkoutPage = productLandingPage.ClickproceedToCheckoutBtn();
		System.out.println("checkout page open");
		Thread.sleep(5000);
		checkoutPage.clickOnNewAddress();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean addAddressFlag = checkoutPage.addNewAddress(company, address, city, state, zip, country, phoneNo);
		System.out.println("new address added");
		Assert.assertTrue(addAddressFlag);

		Thread.sleep(5000);

		boolean proceedToCheckoutFlag = checkoutPage.proceedToCheckout();
		Assert.assertTrue(proceedToCheckoutFlag);
		Thread.sleep(8000);

		successPage = checkoutPage.placeOrder();
		System.out.println("success page open");
		Assert.assertTrue(successPage.validateOrderSuccessMsg("Thank you for your purchase!"));

		Assert.assertTrue(successPage.validateOrderID());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
