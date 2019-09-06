package com.students.test;
import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.student.model.student;

public class studentsPATCHtest {

	// PATCH is used to update single field info
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
		public void updateStudent() {
			
			ArrayList<String> courses=new ArrayList<String>();
			courses.add("JAVA");
			courses.add("C++");
			courses.add("C#");

			student student =new student();
			student.setFirstName("Nanda"); 
			student.setLastName("Kumar");
			student.setEmail("nanda@testing.com");  //updating this
			student.setProgramme("IT");
			student.setCourses(courses);
			
			given()
			.contentType(ContentType.JSON)
			.body(student)
			.patch("/104") //104 is the id of the student for which the update is happened
			.then()
			.statusCode(200); //200 is when a request is updated
			
		}
}
