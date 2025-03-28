package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class ProductsPage extends TestBase{
	
	@FindBy(xpath = "//div[contains(@class, \"products-grid\")]/ol/li[1]")
	WebElement product;
	
	public ProductLandingPage clickOnProduct() {
		product.click();
		System.out.println("clicked on product");
		return new ProductLandingPage();
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public ProductsPage() {
		PageFactory.initElements(driver, this);
	}

}
