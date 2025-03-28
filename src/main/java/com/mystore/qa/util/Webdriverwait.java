package com.mystore.qa.util;



import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.qa.base.TestBase;

public class Webdriverwait extends TestBase{

	public static WebDriverWait wait;
	
	public static void waitForElementToBeVisible(WebElement ele, int duration) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(ele));
		//wait.until(ExpectedConditions.textToBePresentInElement(ele, "Welcome, Saurav Gupta!"));
	}
	
	public static void waitForTextToBeVisible(WebElement ele, int duration, String text) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
	}
	
	public static WebElement waitForElementToBeClickable(WebElement ele, int duration) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
		return element;
	}
}
