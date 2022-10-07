package org.makeMyTrip.pageLayer;

import java.util.List;

import org.makeMyTrip.driver.DriverManager;
import org.makeMyTrip.enums.ExplicitWaitExpectedConditions;
import org.makeMyTrip.generics.ExplicitWaitConditions;
import org.makeMyTrip.generics.MouseActions;
import org.makeMyTrip.pageBase.BasePage;
import org.makeMyTrip.utils.SystemDate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class HotelsWebPage extends BasePage{
	WebDriver driver;
	private By By_hotelsTab = By.xpath("//li[@class='menu_Hotels']//span[contains(@class,'darkGreyText')]");
	private By By_selectHtlCity = By.cssSelector(".selectHtlCity");
	private By By_autocompleteDropDown = By.cssSelector("input[autocomplete='nope']");
	private By By_suggestedSearchResults = By.xpath("//ul[@role='listbox']/li");
	//private By By_datePickerCheckin = By.cssSelector("label[for='checkin']");
	private By By_daysOfMonth = By.xpath("(//div[@class='DayPicker-Month'])[1]//div[contains(@class,'DayPicker-Day')]");
	private By By_nextMonthNavButton = By.cssSelector(".DayPicker-NavButton--next");
	private By By_datePickerMonth = By.cssSelector(".DayPicker-Month:nth-child(1)");
	
	//	
	public HotelsWebPage()
	{
		this.driver = DriverManager.getDriver();
	}
	
	/*This method returns default background color of 
	 * hotels tab when landed on webpage successfully*/
	public String getHotelsTabBackgroundColor()
	{
		String Str_elementColor = DriverManager.getDriver().findElement(By_hotelsTab).getCssValue("color");
		return Color.fromString(Str_elementColor).asHex();
	}
	/*This method returns landing page title*/
	public String getHotelsPageTitle()
	{
		return getPageTitle();
	}
	/*This method returns landing page URL*/
	public String getHotelsPageURL()
	{
		return getURL();
	}
	/*This method returns the boolean status of web element if displayed on screen or not*/
	public boolean clickOnSelectHotelCity()
	{
		//Click on "Select hotel city" field 
		click(By_selectHtlCity, ExplicitWaitExpectedConditions.PRESENSCE);
		
		//Return the status of web element is displayed on screen or not
		WebElement WE_autocompleteDropdown = ExplicitWaitConditions.performExplicitWait(By_autocompleteDropDown, ExplicitWaitExpectedConditions.VISIBLE);
		return WE_autocompleteDropdown.isDisplayed();
	}
	/*This method will enter destination name in the "select hotel city" field
	 * return: it will return the text entered in the field to validate whether 
	 * user able to type in the field or not*/
	public String enterCityInAutosuggestTextField(String cityName) throws InterruptedException
	{
		enterText(By_autocompleteDropDown, cityName, ExplicitWaitExpectedConditions.VISIBLE);
		Thread.sleep(1000);
		return DriverManager.getDriver().findElement(By_autocompleteDropDown).getAttribute("value");
	}
	
	/*This method will select destination city as per requirement
	 * input: city name which needed to select
	 * returns: count of suggested search results for entered city name in text field*/
	public int selectDestinationCity(String selectCityName)
	{
		List<WebElement> WE_suggestedSearchResults = DriverManager.getDriver().findElements(By_suggestedSearchResults);
		for(WebElement cityName : WE_suggestedSearchResults)
		{
			if(cityName.getText().contains(selectCityName))
			{
				cityName.click();
				break;
			}
		}
		return WE_suggestedSearchResults.size();
	}
	
	public void selectCheckInDate(String Str_month,String Str_checkinDate) throws InterruptedException
	{
		while(!driver.findElement(By_datePickerMonth).getText().contains(Str_month))
		{
//			DriverManager.getDriver().findElement(By_nextMonthNavButton).click();
			click(By_nextMonthNavButton, ExplicitWaitExpectedConditions.NONE);
		}	
		List<WebElement> days = driver.findElements(By_daysOfMonth);		
		for (WebElement day: days)
		{
			if(day.getText().equals(Str_checkinDate))
			{
				day.click();
				break;
			}
		}
		
	}
	
	public void performMouseHoverAction()
	{
		
	}
	
	public String selectCheckOutDate(String Str_month, String Str_checkoutDate) throws InterruptedException
	{
//		setSelectDateDynamicXpath(Str_checkoutDate);
//		Actions action = new Actions(DriverManager.getDriver());
//		WebElement checkoutDate = DriverManager.getDriver().findElement(By_checkInDate);
//		action.moveToElement(checkoutDate).build().perform();
//		String Str_dateBackgroundColorRGB = checkoutDate.getCssValue("background-color");
//		click(By_checkInDate, ExplicitWaitExpectedConditions.CLICKABLE);
//		//Thread.sleep(2000);
		
		while(!driver.findElement(By_datePickerMonth).getText().contains(Str_month))
		{
//			DriverManager.getDriver().findElement(By_nextMonthNavButton).click();
			click(By_nextMonthNavButton, ExplicitWaitExpectedConditions.NONE);
		}	
		List<WebElement> days = driver.findElements(By_daysOfMonth);
		String Str_dateBackgroundColorRGB=null;
		for (WebElement day: days)
		{
			if(day.getText().equals(Str_checkoutDate))
			{
				MouseActions.mouseHover(day);
				Str_dateBackgroundColorRGB = day.getCssValue("background-color");
				day.click();
				break;
			}
		}
		return Color.fromString(Str_dateBackgroundColorRGB).asHex();
	}
	
}
