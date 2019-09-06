package com.student.loggingexamples;

import com.student.base.TestBase;
import com.student.model.student;
import com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;

import org.hamcrest.Matchers.*;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;


public class loggingRequestTest extends TestBase{

	/*
	 * To print all the Headers
	 */
	@Test
	public void test001() {
		System.out.println("********PRINT HEADERS*********");
		given()
		.log().headers() //header print
		.when().get("/1")
		.then()
		.statusCode(200);
	}
	/*
	 * TO Print all the Parameters
	 */
	@Test
	public void test002() {
		System.out.println("************PARAMETERS PRINT************");
		given()
		.param("programme", "Financial Analysis")
		.param("limit", 1)
		.log()
		.params() //to print parameters
		.when()
		.get("/list")
		.then()
		.statusCode(200);
	}
	
	/*
	 * TO print the Body
	 */
	@Test
	public void test003() {
		System.out.println("***********PRINT REQUEST BODY********** ");
		ArrayList<String> courses=new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		student student =new student();
		student.setFirstName("Nanda");
		student.setLastName("Kumar");
		student.setEmail("nnk@test.com"); // setting up the BODY for POST
		student.setProgramme("IT");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.log()
		.body()
		.body(student)
		.post()
		.then();
		
		
	}
	
	/*
	 * TO print the all the request Details
	 */
	@Test
	public void test004() {
		System.out.println("***********PRINT ALL REQUEST DETAILS********** ");
		ArrayList<String> courses=new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		student student =new student();
		student.setFirstName("Nanda");
		student.setLastName("Kumar");
		student.setEmail("nnk@test.com"); // setting up the BODY for POST
		student.setProgramme("IT");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.log()
		.all() //all prints all request details
		.body(student)
		.post()
		.then();
		
	}
	
	/*
	 * TO print the all the request Details only if validation fails
	 */
	@Test
	public void test005() {
		System.out.println("***********PRINT only if validation fails********** ");
		ArrayList<String> courses=new ArrayList<String>();
		courses.add("JAVA");
		courses.add("C++");
		
		student student =new student();
		student.setFirstName("Nanda");
		student.setLastName("Kumar");
		student.setEmail("nnk@test.com"); // setting up the BODY for POST
		student.setProgramme("IT");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.log()
		.ifValidationFails() //****
		.body(student)
		.post()
		.then()
		.statusCode(201); //201 is when a new request is created, this will fail as in the above test already the User is created
		
	}
	
}
