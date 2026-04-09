package com.Ninza.Hrm.api.WebDriver_Utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
	
	public void explicitWait(WebDriver driver, WebElement element, int seconds) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
