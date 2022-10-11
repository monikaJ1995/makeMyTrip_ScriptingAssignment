package org.makeMyTrip.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.makeMyTrip.pageLayer.HotelBookingPaymentWebPage;
import org.makeMyTrip.pageLayer.HotelDetailsWebPage;
import org.makeMyTrip.pageLayer.HotelsSearchResultsWebPage;
import org.makeMyTrip.pageLayer.HotelsWebPage;
import org.makeMyTrip.testBase.BaseTest;
import org.makeMyTrip.utils.SystemDate;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

public class HotelsPageTest extends BaseTest{
//	HotelsWebPage hotel;
	@Test(priority = -1,enabled=true)
	public void validateHotelsPageLanding()
	{
		/*-------Verify that hotels tab by default highlighted with specified color--------*/
		hotel = new HotelsWebPage();
		//Color of highlighted "Hotels" tab will get retrieved
		String Str_hotelTabHexColor = hotel.getHotelsTabBackgroundColor();

		//Verify that hotels tab gets highlighted with specified background color as per requirement
		Assertions.assertThat(Str_hotelTabHexColor).isEqualTo("#008cff");
		
		/*-------Verify hotels page title--------*/
		String Str_pageTitle = hotel.getHotelsPageTitle();
		Assertions.assertThat(Str_pageTitle).isEqualTo("MakeMyTrip.com: Save upto 60% on Hotel Booking 4,442,00+ Hotels Worldwide");
		
		/*-------Verify hotels page url--------*/
		String Str_pageURL = hotel.getHotelsPageURL();
		Assertions.assertThat(Str_pageURL).isEqualTo("https://www.makemytrip.com/hotels/");
		
	}

	@Test(priority=1,enabled=true)
	public void validateSelectHotelCity() throws InterruptedException
	{
//		hotel = new HotelsWebPage();
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
		System.out.println("checkin");
		boolean previousDateStatus = hotel.selectCheckInDate("October","21");
		System.out.println(previousDateStatus);

		//**********verify previous date field is disabled*****but showa enabled as status
		Assertions.assertThat(previousDateStatus).isTrue();
		System.out.println("previous date is disabled");

		//Select checkout date & get selected date block background color for validation
		String Str_dateBlockBackgrounColor = hotel.selectCheckOutDate("January","21");
		Assertions.assertThat(Str_dateBlockBackgrounColor).isEqualTo("#eaf5ff");
//		Thread.sleep(2500);


	}

	@Test(priority=2, enabled=true)
	public void validateRoomAndGuests() throws InterruptedException
	{
		hotel.clickRoomGuests();

		//Verify by default count of rooms is 1 
		Assertions.assertThat(hotel.getRoomCount()).isEqualTo(1);

		//Add number of rooms
		hotel.addAnotherRoom(3);
		Assertions.assertThat(hotel.getRoomCount()).isEqualTo(4);

		//Remove specific room
		hotel.removeRoom(3);
		Assertions.assertThat(hotel.getRoomCount()).isEqualTo(3);

		hotel.clickOnEditRoomDetails(1);
		hotel.setChildrenCount(2);

//		Thread.sleep(2000);
	}
	
	@Test(enabled=true,dataProviderClass= org.makeMyTrip.dataprovider.DataProviderUtil.class, dataProvider="testData")
	public void hotelBooking(Map<String, String> map) throws InterruptedException
	{
		
		hotel.clickOnSelectHotelCity();
		hotel.enterCityInAutosuggestTextField(map.get("CityName"));//"Dubai"
		hotel.selectDestinationCity(map.get("Select City Name"));//"Deira, Dubai"
		//Select checkin date
		hotel.selectCheckInDate(map.get("CheckInMonth"),map.get("CheckInDate")); //"October","15"

		//Select checkout date & get selected date block background color for validation
		hotel.selectCheckOutDate(map.get("CheckOutMonth"),map.get("CheckOutDate"));//"October","18"
		HotelsSearchResultsWebPage hotelResults= hotel.submitRoomsAndGuestsDetails()
		.clickOnSearchButton();

		HotelDetailsWebPage hotelDetails = hotelResults.selectHotelForBooking("Hotel Sangam");
		HotelBookingPaymentWebPage payment = hotelDetails.clickOnRoomTab()
		.clickOnSelectRoom();
		
		payment.enterFirstName(map.get("FirstName"))
		.enterLastName(map.get("LastName"))
		.enterEmailAddress(map.get("Email"))
		.enterContactNumber(map.get("Contact"))
		.clickOnPayNow()
		.enterPANCardNumber(map.get("PAN"))
		.clickOnConfirmBtn()
		.selectPaymentMode();
		Thread.sleep(3000);

	}
}
