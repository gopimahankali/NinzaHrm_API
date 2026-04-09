package com.Ninza.Hrm.api.POMclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Module {
	WebDriver driver;

	public Login_Module(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id = "inputPassword")
	private WebElement password;
	
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement login;


	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}
	
	
}
