package org.ravi.generics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ravi.constants.FrameworkConstants;
import org.ravi.driver.DriverManager;
import org.ravi.enums.ExplicitWaitExpextecConditions;

public class ExplicitWaitConditions {
	
	
		public static WebElement performExplicitWait(By by, ExplicitWaitExpextecConditions exConditions) {
			
			WebElement element=null;
			
			if(exConditions == ExplicitWaitExpextecConditions.VISIBILE)		{
				element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWaitTime()).until(ExpectedConditions.visibilityOfElementLocated(by));	
				
			}else if(exConditions == ExplicitWaitExpextecConditions.CLICKABLE) {
				element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWaitTime()).until(ExpectedConditions.elementToBeClickable(by));	
				
			}else if (exConditions == ExplicitWaitExpextecConditions.PRESENSCE) {
				element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWaitTime()).until(ExpectedConditions.presenceOfElementLocated(by));	
			}else if (exConditions == ExplicitWaitExpextecConditions.NONE) {
				element = DriverManager.getDriver().findElement(by);
			}
			return element;
		}

}
