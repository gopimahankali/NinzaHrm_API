package com.Ninza.Hrm.api.POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard_Module {
	
		WebDriver driver;

		public DashBoard_Module(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//a[text()='Projects']")
		private WebElement projects;
		
		@FindBy(xpath = "//a[text()='Employees']")
		private WebElement employees;
		
		@FindBy(xpath = "//*[name()='svg' and contains(@class,'fa-right-from-bracket')]")
		private WebElement logout;

		public WebElement getLogout() {
			return logout;
		}

		public WebElement getProjects() {
			return projects;
		}

		public WebElement getEmployees() {
			return employees;
		}
		
		
		
}
