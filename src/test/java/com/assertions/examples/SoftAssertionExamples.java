package com.assertions.examples;

import org.junit.Test;
import com.jayway.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.given;


public class SoftAssertionExamples {

	
	//Example to assert 
	/* {
		    "id": 1,
		    "firstName": "Vernon",
		    "lastName": "Harper",
		    "email": "egestas.rhoncus.Proin@massaQuisqueporttitor.org",
		    "programme": "Financial Analysis",
		    "courses": [
		      "Accounting",
		      "Statistics"
		    ] */
	
	@Test
	public void hardAssertTest() {
		//Hard Assert is something which will stop the execution of the program once the first assertion fails
		given()
		.when()
		.get("http://localhost:8080/student/list/")
		.then()
		.body("[0].firstName", equalTo("Vernonmm")) //making it to fail, so the below lines will not be executed
		.body("[0].lastName", equalTo("Harper"))
		.body("[0].programme", equalTo("Financial Analysis"))
		.statusCode(200);
		
	}
	
	
	@Test
	public void SoftAssertTest() {
		//Soft Assert is something which will execute all the steps and finally displays all the assertion error
		given()
		.when()
		.get("http://localhost:8080/student/list/")
		.then()
		.body("[0].firstName", equalTo("Vernonmm"),
				"[0].lastName", equalTo("Harperrrrr"),
				"[0].programme",equalTo("Financial Analysis")); //making it to fail, so the below lines will not be executed
		;
		
	}
}
