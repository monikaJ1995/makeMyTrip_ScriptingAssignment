package org.ravi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.ravi.driver.DriverManager;
import org.ravi.enums.ExplicitWaitExpextecConditions;
import org.ravi.generics.ExplicitWaitConditions;
import org.ravi.reports.ExtentLogger;

public class BasePage {

	protected void click(By by, ExplicitWaitExpextecConditions expectedCondition) {
		WebElement element= ExplicitWaitConditions.performExplicitWait(by, expectedCondition);
		element.click();
		ExtentLogger.pass("Clicked on "+by+"Succesfully");
	}

	protected void enterText(By by, String strText , ExplicitWaitExpextecConditions expectedCondition) {

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
