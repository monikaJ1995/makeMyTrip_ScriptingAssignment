package org.makeMyTrip.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SystemDate {
	
	static SimpleDateFormat dateFormatter;
	static Calendar calendar;

	public static String currentDate()//--method name
	{	//"Oct 13 2022"
		dateFormatter = new SimpleDateFormat("MMM dd yyyy");	
		calendar = Calendar.getInstance();
		Date currentDateTime = calendar.getTime();
		//System.out.println(dateFormatter.format(currentDateTime));
		return dateFormatter.format(currentDateTime);			
	}
	public static String pastDate(int past_daysCnt)
	{
		//Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -past_daysCnt);
		Date pastDateTime = calendar.getTime();
		return dateFormatter.format(pastDateTime);
	}
	public static String futureDate(int future_daysCnt)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, future_daysCnt);
		Date futureDateTime = calendar.getTime();
		return dateFormatter.format(futureDateTime);
		
		//System.out.println(dateFormatter.format(futureDateTime));
	}
//	public static void main(String[] args) {
//		//CurrentSystemDate a = new CurrentSystemDate();
////		System.out.println("Current Date Time: "+currentDate_Time());
//		System.out.println("Current Date Time: "+currentDate());
//		System.out.println("Current Date Time: "+pastDate(3));
//		System.out.println("Current Date Time: "+futureDate(3));
//
//
//	}



}
