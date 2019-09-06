package com.student.loggingexamples;

import com.student.base.TestBase;
import com.student.model.student;
import com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.http.ContentType;

import org.hamcrest.Matchers.*;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;


public class loggingResponseTest extends TestBase{

	
	/*
	 * TO Print out all the RESPONSE Headers	
	 */
	@Test
	public void test001() {
		System.out.println("************Print out all the RESPONSE Headers************");
		given()
		.param("programme", "Financial Analysis")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log() //print response headers . log should be present after then()
		.headers()
		.statusCode(200);
	}
	
	/*
	 * TO Print the Response status line like PROTOCOL AND RESPSONE CODE
	 */
	@Test
	public void test002() {
		System.out.println("************PRINT STATUS LINE like PROTOCOL AND RESPSONE CODE************");
		given()
		.param("programme", "Financial Analysis")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log() //print response headers . log should be present after then()
		.status() // prints Protocol & Status code like 200, 201
		.statusCode(200);
	}
	
	/*
	 * TO Print the body Response
	 */
	@Test
	public void test003() {
		System.out.println("************PRINT Body RESPSONE ************");
		given()
		.param("programme", "Financial Analysis")
		.param("limit", 1)
		.when()
		.get("/list")
		.then()
		.log() //print response headers . log should be present after then()
		.body() // prints Protocol & Status code like 200, 201
		.statusCode(200);
	}
	
	/*
	 * TO Print the body Response when validation fails
	 */
	@Test
	public void test004() {
		System.out.println("************PRINT Body RESPSONE  when validation fails************");
		given()
		.param("programme", "Financial Analysis")
		.param("limit", -1) //-1 is a negative value which fails the test
		.when()
		.get("/list")
		.then()
		.log() //print response headers . log should be present after then()
		.ifError(); // prints Protocol & Status code like 200, 201
	}
	
	
}
