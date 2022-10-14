package org.makeMyTrip.pageBase;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.makeMyTrip.driver.DriverManager;
import org.makeMyTrip.enums.ExplicitWaitExpectedConditions;
import org.makeMyTrip.generics.ExplicitWaitConditions;
import org.makeMyTrip.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class BasePage {
	Logger log = LogManager.getLogger(BasePage.class);
	
	protected void click(By by, ExplicitWaitExpectedConditions expectedCondition) {
		WebElement element= ExplicitWaitConditions.performExplicitWait(by, expectedCondition);
		element.click();
		log.debug("Clicked on "+by+" successfully");
		ExtentLogger.pass("Clicked on "+by+"Succesfully");
	}
	
	protected void enterText(By by, String strText , ExplicitWaitExpectedConditions expectedCondition) {

		WebElement element= ExplicitWaitConditions.performExplicitWait(by, expectedCondition);
		element.clear();
		log.debug("Text cleared successfully");
		element.sendKeys(strText);
		log.debug("Entered text "+strText+" in the Locator "+by);
		ExtentLogger.pass("Entered text "+strText+" in the Locator "+by);
	}

	protected String getPageTitle() {
		log.debug("Retrieved page title succeefully");
		return DriverManager.getDriver().getTitle();	
	}

	protected String getText(By by) {
		log.debug("Retrieved text of webelement");
		return DriverManager.getDriver().findElement(by).getText();
	}
	protected String getURL() {
		return DriverManager.getDriver().getCurrentUrl();
	}
	protected List<WebElement> findElements(By by)
	{
		return DriverManager.getDriver().findElements(by);	
	}
	protected WebElement findElement(By by)
	{
		return DriverManager.getDriver().findElement(by);	
	}
		
}
