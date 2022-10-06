package com.qa.wishupDev.pageLayer;

import org.makeMyTrip.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class WeeklyReportPage extends BasePage {
	By By_WeeklyReportmsg = By.xpath("//strong/preceding::span[contains(text(),'Total time spent this week')]");

	/*This method will generate previous week report
	 * return: Response message*/
	public String generatePreviousWeekReport()
	{
		//verify the weekly report generated
		return getText(By_WeeklyReportmsg);
	}	
}
