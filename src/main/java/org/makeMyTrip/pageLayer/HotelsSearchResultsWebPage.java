package org.makeMyTrip.pageLayer;

import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.makeMyTrip.driver.DriverManager;
import org.makeMyTrip.enums.ExplicitWaitExpectedConditions;
import org.makeMyTrip.pageBase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelsSearchResultsWebPage extends BasePage{
	Logger log = LogManager.getLogger(HotelsSearchResultsWebPage.class);
	WebDriver driver = DriverManager.getDriver();
	//private By By_hotelName = By.id("Listing_hotel_0");
	private By By_hotelName;/* = By.xpath("//span[text()='Hyatt Place Dubai Baniyas Square']");*/

	
	/*This method will select & open the hotel for booking
	 * handles the new opened tab for hotel booking*/
	public HotelDetailsWebPage selectHotelForBooking(String Str_hotelName)
	{
		setHotelNameDynamicXpath(Str_hotelName);
		click(By_hotelName, ExplicitWaitExpectedConditions.CLICKABLE);
		log.info("Clicked on hotel for booking");
		//Iterate over windows by getting id for them
		Iterator<String> windowIds = driver.getWindowHandles().iterator();
		log.debug("Getting window ids for all opened windows");
		windowIds.next();
		driver.switchTo().window(windowIds.next());
		log.debug("Switched to child browser window");
		return new HotelDetailsWebPage();
		
	}
	/*******************Set Dynamic Xpath**********************/
	
	public void setHotelNameDynamicXpath(String Str_hotelName)
	{
		By_hotelName = By.xpath("//span[text()='"+Str_hotelName+"']");
	}
	
	
}


