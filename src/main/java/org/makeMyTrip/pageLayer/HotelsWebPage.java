package org.makeMyTrip.pageLayer;

import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.makeMyTrip.driver.DriverManager;
import org.makeMyTrip.enums.ExplicitWaitExpectedConditions;
import org.makeMyTrip.generics.ExplicitWaitConditions;
import org.makeMyTrip.generics.MouseActions;
import org.makeMyTrip.pageBase.BasePage;
import org.makeMyTrip.utils.SystemDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

public class HotelsWebPage extends BasePage{
	Logger log = LogManager.getLogger(HotelsWebPage.class);
	WebDriver driver = DriverManager.getDriver();
	private By By_hotelsTab = By.xpath("//li[@class='menu_Hotels']//span[contains(@class,'darkGreyText')]");
	private By By_selectHtlCity = By.cssSelector(".selectHtlCity");
	private By By_autocompleteDropDown = By.cssSelector("input[autocomplete='nope']");
	private By By_suggestedSearchResults = By.xpath("//ul[@role='listbox']/li");
	//private By By_datePickerCheckin = By.cssSelector("label[for='checkin']");
	private By By_daysOfMonth = By.xpath("(//div[@class='DayPicker-Month'])[1]//div[contains(@class,'DayPicker-Day')]");
	private By By_nextMonthNavButton = By.cssSelector(".DayPicker-NavButton--next");
	private By By_datePickerMonth = By.cssSelector(".DayPicker-Month:nth-child(1)");
	private By By_roomsAndGuests = By.cssSelector(".roomGuests");
	private By By_roomCount = By.xpath("//div[@class='roomsGuestsTop']/child::div");
	private By By_addAnotherRoomBtn = By.cssSelector(".btnAddRoom");
	private By By_removeRoomBtn/* = By.xpath("(//a[text()='Remove'])")*/;
	private By By_editRoomDetailsBtn/* = By.xpath("(//a[text()='Remove'])")*/;
	private By By_childrenCounter = By.xpath("(//li[contains(@data-cy,'children')])");
	private By By_childAgeDrpdwn = By.cssSelector(".ageSelectBox");
	private By By_submitGuestsBtn = By.cssSelector(".btnApply");
	private By By_pricePerNightCharge = By.cssSelector(".prpTypeSel__list--item");
	private By By_searchBtn = By.id("hsw_search_button");
	

	//	

	/*This method returns default background color of 
	 * hotels tab when landed on webpage successfully*/
	public String getHotelsTabBackgroundColor()
	{
		//return getElementColor(By_hotelsTab,"color");
		String Str_elementColor = driver.findElement(By_hotelsTab).getCssValue("color");
		log.info("Retrieved hotels tab background color");
		return Color.fromString(Str_elementColor).asHex();	
	}

	/*This method returns landing page title*/
	public String getHotelsPageTitle()
	{
		log.info("Retrieved landing page title");
		return getPageTitle();
	}

	/*This method returns landing page URL*/
	public String getHotelsPageURL()
	{
		log.info("Retrieved landing page url");
		return getURL();
	}

	/*This method returns the boolean status of web element if displayed on screen or not*/
	public boolean clickOnSelectHotelCity()
	{
		//Click on "Select hotel city" field 
		click(By_selectHtlCity, ExplicitWaitExpectedConditions.PRESENSCE);
		log.info("Clicked on select hotel city field");

		//Return the status of web element is displayed on screen or not
		WebElement WE_autocompleteDropdown = ExplicitWaitConditions.performExplicitWait(By_autocompleteDropDown, ExplicitWaitExpectedConditions.VISIBLE);
		log.info("Autocomplete dropdown is displayed on screen");
		return WE_autocompleteDropdown.isDisplayed();
	}

	/*This method will enter destination name in the "select hotel city" field
	 * return: it will return the text entered in the field to validate whether 
	 * user able to type in the field or not*/
	public String enterCityInAutosuggestTextField(String cityName)
	{
		enterText(By_autocompleteDropDown, cityName, ExplicitWaitExpectedConditions.VISIBLE);
		log.info("City name is entered in select city text field");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Entered city name is retrieved for verification");
		//		return driver.findElement(By_autocompleteDropDown).getAttribute("value");
		return ExplicitWaitConditions
				.performExplicitWait(By_autocompleteDropDown, ExplicitWaitExpectedConditions.NONE)
				.getAttribute("value");
	}

	/*This method will select destination city as per requirement
	 * input: city name which needed to select
	 * returns: count of suggested search results for entered city name in text field*/
	public int selectDestinationCity(String selectCityName)
	{
		List<WebElement> WE_suggestedSearchResults = findElements(By_suggestedSearchResults); 
		//				driver.findElements(By_suggestedSearchResults);
		log.info("Retrived suggested search results for entered city name");
		for(WebElement cityName : WE_suggestedSearchResults)
		{
			log.debug("Iterating through each suggested city name for selection");
			if(cityName.getText().contains(selectCityName))
			{
				log.debug("Entered text matched with suggested result");
				cityName.click();
				log.info("Clicked on city "+selectCityName);
				break;
			}
		}
		log.debug("Retrieved count of suggested results");
		return WE_suggestedSearchResults.size();
	}

	/*This method selects check in date as per user input &
	 * check status whether date lower than selected checkin date is disabled or not
	 * input : String monthName(eg: "October")
	 * 			String checkinDate(eg: "21")
	 * return :  status of date lower than selected checkin date(enabled/disabled)*/
	public String selectCheckInDate(String Str_checkinMonth,String Str_checkinDate)
	{
		List<WebElement> days = SystemDate.getDaysOfRequiredMonth(By_datePickerMonth, By_nextMonthNavButton, By_daysOfMonth, Str_checkinMonth);
		log.debug("Retrived all days of selected month");
		String previousDateStatus = null;
		log.debug("Iterating through each day of selected month");
		for(int i=0;i<days.size();i++)
		{
			if(days.get(i).getText().equals(Str_checkinDate))
			{
				days.get(i).click();
				if(i>0)
				{
					previousDateStatus = days.get(i-1).getAttribute("aria-selected");
				}
				break;
			}
		}
		log.info("Selcted check in month as "+Str_checkinMonth+" & check in date as "+Str_checkinDate);
		return previousDateStatus;

	}


	/*This method selects check out date as per user input &
	 * check whether selected dates between checkin & checkout are highlighted with require color or not
	 * input : String monthName(eg: "October")
	 * 			String checkinDate(eg: "21")
	 * return :  String hex color code of selected date cells in date picker*/
	public String selectCheckOutDate(String Str_checkoutMonth, String Str_checkoutDate)
	{
		List<WebElement> days = SystemDate.getDaysOfRequiredMonth(By_datePickerMonth, By_nextMonthNavButton, By_daysOfMonth, Str_checkoutMonth);
		log.debug("Retrived all days of selected month");
		String Str_dateBackgroundColorRGB=null;
		log.debug("Iterating through each day of selected month");
		for(int i=0;i<days.size();i++)
		{
			if(days.get(i).getText().equals(Str_checkoutDate))
			{
				MouseActions.mouseHover(days.get(i));
				Str_dateBackgroundColorRGB = days.get(i).getCssValue("background-color");
				log.debug("Retrieved selected date cell background color");
				days.get(i).click();
				log.info("Selected checkout date");
				break;
			}
		}
		
		log.info("Selcted check out month as "+Str_checkoutMonth+" & check out date as "+Str_checkoutDate);
		return Color.fromString(Str_dateBackgroundColorRGB).asHex();
	}


	/*This is for routine trial*/
	public HotelsWebPage clickRoomGuests()
	{
		click(By_roomsAndGuests, ExplicitWaitExpectedConditions.CLICKABLE);
		log.info("Clicked on rooms & guests field");
		return this;
	}

	/*This method returns count of rooms added in the Rooms & Guests filter*/
	public int getRoomCount()
	{
		//(By_roomsAndGuests, ExplicitWaitExpectedConditions.CLICKABLE);
		log.info("Retrieved count of rooms");
		return driver.findElements(By_roomCount).size();	
	}

	/*This method will click on add another room button for given count
	 * input: int count for number of times click on addanotherbutton
	 * return: instance of class*/
	public HotelsWebPage addAnotherRoom(int Int_roomCount)
	{
		log.info("Adding "+Int_roomCount+" rooms");
		for(int i=0;i<Int_roomCount;i++)
		{
			click(By_addAnotherRoomBtn,ExplicitWaitExpectedConditions.CLICKABLE);
			log.debug("Clicked on add another room button");
		}
		log.info("Added "+Int_roomCount+" rooms");
		return this;
	}

	/*This method removes specific room as per user input
	 * input: int room number to remove
	 * return: instance of class*/
	public HotelsWebPage removeRoom(int Int_roomNumber)
	{
		log.debug("Setting up dynamic xpath for removing specific room from list");
		setRemoveRoomDynamicXpath(Int_roomNumber);
		click(By_removeRoomBtn, ExplicitWaitExpectedConditions.CLICKABLE);
		log.info("Removed room number "+Int_roomNumber);
		return this;
	}

	/*This method is to click on "edit" for specific room details as per user input
	 * input: int room number to edit details
	 * return: instance of class*/
	public HotelsWebPage clickOnEditRoomDetails(int Int_roomNumber)
	{
		log.debug("Setting up dynamic xpath edit details of specific room from list");
		setEditRoomDetailsDynamicXpath(Int_roomNumber);
		click(By_editRoomDetailsBtn, ExplicitWaitExpectedConditions.CLICKABLE);
		log.info("clicked on edit button for room number "+Int_roomNumber);
		return this;
	}

	/*This method is to to set child count in selected room as per user input
	 * input: int child count
	 * return: instance of class*/
	public HotelsWebPage setChildrenCount(int Int_childCount)//2
	{
		int Int_childrenCount = findElements(By_childrenCounter).size();
		log.debug("Retrieved count of children counter blocks");
		log.debug("Iterating through each counter");
		for(int i=0;i<Int_childrenCount;i++)//2
		{
			if(i==Int_childCount)
			{
				click(setChildrenCounterDynamicXpath(i+1), ExplicitWaitExpectedConditions.CLICKABLE);
			}
		}
		log.info("Selected children count as "+Int_childCount);
		return this;
	}
	
	public HotelsWebPage selectChildAge(String Str_childAge)
	{
		System.out.println("1");
		click(By_childAgeDrpdwn, ExplicitWaitExpectedConditions.VISIBLE);
		System.out.println("clicked");
		WebElement WE_childAgeDrpdwn = findElement(By_childAgeDrpdwn);
		System.out.println("3");
		Select select = new Select(WE_childAgeDrpdwn);
		select.selectByValue(Str_childAge);
		System.out.println("done");
		return this;
	}
	

	/*This method is to click on apply button once the details are added in Rooms & Guests filter
	 * return: instnace of class*/
	public HotelsWebPage submitRoomsAndGuestsDetails()
	{
		click(By_submitGuestsBtn, ExplicitWaitExpectedConditions.NONE);
		log.info("Clicked on Apply button");
		return this;
	}
	
	/*This method will select price per night radio button for given input range
	 * input: String price range(eg: 1500-)
	 * return: Instance of class*/
	public HotelsWebPage selectPricePerNightCharge(String Str_priceRange) throws InterruptedException
	{
		List<WebElement> radioButtons = findElements(By_pricePerNightCharge);
		for(WebElement radioButton: radioButtons)
		{
			if(radioButton.getText().contains(Str_priceRange))
			{
				radioButton.click();
				break;
			}
		}
		log.info("Clicked & selected radio button with required price range");
		return this;
	}
	
	/*This method will click on all radio buttons under Price per night field
	 * sequentially one by one
	 * return: boolean Status of previous button(isSelected)*/
	public boolean selectMultiplePricePerNightCharge()
	{
		List<WebElement> radioButtons = findElements(By_pricePerNightCharge);
		boolean pervButtonStatus= true;
		for(int i=0; i<radioButtons.size();i++)
		{
			radioButtons.get(i).click();
			if(i>0)
			{
			pervButtonStatus = radioButtons.get(i-1).isSelected();
			}
		}
		log.info("Clicked on all radio buttons under price per night field sequentially");
		return pervButtonStatus;
	}
	
	/*This method will click on search button 
	 * return: Instance of HotelsSearchResultsWebPage class*/
	public HotelsSearchResultsWebPage clickOnSearchButton()
	{
		click(By_searchBtn, ExplicitWaitExpectedConditions.NONE);
		log.info("Clicked on Search button");
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return new HotelsSearchResultsWebPage();
	}



	/**************************Methods to set dynamic xpaths************************************/	
	/*This method set dynamic xpath for removing specific room from Rooms & Guests filter
	 * input= integer room number*/
	public void setRemoveRoomDynamicXpath(int Int_roomNumber)
	{
		By_removeRoomBtn = By.xpath("(//a[text()='Remove'])["+Int_roomNumber+"]");
	}

	/*This method set dynamic xpath to edit details of specific room from Rooms & Guests filter
	 * input= integer room number*/
	public void setEditRoomDetailsDynamicXpath(int Int_roomNumber)
	{
		By_editRoomDetailsBtn = By.xpath("(//a[text()='Edit'])["+Int_roomNumber+"]");
	}

	/*This method set dynamic xpath to set child count under Rooms & Guests filter
	 * input= integer child count*/
	public By setChildrenCounterDynamicXpath(int Int_childCount)
	{
		return By.xpath("(//li[contains(@data-cy,'children')])["+Int_childCount+"]");
	}

}
