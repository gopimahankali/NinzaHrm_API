package com.Ninza.Hrm.api.employeeTest;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ninza.Hrm.api.BaseTest.NinzaHrmBaseClass;
import com.Ninza.Hrm.api.POMclass.DashBoard_Module;
import com.Ninza.Hrm.api.POMclass.Employees_Module;
import com.Ninza.Hrm.api.pojoClass.Employee_Pojo;
import com.Ninza.Hrm.api.projectTest.ProjectTest;
import com.Ninza.Hrm.constants.endpoints.Employee_Controller;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EmployeeTest extends NinzaHrmBaseClass {
	
@Test(dependsOnMethods = "com.Ninza.Hrm.api.projectTest.ProjectTest.createProject")
public void AddEmployee() throws Exception {
	String proName = ProjectTest.projectName;
	String proId = ProjectTest.projectId;
	
	System.out.println("Project Name is :"+proName);
	   Employee_Pojo ep = new Employee_Pojo(
               "Manual Tester",
               "12/06/1995",
               "test" + ju.random() + "@gmail.com",
               "User_" + ju.random(),
               3,
               "9912005674",
               proName,
               "Role_Employee",
               "User_" + ju.random()
       );
	
Response resp	= given()
	.contentType(ContentType.JSON)
	.body(ep)
	.post(file.getDataFromPropFile("Uri")+Employee_Controller.createEmployee);
	resp.then()
	.log().all();
	String employeeId = resp.jsonPath().get("employeeId");
	// ---------- UI Validation ----------
	DashBoard_Module dash = new DashBoard_Module(driver);
	Employees_Module emp = new Employees_Module(driver);
	web.explicitWait(driver, dash.getEmployees(), 10);
	dash.getEmployees().click();
	web.explicitWait(driver, emp.getEmployeeId(employeeId, proName), 10);
    String empId = emp.getEmployeeId(employeeId, proName).getText();
     // ---------- Assertion ----------
    resp.then().assertThat().statusCode(201);
	resp.then().time(Matchers.lessThan(3000L));
	resp.then().spec(resSpec);
	String ActMsg = resp.jsonPath().get("msg");
	String ExpecMsg = "Employee Added Successfully";
	// ---------- GUI Validation ----------
	Assert.assertEquals(employeeId, empId, "========Test Failed : Employee ID is not matching========");
	System.out.println("=========Test Passed : Employee ID is matching=========");
	Assert.assertEquals(ExpecMsg, ActMsg, "========Test Failed : Message is not matching========");
	System.out.println("=========Test Passed : Message is matching===========");
	
	
	
}
}
