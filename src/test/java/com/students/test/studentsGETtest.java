package com.students.test;
import static com.jayway.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import org.hamcrest.Matchers.*;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;

public class studentsGETtest extends TestBase {

	/*@BeforeClass // This is avoided by extending the TestBase class
	public static void init() {
		
		 * Add these static imports
		 * import org.hamcrest.Matchers.*;
			import com.jayway.restassured.response.Response;
		 
		
		//REST URL: http://localhost:8080/student/list
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
		
	}*/
	
	@Test
	public  void studentlistfromAPI() {
		/*
		 * given() // set cookies , add parameters, add auth, setting header info
		 * .when()  // GET, POST, PUT, DELETE
		 * .then()  // validate status code , extract response , extract headers, cookies, extract the body response
		 */
		
		//Get the response body
		Response response=
		given()
		.when().get("/list"); // get() returns 'Response' object type 	
		//System.out.println(response.body().asString());
		//System.out.println(response.body().prettyPrint());

		//Validate the response code
		given()
		.when()
		.get("/list")
		.then().assertThat()
		.statusCode(200);
	}
	
	@Test
	public void getfirstStudentInfo() {
		//http://localhost:8080/student/1
		Response res=given().when().get("/1");
		//System.out.println(res.body().prettyPrint());
		
		given().when().get("/1").then().statusCode(200);
	}
	
	@Test
	public void getStudentsofFinancial_Analysis() {
		
		// http://localhost:8080/student/list?programme=Financial Analysis
		// To get first two students of FA
	Response res=given().when().get("/list?programme=Financial Analysis&limit=2");
	//System.out.println(res.body().prettyPeek());
	
	//The ABove can be written in parameters 
	Response res1=given().param("programme", "Financial Analysis")
					.param("limit", 2)
					.get("/list");
	System.out.println(res1.body().prettyPeek());
	
	given().when().get("/list?programme=Financial Analysis&limit=2").then().statusCode(200);
	
	}
	
	
}
