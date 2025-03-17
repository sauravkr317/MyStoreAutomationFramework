package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class IndexPage extends TestBase{
	
	//Page Factory - OR
	@FindBy(className = "logo")
	WebElement logo;
	
	@FindBy(xpath = "//h1[@class='page-title']/span")
	WebElement pageTileHeader;
	
	@FindBy(xpath = "(//li[@class=\"authorization-link\"])[1]/a[normalize-space(text())=\"Sign In\"]")
	WebElement signInBtn;
	
	@FindBy(xpath = "(//a[text()=\"Create an Account\"])[1]")
	WebElement createAccountBtn;
	
	
	//Methods
	public boolean validateWebsiteLogo() {
		return logo.isDisplayed();
	}
	
	public String validatePageTitleHeader() {
		return pageTileHeader.getText();
	}
	
	public LoginPage clickOnSignInBtn() {
		signInBtn.click();
		return new LoginPage();
	}
	
	public SignupPage clickOnCreateAccountBtn() {
		createAccountBtn.click();
		return new SignupPage();
	}
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	//Initializing page objects
	public IndexPage(){
		PageFactory.initElements(driver, this);
	}
}
