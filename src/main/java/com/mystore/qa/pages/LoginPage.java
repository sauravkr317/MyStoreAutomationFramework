package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id = "email")
	WebElement emailTxtBox;
	
	@FindBy(id = "pass")
	WebElement pwdTxtBox;
	
	@FindBy(id = "send2")
	WebElement loginBtn;
	
	@FindBy(xpath = "//h1[@class=\"page-title\"]/span")
	WebElement loginPageHeader;
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public String validateLoginPageHeader() {
		return loginPageHeader.getText();
	}
	
	public HomePage login(String email, String pwd) {
		emailTxtBox.sendKeys(email);
		pwdTxtBox.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
}
