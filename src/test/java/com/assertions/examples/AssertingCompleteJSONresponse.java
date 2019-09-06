package com.assertions.examples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import com.jayway.restassured.RestAssured;

import junit.framework.Assert;

public class AssertingCompleteJSONresponse {

	// https://github.com/skyscreamer/JSONassert
	
	//add the below dependency 
	
	/*<dependency>
    <groupId>org.skyscreamer</groupId>
    <artifactId>jsonassert</artifactId>
    <version>1.5.0</version>
<scope>test</scope>
</dependency>*/
	
	@Test
	public void getStudent() throws IOException, JSONException {
		String ExpectedValue= new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"//src//test//resources//"+
				File.separator+"studentlist.txt")));
		
		System.out.println(ExpectedValue);
		String actualValue=RestAssured.given()
				.when()
				.get("http://localhost:8080/student/list/").asString(); //asString() convert JSON response to string	
		System.out.println(actualValue);
		//Assert.assertEquals(ExpectedValue, actualValue);
		JSONAssert.assertEquals(ExpectedValue, actualValue, JSONCompareMode.LENIENT); // LENIENT is preferred 
	}
	
	@Test
	public void getStudentStrict() throws IOException, JSONException {
		String ExpectedValue= new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"//src//test//resources//"+
				File.separator+"studentlist.txt")));
		
		System.out.println(ExpectedValue);
		String actualValue=RestAssured.given()
				.when()
				.get("http://localhost:8080/student/list/").asString(); //asString() convert JSON response to string	
		System.out.println(actualValue);
		//Assert.assertEquals(ExpectedValue, actualValue);
		JSONAssert.assertEquals(ExpectedValue, actualValue, JSONCompareMode.STRICT); //Strict- verifies the order of the response, which is not recommended
	}
	
}
