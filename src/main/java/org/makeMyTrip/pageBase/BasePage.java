package org.makeMyTrip.pageBase;

import org.makeMyTrip.driver.DriverManager;
import org.makeMyTrip.enums.ExplicitWaitExpectedConditions;
import org.makeMyTrip.generics.ExplicitWaitConditions;
import org.makeMyTrip.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

	protected void click(By by, ExplicitWaitExpectedConditions expectedCondition) {
		WebElement element= ExplicitWaitConditions.performExplicitWait(by, expectedCondition);
		element.click();
		ExtentLogger.pass("Clicked on "+by+"Succesfully");
	}

	protected void enterText(By by, String strText , ExplicitWaitExpectedConditions expectedCondition) {

		WebElement element= ExplicitWaitConditions.performExplicitWait(by, expectedCondition);
		element.clear();
		element.sendKeys(strText);
		ExtentLogger.pass("Entered text "+strText+" in the Locator "+by);
	}

	protected String getPageTitle() {

		return DriverManager.getDriver().getTitle();
	}

	protected String getText(By by) {
		return DriverManager.getDriver().findElement(by).getText();
	}
	protected String getURL() {
		return DriverManager.getDriver().getCurrentUrl();
	}
	
}
