package org.makeMyTrip.generics;

import org.makeMyTrip.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	
	static Actions action;	
	public MouseActions()
	{
		action = new Actions(DriverManager.getDriver());
	}
	
	public static void mouseHover(WebElement element)
	{
		action.moveToElement(element).build().perform();
	}

}
