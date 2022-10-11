package org.makeMyTrip.pageLayer;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.makeMyTrip.driver.DriverManager;
import org.makeMyTrip.enums.ExplicitWaitExpectedConditions;
import org.makeMyTrip.pageBase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelsSearchResultsWebPage extends BasePage{
	WebDriver driver = DriverManager.getDriver();
	//private By By_hotelName = By.id("Listing_hotel_0");
	private By By_hotelName;/* = By.xpath("//span[text()='Hyatt Place Dubai Baniyas Square']");*/
	/*Implicit wait on webpage*/
//	public HotelsSearchResultsWebPage()
//	{
//		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	}
	
	/*This method will select & open the hotel for booking
	 * handles the new opened tab for hotel booking*/
	public HotelDetailsWebPage selectHotelForBooking(String Str_hotelName)
	{
		setHotelNameDynamicXpath(Str_hotelName);
		click(By_hotelName, ExplicitWaitExpectedConditions.CLICKABLE);
		
		//Iterate over windows by getting id for them
		Iterator<String> windowIds = driver.getWindowHandles().iterator();
		windowIds.next();
		driver.switchTo().window(windowIds.next());
		return new HotelDetailsWebPage();
		
	}
	/*******************Set Dynamic Xpath**********************/
	
	public void setHotelNameDynamicXpath(String Str_hotelName)
	{
		By_hotelName = By.xpath("//span[text()='"+Str_hotelName+"']");
	}
	
	
}


