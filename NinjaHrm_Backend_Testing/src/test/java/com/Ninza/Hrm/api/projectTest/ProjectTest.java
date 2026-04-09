package com.Ninza.Hrm.api.projectTest;

import org.testng.annotations.Test;
import org.hamcrest.Matchers;
import org.testng.Assert;

import com.Ninza.Hrm.api.BaseTest.NinzaHrmBaseClass;
import com.Ninza.Hrm.api.POMclass.DashBoard_Module;
import com.Ninza.Hrm.api.POMclass.Projects_Module;
import com.Ninza.Hrm.constants.endpoints.Project_Controller;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ProjectTest extends NinzaHrmBaseClass {

	public static String projectName;
	public static String projectId;

	@Test
	public void createProject() throws Exception {
		
		System.out.println("my Uri is :"+file.getDataFromPropFile("Uri")+Project_Controller.addProject);
	
		Response response = given()
				.spec(reqSpec)
				.body(pojo)
				.when()
				.post(Project_Controller.addProject);
		response.then().log().all();
		 projectName = response.jsonPath().get("projectName");
		 projectId = response.jsonPath().get("projectId");
		String status = response.jsonPath().get("status");
		
		 // ---------- UI ----------
        DashBoard_Module dash = new DashBoard_Module(driver);
        Projects_Module pm = new Projects_Module(driver);
		web.explicitWait(driver, dash.getProjects(), 10);
		dash.getProjects().click();
		web.explicitWait(driver, pm.getProjectStatus(projectId), 10);
        String uiStatus = pm.getProjectStatus(projectId).getText();
        
        // ---------- Assertion ----------
		response.then().assertThat().statusCode(201);
		response.then().time(Matchers.lessThan(3000L));
		response.then().spec(resSpec);
		String ActMsg = response.jsonPath().get("msg");
		
		// ---------- Gui Validation ----------
		Assert.assertEquals(ExpecMsg, ActMsg, "========Test Failed : Message is not matching========");
		System.out.println("=========Test Passed : Message is matching=========");
		Assert.assertEquals(status, uiStatus, "========Test Failed : Status is not matching========");
		System.out.println("=========Test Passed : Status is matching===========");
		
		// ---------- Database Validation ---------
		
	}
	@Test(dependsOnMethods = "createProject")
		public void createDuplicateProject() throws Exception {
		
			Response response = given()
					.spec(reqSpec)
					.body(pojo)
					.when()
					.post(Project_Controller.addProject);
			response.then().log().all();
			 String ActMsg = response.jsonPath().get("message");
			 String expMsg = "The Project Name :"+projectName+" Already Exists";
			 
			 // ---------- Assertion ----------
			 response.then().assertThat().statusCode(409);
			 response.then().time(Matchers.lessThan(3000L));
			 response.then().spec(resSpec);
			 Assert.assertEquals(expMsg, ActMsg, "========Test Failed : Message is not matching========");
			 System.out.println("=========Test Passed : Message is matching=========");
			 
			
		}
}
