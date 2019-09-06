package com.student.base;

import org.junit.BeforeClass;

import com.jayway.restassured.RestAssured;
import org.hamcrest.Matchers.*;
import com.jayway.restassured.response.Response;

public class TestBase {

	//This package should be in src/main/java
	
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
	
	
}
