package org.makeMyTrip.pageLayer;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.makeMyTrip.driver.DriverManager;
import org.makeMyTrip.enums.ExplicitWaitExpectedConditions;
import org.makeMyTrip.generics.MouseActions;
import org.makeMyTrip.pageBase.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class HotelDetailsWebPage extends BasePage {

	Logger log = LogManager.getLogger(HotelsSearchResultsWebPage.class);
	private By By_rooms = By.cssSelector("#detpg_hotel_rooms");
	private By By_selectRoom = By.xpath("(//a[contains(@class,'rmPayable__dtl--cta')])");
	private By By_errorMsgRoomSoldOut = By.cssSelector(".rmSoldout__desc.appendTop10");

	/*This method will click on Room tab for navigating to the hotel room list
	 * return: Instance of class*/
	public HotelDetailsWebPage clickOnRoomTab()
	{
		click(By_rooms, ExplicitWaitExpectedConditions.NONE);
		log.info("Clicked on rooms tab for room selection");
		return this;
	}

	/*This method will select & open the hotel room for booking & navigate to review & payment page
	 * return: Instance of class*/
	public HotelBookingPaymentWebPage clickOnSelectRoom()
	{
		List<WebElement> rooms = findElements(By_selectRoom);
		for(WebElement room: rooms)
		{
			room.click();
			try {
				if(getText(By_errorMsgRoomSoldOut).equals("Your dates are popular we?ve run out of rooms at this property!"))
				{
					log.info("Room is already booked, Select other one");
				}
				else
				{
					log.info("Room available for booking, navigating to payment page");
					break;
				}
			}catch(NoSuchElementException e)
			{
				e.getMessage();
			}

		}
		return new HotelBookingPaymentWebPage();
	}


}
