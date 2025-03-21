package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class ProductLandingPage extends TestBase{
	
	@FindBy(xpath = "//h1[@class=\"page-title\"]/span")
	WebElement productName;
	
	public String validateProductName() {
		return productName.getText();
	}
	
	public ProductLandingPage() {
		PageFactory.initElements(driver, this);
	}

}
