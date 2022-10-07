package org.makeMyTrip.generics;

import java.time.Duration;

import org.makeMyTrip.constants.FrameworkConstants;
import org.makeMyTrip.driver.DriverManager;
import org.makeMyTrip.enums.ExplicitWaitExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConditions {
	
	private ExplicitWaitConditions()
	{
		
	}
		public static WebElement performExplicitWait(By by, ExplicitWaitExpectedConditions exConditions) {
			
			WebElement element=null;
			
			if(exConditions == ExplicitWaitExpectedConditions.VISIBLE)		{
				element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime())).until(ExpectedConditions.visibilityOfElementLocated(by));	
				
			}else if(exConditions == ExplicitWaitExpectedConditions.CLICKABLE) {
				element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime())).until(ExpectedConditions.elementToBeClickable(by));	
				
			}else if (exConditions == ExplicitWaitExpectedConditions.PRESENSCE) {
				element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime())).until(ExpectedConditions.presenceOfElementLocated(by));	
			}else if (exConditions == ExplicitWaitExpectedConditions.NONE) {
				element = DriverManager.getDriver().findElement(by);
			}
			return element;
		}

}
