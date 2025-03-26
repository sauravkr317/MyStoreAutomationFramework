package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.util.Webdriverwait;

public class CheckoutPage extends TestBase{
	
	@FindBy(xpath = "//button[contains(@class, \"action-show-popup\")]")
	WebElement newAddressBtn;
	
	@FindBy(xpath = "//input[contains(@name, \"ko_unique_\")]")
	WebElement shippingBtn;
	
	@FindBy(xpath = "//button[contains(@class, \"continue\")]")
	WebElement nextBtn;
	
	@FindBy(name = "company")
	WebElement companyInputFeild;
	
	@FindBy(name = "street[0]")
	WebElement addressInputField;
	
	@FindBy(name = "city")
	WebElement cityInputField;
	
	@FindBy(name = "region_id")
	WebElement stateField;
	
	@FindBy(name = "postcode")
	WebElement zipcodeInputField;
	
	@FindBy(name = "country_id")
	WebElement countryField;
	
	@FindBy(name = "telephone")
	WebElement phoneInputField;
	
	@FindBy(id = "shipping-save-in-address-book")
	WebElement saveAddressCheckbox;
	
	@FindBy(css = "button.action-save-address")
	WebElement shipHereBtn;
	
	public void clickOnNewAddress() {
//		Webdriverwait.waitForElementToBeClickable(newAddressBtn, 30);
		newAddressBtn.click();
	}
	
	public boolean addNewAddress(String company, String address, String city, String state, String zip, String country, String phoneNo) {
//		Webdriverwait.waitForElementToBeClickable(companyInputFeild, 30);
		companyInputFeild.sendKeys(company);
		addressInputField.sendKeys(address);
		cityInputField.sendKeys(city);
		phoneInputField.sendKeys(phoneNo);
		
		Select select2 = new Select(countryField);
		select2.selectByVisibleText(country);
		
		Select select1 = new Select(stateField);
		select1.selectByVisibleText(state);
		
		zipcodeInputField.sendKeys(zip);
		
		if(saveAddressCheckbox.isSelected()) {
			saveAddressCheckbox.click();
		}
		
		shipHereBtn.click();
		return true;
	}
	
	public boolean proceedToCheckout() {
		if(!shippingBtn.isSelected()) {
			shippingBtn.click();
		}
		
		nextBtn.click();
		return true;
	}
	
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

}
