package org.makeMyTrip.tests;

import org.assertj.core.api.Assertions;
import org.makeMyTrip.pageLayer.HotelsWebPage;
import org.makeMyTrip.testBase.BaseTest;
import org.makeMyTrip.utils.SystemDate;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

public class HotelsPageTest extends BaseTest{
	HotelsWebPage hotel;
	@Test(enabled=false)
	public void validateHotelsPageLanding()
	{
/*-------Verify that hotels tab by default highlighted with specified color--------*/
		hotel = new HotelsWebPage();
		//Color of highlighted "Hotels" tab will get retrieved
		String Str_hotelTabHexColor = hotel.getHotelsTabBackgroundColor();
		
		//Verify that hotels tab gets highlighted with specified background color as per requirement
		Assertions.assertThat(Str_hotelTabHexColor).isEqualTo("#008cff");
		System.out.println("1st");
/*-------Verify hotels page title--------*/
		String Str_pageTitle = hotel.getHotelsPageTitle();
		Assertions.assertThat(Str_pageTitle).isEqualTo("MakeMyTrip.com: Save upto 60% on Hotel Booking 4,442,00+ Hotels Worldwide");
		System.out.println("2nd");

/*-------Verify hotels page url--------*/
		String Str_pageURL = hotel.getHotelsPageURL();
		Assertions.assertThat(Str_pageURL).isEqualTo("https://www.makemytrip.com/hotels/");
		System.out.println("3rd");

	}
	
	@Test
	public void validateSelectHotelCity() throws InterruptedException
	{
		hotel = new HotelsWebPage();
		//Verify autocomplete dropdown displayed on screen
		Assertions.assertThat(hotel.clickOnSelectHotelCity()).isTrue();
		System.out.println("autocomplete drpdwn");
		
		//Verify user can enter text in the text box. 
		String Str_retrivedText = hotel.enterCityInAutosuggestTextField("Dubai");
		Assertions.assertThat(Str_retrivedText).isEqualToIgnoringCase("Dubai");
				
		//Select city
		hotel.selectDestinationCity("Deira, Dubai");
		//Thread.sleep(1000);
		
		//Select checkin date
		hotel.selectCheckInDate("October","21");
		
		//Select checkout date & get selected date block background color for validation
		String Str_dateBlockBackgrounColor = hotel.selectCheckOutDate("January","21");
		Assertions.assertThat(Str_dateBlockBackgrounColor).isEqualTo("#eaf5ff");
		Thread.sleep(2500);
		
	}

}
