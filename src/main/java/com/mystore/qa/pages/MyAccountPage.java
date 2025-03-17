package com.mystore.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.qa.base.TestBase;
import com.mystore.qa.util.Webdriverwait;

public class MyAccountPage extends TestBase{
	
	@FindBy(xpath = "(//li[@class=\"greet welcome\"]/span)[1]")
	WebElement welcomeTxt;
	
	@FindBy(xpath = "//div[contains(@class,\"message-success\")]/div")
	WebElement successMessage;
	
	@FindBy(xpath = "(//button[@class=\"action switch\"])[1]")
	WebElement menuBtn;
	
	@FindBy(xpath = "(//li[@class=\"authorization-link\"])[1]/a")
	WebElement signoutBtn;
	
	public String validateWelcomeTxt(){
		Webdriverwait.waitForTextToBeVisible(welcomeTxt, 20, "Welcome, Saurav Gupta!");
		return welcomeTxt.getText();
	}
	
	public String validateSuccessMessage() {
		Webdriverwait.waitForElementToBeVisible(successMessage, 30);
		return successMessage.getText();
	}
	
	public LoginPage signOut() {
		menuBtn.click();
		signoutBtn.click();
		return new LoginPage();
	}
	
	public MyAccountPage(){
		PageFactory.initElements(driver, this);
	}

}
