package com.students.test;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;

import org.hamcrest.Matchers.*;
import com.jayway.restassured.response.Response;
import com.student.model.student;

public class studentsPOSTtest {

	//POST is used to create/add a new response body/new item
	@BeforeClass
	public static void init() {
		/*
		 * Add these static imports
		 * import org.hamcrest.Matchers.*;
			import com.jayway.restassured.response.Response;
		 */
		
		//REST URL: http://localhost:8080/student/list
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
	}
	
	@Test
	public void createNewStudent() {
		
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
		.body(student)
		.post()
		.then()
		.statusCode(201); //201 is when a new request is created
		
	}
}
