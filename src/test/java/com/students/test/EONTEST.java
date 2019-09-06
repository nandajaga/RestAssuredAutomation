package com.students.test;

import static com.jayway.restassured.RestAssured.given;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.jayway.restassured.http.ContentType;
public class EONTEST {
//HashMap<String,String> values=
	@Test
	public void test00EON() throws ParseException {
		
		String orderNo="1106518";
		String body="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<updateCCD>\r\n" + 
				"<orderNo>"+orderNo+"</orderNo>\r\n" + 
				"<itemNo>23</itemNo>\r\n" + 
				"<userId>U1160925</userId>\r\n" + 
				"<ccdDate>2019-08-20 20:07:76</ccdDate>\r\n" + 
				"</updateCCD>";
		given().contentType(ContentType.XML).body(body).put("http://qa4-eon.level3.com/eon/rest/services/Application/v1/Eon/orderUpdate/updateCCD")
		.then().statusCode(200);
		
		String ccd="2019-08-20";
		
		Date DF = new Date();
		DateFormat FromDF = new SimpleDateFormat("yyyy-MM-dd");
		FromDF.setLenient(false); // this is important!
		Date FromDate = FromDF.parse(ccd); // "08/01/19"
		String dateStringFrom = new SimpleDateFormat("dd MMM yyyy").format(FromDate);
		//System.out.println(dateStringFrom);
	}
	
	

	
	//@Test
	public void test001() throws ParseException {
		/*System.out.println("********PRINT HEADERS*********");
		given().contentType(ContentType.JSON)
		.log().headers() //header print
		.when().get("http://qa4-eon.level3.com/eon/rest/services/autoorder/getDetailsbyOrderItem?orderItem=1106392/2")
		.then()
		.statusCode(200);*/
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 4); // +days
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
	
		// Now format the date
		 String ccd = dateFormat.format(cal.getTime());
         System.out.println("date " +ccd);		
         String s=  Dateconverter(ccd);
         
        DateFormat FromDF = new SimpleDateFormat("yyyy-MM-dd");
 		FromDF.setLenient(false); // this is important!
 		Date FromDate = FromDF.parse(s); // "08/01/19"
 		String dateStringFrom = new SimpleDateFormat("dd MMM yyyy").format(FromDate);
 		System.out.println(dateStringFrom);
	}
	
	public String Dateconverter(String Date) throws ParseException {
		Date DF = new Date();
		DateFormat FromDF = new SimpleDateFormat("MM/dd/yy");
		FromDF.setLenient(false); // this is important!
		Date FromDate = FromDF.parse(Date); // "08/01/19"
		String dateStringFrom = new SimpleDateFormat("yyyy-MM-dd").format(FromDate);
		System.out.println(dateStringFrom);
	   	return dateStringFrom;
	}
	
	@Test
	public void Datetype() throws ParseException {//Getting future Date
		String Order_Item="1106542 / 1";
		String s[]=Order_Item.split("/");
		System.out.println(s[0]);
		System.out.println(s[1]);
		System.out.println(s[0]+s[1]);
	}
}
