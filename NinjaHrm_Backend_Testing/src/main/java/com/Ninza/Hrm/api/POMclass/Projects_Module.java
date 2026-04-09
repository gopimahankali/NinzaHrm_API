package com.Ninza.Hrm.api.POMclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Projects_Module {
	WebDriver driver;

	public Projects_Module(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 public WebElement getProjectStatus(String projectId) {
	        String xpath = "//td[text()='" + projectId + "']/following-sibling::td[normalize-space()='Completed']";
	        return driver.findElement(By.xpath(xpath));
	    }
}
