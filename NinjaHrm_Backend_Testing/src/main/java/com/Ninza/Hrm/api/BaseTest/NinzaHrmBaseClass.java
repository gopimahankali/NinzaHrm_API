 package com.Ninza.Hrm.api.BaseTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Ninza.Hrm.api.DataBase_Utility.DataBase_Utility;
import com.Ninza.Hrm.api.File_Utility.PropertyFile;
import com.Ninza.Hrm.api.Java_Utility.Java_Utility;
import com.Ninza.Hrm.api.POMclass.DashBoard_Module;
import com.Ninza.Hrm.api.POMclass.Login_Module;
import com.Ninza.Hrm.api.WebDriver_Utility.WebDriver_Utility;
import com.Ninza.Hrm.api.pojoClass.Project_Pojo;
import com.Ninza.Hrm.constants.endpoints.Project_Controller;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class NinzaHrmBaseClass {

	protected Java_Utility ju = new Java_Utility();
	protected DataBase_Utility db = new DataBase_Utility();
	protected String ExpecMsg = "Successfully Added";
	protected PropertyFile file = new PropertyFile();
	protected Project_Pojo pojo = new Project_Pojo("Gopi", "Project_Crea_" + ju.random(), "Completed", 0);
	protected WebDriver_Utility web = new WebDriver_Utility();
	protected static ResponseSpecification resSpec;
	protected static RequestSpecification reqSpec;
	protected WebDriver driver = null;

	@BeforeSuite()
	public void DbConnection() throws Exception {
		//db.getConnection();
//		RequestSpecBuilder requestSpec = new RequestSpecBuilder();
		reqSpec= new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri(Project_Controller.basepath).addHeader("", "").build();
//		requestSpec.setBaseUri(Project_Controller.basepath);
//		requestSpec.addHeader("", "");
//	    reqSpec = requestSpec.build();
	    
		 resSpec  = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
//	    responseSpec.expectContentType(ContentType.JSON);
//	    resSpec = responseSpec.build();
	}

	@BeforeClass()
	public void loginToApplication() throws Exception {

		Login_Module login = new Login_Module(driver);
		// Edge browser options
		EdgeOptions options = new EdgeOptions();

		// Chrome browser options
		ChromeOptions opt = new ChromeOptions();

		// Disable password manager popup
		Map<String, Object> set = new HashMap<>();
		set.put("profile.password_manager_leak_detection", false);

		opt.setExperimentalOption("prefs", set);

		// Set browser zoom level
		opt.addArguments("--force-device-scale-factor=0.9");
		opt.addArguments("--high-dpi-support=0.9");

		// Read browser name from properties file
		String browser = file.getDataFromPropFile("Browser");
		

		// Launch browser based on configuration
		if (browser.equalsIgnoreCase("Chrome")) {

			driver = new ChromeDriver(opt);

		} else if (browser.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();

		} else {

			driver = new EdgeDriver(options);
		}
		driver.manage().window().maximize();

	}

	@BeforeMethod()
	public void login() throws Exception {
		Login_Module login = new Login_Module(driver);
		driver.get(file.getDataFromPropFile("Url"));
		login.getUsername().sendKeys(file.getDataFromPropFile("UserName"));
		login.getPassword().sendKeys(file.getDataFromPropFile("password"));
		login.getLogin().click();
	}

	@AfterMethod()
	public void logout() {
		DashBoard_Module dash = new DashBoard_Module(driver);
		dash.getLogout().click();

	}

	@AfterClass()
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite()
	public void closeDbConnection() throws Exception {
		//db.closeConnection();
	}

}
