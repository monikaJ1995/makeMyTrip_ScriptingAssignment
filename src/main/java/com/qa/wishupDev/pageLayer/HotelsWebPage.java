package com.qa.wishupDev.pageLayer;

import java.util.List;

import org.makeMyTrip.base.BasePage;
import org.makeMyTrip.driver.DriverManager;
import org.makeMyTrip.enums.ExplicitWaitExpectedConditions;
import org.makeMyTrip.generics.ExplicitWaitConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HotelsWebPage extends BasePage{
	
	private By By_hotelsTab = By.xpath("//li[@class='menu_Hotels']//span[contains(@class,'darkGreyText')]");
	private By By_selectHtlCity = By.cssSelector(".selectHtlCity");
	private By By_autocompleteDropDown = By.cssSelector("input[autocomplete='nope']");
	private By By_suggestedSearchResults = By.xpath("//ul[@role='listbox']/li");
	/*This method returns default background color of 
	 * hotels tab when landed on webpage successfully*/
	public String getHotelsTabBackgroundColor()
	{
		String Str_elementColor = DriverManager.getDriver().findElement(By_hotelsTab).getCssValue("color");
		return Str_elementColor;
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
	
	public String enterCityInAutosuggestTextField(String cityName) throws InterruptedException
	{
		enterText(By_autocompleteDropDown, cityName, ExplicitWaitExpectedConditions.VISIBLE);
		Thread.sleep(1000);
		return DriverManager.getDriver().findElement(By_autocompleteDropDown).getAttribute("value");
	}
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
	

}
