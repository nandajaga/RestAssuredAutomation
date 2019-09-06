package com.jsonpath.examples;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.RestAssured.*;

import org.hamcrest.Matchers.*;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;

// JSON Querying and extracting data from JSON response
public class SearchJsonPathExamples {

	
	// To better understand the things below first check the rest response
	static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
	@BeforeClass
	public static void init() {
		// URL: http://api.walmartlabs.com/v1/search?query=ipod&format=json&apikey=75e3u4sgb2khg673cbv2gjup
		// online JSON viewer http://jsonviewer.stack.hu/
		
		RestAssured.baseURI="http://api.walmartlabs.com";
		RestAssured.basePath="/v1";
	}
	
	// Extract NumItems value from response body
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
	}
	
	// Extract query value from response body
	@Test
	public void test002() {
		String query=given()
		.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
		.param("apikey", APIKEY)
		.param("format", "json")
		.when()
		.get("/search")
		.then()
		.extract().path("query");  //from API response numItem is interger 
		System.out.println("query: "+query);
	}
	
	//To get First item name
	@Test
	public void test003() {
		String itemname=given()
		.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
		.param("apikey", APIKEY)
		.param("format", "json")
		.when()
		.get("/search")
		.then()
		.extract().path("items[0].name");   
		System.out.println("itemname: "+itemname);
	}
	//Print out the first gift items- Hashmap
	@Test
	public void test004() {
		HashMap<String,String> giftOptions=given()
		.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
		.param("apikey", APIKEY)
		.param("format", "json")
		.when()
		.get("/search")
		.then()
		.extract().path("items[0].giftOptions");  //from API response giftOptions is Hashmap 
		System.out.println("giftOptions: "+giftOptions);
	}
	
	//Print size of the items
		@Test
		public void test005() {
			int itemsSize=given()
			.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
			.param("apikey", APIKEY)
			.param("format", "json")
			.when()
			.get("/search")
			.then()
			.extract().path("items.size()");  //from API response giftOptions is Hashmap 
			System.out.println("itemsSize: "+itemsSize);
		}
		
		//Print all the names under the items
		@Test
		public void test006() {
			List<String> names=given()
			.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
			.param("apikey", APIKEY)
			.param("format", "json")
			.when()
			.get("/search")
			.then().extract().path("items.name");  //from API response to store all names use list
			System.out.println("names: "+names);
		}		
	
		//Print all the values that name==Apple iPod touch 32GB
				@Test
				public void test007() {
					List<HashMap<String,Object>> values=given()
					.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
					.param("apikey", APIKEY)
					.param("format", "json")
					.when()
					.get("/search")
					.then().extract().path("items.findAll{it.name=='Apple iPod touch 32GB'}");  //can have one or multiple values
					System.out.println("The values that name==Apple iPod touch 32GB: "+values);
				}
				
				//Get the sale price for name==Apple iPod touch 32GB
				@Test
				public void test008() {
					List<Float> salePrice=given()
					.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
					.param("apikey", APIKEY)
					.param("format", "json")
					.when()
					.get("/search")
					.then().extract().path("items.findAll{it.name=='Apple iPod touch 32GB'}.salePrice");  //can have one or multiple values
					System.out.println("salePrice values for name==Apple iPod touch 32GB: "+salePrice);
				}		
				
				//Get the Names which has sale price<150
				@Test
				public void test009() {
					List<String> salePrice150=given()
					.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
					.param("apikey", APIKEY)
					.param("format", "json")
					.when()
					.get("/search")
					.then().extract().path("items.findAll{it.salePrice<150}.name");  //can have one or multiple values
					System.out.println("salePrice<150: "+salePrice150);
			
				}			
		
				
				//Get the 'msrp' values for items for which name starts with 'Ref'
				@Test
				public void test010() {
					List<String> msrpvalues=given()
					.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
					.param("apikey", APIKEY)
					.param("format", "json")
					.when()
					.get("/search")
					.then().extract().path("items.findAll{it.name==~/Ref.*/}.msrp");  //can have one or multiple values
					System.out.println("msrpvalues: "+msrpvalues);
				}


				//Get the 'Sale price' values for items  whose name ends with 'ed'
				@Test
				public void test011() {
					List<String> Saleprice=given()
					.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
					.param("apikey", APIKEY)
					.param("format", "json")
					.when()
					.get("/search")
					.then().extract().path("items.findAll{it.name==~/.*ed/}.salePrice");  //can have one or multiple values
					System.out.println("'Sale price' values for items  whose name ends with 'ed': "+Saleprice);
				}	
}


