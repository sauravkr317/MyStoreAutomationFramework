package com.mystore.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.util.Webdriverwait;

public class ProductLandingPage extends TestBase{
	
	@FindBy(xpath = "//h1[@class=\"page-title\"]/span")
	WebElement productName;
	
	@FindBy(xpath = "(//div[contains(@class, \"swatch-attribute-options\")])[1]")
	WebElement productSize;
	
	@FindBy(xpath = "(//div[contains(@class, \"swatch-attribute-options\")])[1]/div")
	private List<WebElement> productSizeOption;
	
	@FindBy(xpath = "(//div[contains(@class, \"swatch-attribute-options\")])[2]")
	WebElement productColor;
	
	@FindBy(xpath = "(//div[contains(@class, \"swatch-attribute-options\")])[2]/div")
	private List<WebElement> productColorOption;
	
	@FindBy(xpath = "//div[@role=\"alert\" and @class=\"messages\"]")
	WebElement addToCartSuccessMsg;
	
	@FindBy(id = "qty")
	WebElement quantity;
	
	@FindBy(id = "product-addtocart-button")
	WebElement addToCartBtn;
	
	@FindBy(xpath = "//a[@class=\"action showcart\"]")
	WebElement showCartBtn;
	
	@FindBy(id = "top-cart-btn-checkout")
	WebElement proceedToCheckoutBtn;
	
	public String validateProductName() {
		return productName.getText();
	}
	
	public void selectProductSize(String size) {
		if(productSize.isDisplayed()) {
			for(WebElement ele : productSizeOption) {
				String s = ele.getText();
				if(size.toLowerCase().equals(s.toLowerCase())) {
					ele.click();
					return;
				}
			}
		}
	}
	
	public void selectProductColor(String color) {
		if(productColor.isDisplayed()) {
			for(WebElement ele : productColorOption) {
				@SuppressWarnings("deprecation")
				String c = ele.getAttribute("aria-label");
				if(color.toLowerCase().equals(c.toLowerCase())) {
					ele.click();
					return;
				}
			}
		}
	}
	
	public void selectProductQuantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}
	
	public boolean AddToCart() {
		addToCartBtn.click();
		Webdriverwait.waitForElementToBeVisible(addToCartSuccessMsg, 10);
		return addToCartSuccessMsg.isDisplayed();
	}
	
	public CheckoutPage ClickproceedToCheckoutBtn() {
		showCartBtn.click();
		proceedToCheckoutBtn.click();
		return new CheckoutPage();
	}
	
	
	public ProductLandingPage() {
		PageFactory.initElements(driver, this);
	}

}
