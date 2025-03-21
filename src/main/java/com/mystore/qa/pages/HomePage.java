package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.util.Webdriverwait;

public class HomePage extends TestBase{
	
	//login username to validate later
	
	@FindBy(xpath = "(//button[@class=\"action switch\"])[1]")
	WebElement menuBtn;
	
	@FindBy(xpath = "(//li[@class=\"authorization-link\"])[1]/a")
	WebElement signoutBtn;
	
	@FindBy(id = "search")
	WebElement searchInput;
	
	@FindBy(xpath = "//button[@type=\"submit\" and @class=\"action search\"]")
	WebElement searchBtn;
	
	public IndexPage signOut() {
		menuBtn.click();
		signoutBtn.click();
		return new IndexPage();
	}
	
	public ProductsPage searchProduct(String product) {
		searchInput.sendKeys(product);
		Webdriverwait.waitForElementToBeClickable(searchBtn, 10);
		searchBtn.click();
		return new ProductsPage();
	}
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
}
