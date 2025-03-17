package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;

public class SignupPage extends TestBase{
	
	@FindBy(xpath = "//h1[@class=\"page-title\"]/span")
	WebElement pageTitleHeader;
	
	@FindBy(id = "firstname")
	WebElement firstNameTxtBox;
	
	@FindBy(id = "lastname")
	WebElement lastNameTxtBox;
	
	@FindBy(id = "email_address")
	WebElement emailTxtBox;
	
	@FindBy(id = "password")
	WebElement pwdTxtBox;
	
	@FindBy(id = "password-confirmation")
	WebElement confirmPwdTxtBox;
	
	@FindBy(xpath = "//button[@title=\"Create an Account\"]")
	WebElement createAccountBtn;
	
	
	public String validateSignupPageTitle() {
		return pageTitleHeader.getText();
	}
	
	public MyAccountPage createAcount(String fname, String lname, String email, String pwd, String cnfpwd) {
		firstNameTxtBox.sendKeys(fname);
		lastNameTxtBox.sendKeys(lname);
		emailTxtBox.sendKeys(email);
		pwdTxtBox.sendKeys(pwd);
		confirmPwdTxtBox.sendKeys(cnfpwd);
		
		createAccountBtn.click();
		return new MyAccountPage();
	}
	
	public SignupPage() {
		PageFactory.initElements(driver, this);
	}
	
	
}
