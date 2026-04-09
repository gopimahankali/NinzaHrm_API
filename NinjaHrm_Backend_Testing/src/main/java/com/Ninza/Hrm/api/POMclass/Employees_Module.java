package com.Ninza.Hrm.api.POMclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Employees_Module {
	WebDriver driver;

	public Employees_Module(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	 public WebElement getEmployeeId(String employeeId, String projectName) {
		 String xpath = "//td[text()='" + projectName + "']/preceding-sibling::td[text()='" + employeeId + "']";
	        return driver.findElement(By.xpath(xpath));
	    }
}
