package com.students.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.junit.Test;

public class Dateconverted {

	
	public static String Dateconverter(String Date) throws ParseException
    {
           //Date DF = new Date();
           DateFormat FromDF = new SimpleDateFormat("MM/dd/yy");
     FromDF.setLenient(false);  // this is important!
     Date FromDate = FromDF.parse(Date);   //"08/01/19"
     String dateStringFrom = new SimpleDateFormat("yyyy-MM-dd").format(FromDate);
    // System.out.println(dateStringFrom);
     return dateStringFrom;
    }
	
	@Test
	public void test() throws ParseException {
		
		Dateconverter("08/01/19");
		String s=null;
		HashMap<String,String> datesonUI= new HashMap<String,String>();
		datesonUI.put("focReceivedDate_Aside", Dateconverter("08/01/19"));
		System.out.println(datesonUI);
	}
}
