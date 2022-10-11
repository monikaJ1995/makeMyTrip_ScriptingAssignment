package org.makeMyTrip.generics;

import org.makeMyTrip.driver.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	
	static Actions action = new Actions(DriverManager.getDriver());;	
	public static void mouseHover(WebElement element)
	{
		action.moveToElement(element).build().perform();
	}
	
	public static void pageDown()
	{
		action.sendKeys(Keys.PAGE_DOWN).build().perform();

	}
	public static void simulateTAB()
	{
		action.sendKeys(Keys.TAB).build().perform();
	}
	

}
