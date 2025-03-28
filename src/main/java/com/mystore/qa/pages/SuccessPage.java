package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.util.Webdriverwait;

public class SuccessPage extends TestBase{
	
	@FindBy(xpath = "//h1[@class=\"page-title\"]/span")
	WebElement placeOrderSuccessHeader;
	
	@FindBy(xpath = "//a[@class=\"order-number\"]/strong")
	WebElement orderNo;
	
	public boolean validateOrderSuccessMsg(String expStr) {
		Webdriverwait.waitForTextToBeVisible(placeOrderSuccessHeader, 10, expStr);
		System.out.println(placeOrderSuccessHeader.getText());
		return placeOrderSuccessHeader.getText().equals(expStr);
	}
	
	public boolean validateOrderID() {
		String orderID = orderNo.getText();
		System.out.println(orderID);
		if(orderID.length() == 9) {
			return true;
		}
		
		return false;
	}
	
	public SuccessPage() {
		PageFactory.initElements(driver, this);
	}

}
