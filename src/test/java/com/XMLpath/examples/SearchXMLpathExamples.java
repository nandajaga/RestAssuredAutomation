package com.XMLpath.examples;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.xml.XmlPath.with;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.internal.path.xml.NodeChildrenImpl;

public class SearchXMLpathExamples {

	// To better understand the things below first check the rest response
		static final String APIKEY="75e3u4sgb2khg673cbv2gjup";
		@BeforeClass
		public static void init() {
			// URL: http://api.walmartlabs.com/v1/search?query=ipod&format=xml&apikey=75e3u4sgb2khg673cbv2gjup
			// online JSON viewer http://jsonviewer.stack.hu/
			
			RestAssured.baseURI="http://api.walmartlabs.com";
			RestAssured.basePath="/v1";
		}
	
		// Extract NumItems value from response body
		@Test
		public void test001() {
			String numItems=given()
			.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
			.param("apikey", APIKEY)
			.param("format", "xml") //response type
			.when()
			.get("/search")
			.then()
			.extract().path("searchresponse.numItems");  //from API response numItem [ root element is searchresponse ] 
			System.out.println("numItems: "+numItems);
			System.out.println("************************** END ***********************");
		}
		
		//Extract the name of the first ITEM
		@Test
		public void test002() {
			String ProductName=given()
			.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
			.param("apikey", APIKEY)
			.param("format", "xml") //response type
			.when()
			.get("/search")
			.then()
			.extract().path("searchresponse.items.item[0].name");  //from API response numItem [ root element is searchresponse ] 
			System.out.println("Product Name: "+ProductName);
			System.out.println("************************** END ***********************");
		}
		
		//Get the giftOptions for the first ITEM
				@Test
				public void test003() {
					String xml=given()
					.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
					.param("apikey", APIKEY)
					.param("format", "xml") //response type
					.when()
					.get("/search").asString();
					
				String giftOptions=with(xml).getString("searchresponse.items.item[0].giftOptions");	//with() from import static com.jayway.restassured.path.xml.XmlPath.*;			
					System.out.println("giftOptions are: "+giftOptions);
					System.out.println("************************** END ***********************");
				}		
		//Get the size of the ITEMS
				@Test
				public void test004() {		
			NodeChildrenImpl val=given()
				.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
				.param("apikey", APIKEY)
				.param("format", "xml") //response type
				.when()
				.get("/search")
				.then()
				.extract().path("searchresponse.items.item");  
			
				System.out.println("Items size: "+val.size());
				System.out.println("************************** END ***********************");
				}
				
	//Extract all the names 
  // with() is used to print all the child items 
				@Test
				public void test005() {
					String xml=given()
					.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
					.param("apikey", APIKEY)
					.param("format", "xml") //response type
					.when()
					.get("/search").asString();
					
				List<String> allnames=with(xml).getList("searchresponse.items.item.name");	//with() from import static com.jayway.restassured.path.xml.XmlPath.*;			
					System.out.println("All Item names: "+allnames);
					System.out.println("************************** END ***********************");
				}	
				
	// Get the sale price of the item where Name==Apple iPod shuffle 2GB
				@Test
				public void test006() {
					String xml=given()
					.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
					.param("apikey", APIKEY)
					.param("format", "xml") //response type
					.when()
					.get("/search").asString();
					
				List<String> allnames=with(xml).getList("searchresponse.items.item.findAll{it.name=='Apple iPod shuffle 2GB'}.salePrice");	//with() from import static com.jayway.restassured.path.xml.XmlPath.*;			
					System.out.println("sale price of the item where Name==Apple iPod shuffle 2GB: "+allnames);
					System.out.println("************************** END ***********************");
				}

				// Deep search in XML to get the sale price of the item where Name==Apple iPod shuffle 2GB
				@Test
				public void test007() {
					String xml=given()
					.param("query", "ipod") //param can be easily figured out in postman api by entering the full rest URL
					.param("apikey", APIKEY)
					.param("format", "xml") //response type
					.when()
					.get("/search").asString();
					
				List<String> allnames=with(xml).getList("**.findAll{it.name=='Apple iPod shuffle 2GB'}.salePrice");	//with() from import static com.jayway.restassured.path.xml.XmlPath.*;			
					System.out.println("sale price of the item where Name==Apple iPod shuffle 2GB: "+allnames);
					System.out.println("************************** END ***********************");
				}
}
