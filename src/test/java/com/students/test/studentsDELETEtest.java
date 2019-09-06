package com.students.test;

import static com.jayway.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

public class studentsDELETEtest {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://localhost";
		RestAssured.port=8080;
		RestAssured.basePath="/student";
	}
	
	@Test
	public void DeleteStudent() {
		given()
		.when()
		.delete("/104")
		.then()
		.statusCode(204);
	}
}
