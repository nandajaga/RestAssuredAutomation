package com.assertions.examples;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class AssertionExamples {

	// To better understand the things below first check the rest response
		static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
		@BeforeClass
		public static void init() {
			// URL: http://api.walmartlabs.com/v1/search?query=ipod&format=json&apikey=75e3u4sgb2khg673cbv2gjup
			// online JSON viewer http://jsonviewer.stack.hu/
			
			RestAssured.baseURI="http://api.walmartlabs.com";
			RestAssured.basePath="/v1";
		}
		
		// Asserting  NumItems using Junit
		@Test
		public void test001() {
			int numItems=given()
			.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
			.param("apikey", APIKEY)
			.param("format", "json")
			.when()
			.get("/search")
			.then()
			.extract().path("numItems");  //from API response numItem is interger 
			System.out.println("numItems: "+numItems);
			
			assertEquals(10, numItems);
		}	
	// Asserting numItems using Rest Assured method
		@Test
		public void test002() {
			 given()
			.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
			.param("apikey", APIKEY)
			.param("format", "json")
			.when()
			.get("/search")
			.then()
			.body("numItems", equalTo(10)); // equalTo() from Hamcrest MAtcher static import==>import static org.hamcrest.Matchers.*; // Also add hamcrest jar to PM
		}		
	
// verify query 
				@Test
				public void test003() {
					 given()
					.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
					.param("apikey", APIKEY)
					.param("format", "json")
					.when()
					.get("/search")
					.then()
					.body("query", equalToIgnoringCase("IPOD")); // equalTo() static import==>import static org.hamcrest.Matchers.*; // Also add hamcrest jar to PM
				}		
				
			// checking single name in a list 
				@Test
				public void test004() {
					 given()
					.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
					.param("apikey", APIKEY)
					.param("format", "json")
					.when()
					.get("/search")
					.then()
					.body("items.name", hasItem("Apple iPod touch 32GB - Blue (Previous Model)"));
				}		
	
				
				// Asserting multiple names in a list 
					@Test
					public void test005() {
						 given()
						.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
						.param("apikey", APIKEY)
						.param("format", "json")
						.when()
						.get("/search")
						.then()
						.body("items.name", hasItems("Apple iPod touch 32GB - Blue (Previous Model)","Apple iPod shuffle 2GB","Apple iPod nano 16GB (Space Gray)"));
					}	
	//Verify gift options for the first product[checking values inside Map using hasValue()  Example:- allowGiftWrap:true]
					@Test
					public void test006() {
						 given()
						.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
						.param("apikey", APIKEY)
						.param("format", "json")
						.when()
						.get("/search")
						.then()
						.body("items[0].giftOptions", hasKey("allowGiftWrap"));
					}

					//Assert both Key and value in Hash Map
					@Test
					public void test007() {
						given()
						.param("query", "ipod")
						.param("apikey", APIKEY)
						.param("format", "json")
						.when()
						.get("/search")
						.then()
						.body("items.findAll{it.name=='Apple iPod shuffle 2GB'}", hasItem(hasEntry("name", "Apple iPod shuffle 2GB")));
					}
							
					//Multiple Assertions in single method
					@Test
					public void test008() {
						given()
						.param("query", "ipod")
						.param("apikey", APIKEY)
						.param("format", "json")
						.when()
						.get("/search")
						.then()
						.body("items.findAll{it.name=='Apple iPod shuffle 2GB'}", hasItem(hasEntry("name", "Apple iPod shuffle 2GB")))
						.body("items.name", hasItem("Apple iPod touch 32GB - Blue (Previous Model)"))
						.body("numItems", equalTo(10))
						.statusCode(200);
						
					}
					//Logical Assertions 
					@Test
					public void test009() {
						given()
						.param("query", "ipod")
						.param("apikey", APIKEY)
						.param("format", "json")
						.when()
						.get("/search")
						.then()
						.body("numItems", equalTo(10))
						.body("numItems", lessThan(11))
						.body("numItems", greaterThanOrEqualTo(10))
						.body("numItems", lessThanOrEqualTo(10))
						.body("numItems", greaterThan(5))
						.statusCode(200);
						
					}										
					
					
}



