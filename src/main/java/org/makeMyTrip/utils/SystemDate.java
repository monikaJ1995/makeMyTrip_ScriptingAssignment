package org.makeMyTrip.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.makeMyTrip.driver.DriverManager;
import org.makeMyTrip.enums.ExplicitWaitExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SystemDate {
	static Logger log = LogManager.getLogger(SystemDate.class);
	static SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd yyyy");
	static Calendar calendar;

	public static String currentDate()//--method name
	{	//"Oct 13 2022"	
		calendar = Calendar.getInstance();
		Date currentDateTime = calendar.getTime();
		//System.out.println(dateFormatter.format(currentDateTime));
		return dateFormatter.format(currentDateTime);			
	}
	public static String pastDate(int past_daysCnt)
	{
		calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -past_daysCnt);
		Date pastDateTime = calendar.getTime();
		return dateFormatter.format(pastDateTime);
	}
	public static String futureDate(int future_daysCnt)
	{
		calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, future_daysCnt);
		Date futureDateTime = calendar.getTime();
		return dateFormatter.format(futureDateTime);
		
		//System.out.println(dateFormatter.format(futureDateTime));
	}
	
	public static List<WebElement> getDaysOfRequiredMonth(By By_datePickerMonth,By By_nextMonthNavButton,By By_daysOfMonth,String Str_month)
	{
		log.debug("For checkin iterating through the months of year");
		while(!DriverManager.getDriver().findElement(By_datePickerMonth).getText().contains(Str_month))
		{
			DriverManager.getDriver().findElement(By_nextMonthNavButton).click();
			log.debug("Clicked on next month navigation button");
		}
		log.info("Selected checkin month for checkin date");
		return DriverManager.getDriver().findElements(By_daysOfMonth);
	}
	
	public static void main(String[] args) {
//		//CurrentSystemDate a = new CurrentSystemDate();
////		System.out.println("Current Date Time: "+currentDate_Time());
//		System.out.println("Current Date Time: "+currentDate());
		System.out.println("Current Date Time: "+pastDate(3));
//		System.out.println("Current Date Time: "+futureDate(3));
//
//
	}



}
