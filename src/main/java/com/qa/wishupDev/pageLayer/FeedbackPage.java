package com.qa.wishupDev.pageLayer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.ravi.driver.DriverManager;
import org.ravi.enums.ExplicitWaitExpextecConditions;
import org.ravi.pages.BasePage;

public class FeedbackPage extends BasePage {
	private By By_createFeedback = By.xpath("(//div[contains(@class,'ui workspace')]//a[normalize-space()='Create a feedback'])");
	private By By_giveFeedback = By.xpath("//div[@class=\"ui client_dashboard computer only grid\"]/div[@class='ui thirteen wide column']/descendant::div/b[contains(text(),'Priyanka')]/ancestor::div[@class='name']/following-sibling::a");
	private By By_fromdate = By.xpath("div[id='slot_start_date'] input");
	private By By_todate = By.xpath("div[id='slot_end_date'] input");
	private By By_starRating = By.xpath("(//i[@class='star icon'])[3]");
	private By By_feedbackComments = By.name("message");
	private By By_submitFeedback = By.xpath("//div[@type='submit']");
	private By By_successResponseMsg = By.xpath("//div[text()='Feedback recorded successfully']");

	Logger log =LogManager.getLogger(FeedbackPage.class);
	/*This method will click on Create Feedback button*/
	public String clickOnCreateFeedback()
	{
		//Click on create feedback button
		log.info("Click on create feedback button");
		click(By_createFeedback,ExplicitWaitExpextecConditions.PRESENSCE);
		
		return getURL();
	}

	/*This method will click on give feedback button for specific resource profile*/
	public FeedbackPage clickOnGiveFeedback()
	{
		//Click on give feedback button for the specific resource
		click(By_giveFeedback,ExplicitWaitExpextecConditions.PRESENSCE);	
		//return getURL();
		return this;
	}

	/*This method will handle the date picker to select time span 
	 * for giving feedback*/
	public FeedbackPage selectFromToDate()
	{
		/*Select time span during which want to give Feedback*/
		log.info("Selecting time span for feedback");
		//Select from date
		enterText(By_fromdate, "August 1, 2022", ExplicitWaitExpextecConditions.PRESENSCE);
		log.info("From date entered");
		//Select to date
		enterText(By_todate, "August 8, 2022", ExplicitWaitExpextecConditions.PRESENSCE);
		log.info("To date entered");
		return this;
	}

	/*This method will select the stars for feedback*/
	public FeedbackPage giveStarRating()
	{
		//select 5star rating
		click(By_starRating,ExplicitWaitExpextecConditions.PRESENSCE);
		log.info("Star rating done");
		return this;
	}

	/*This method will enter comments in the enter comments text field*/
	public FeedbackPage enterComments()
	{
		//Enter feedback comments
		enterText(By_feedbackComments, "Great Work!!", ExplicitWaitExpextecConditions.PRESENSCE);
		log.info("Entered feedback comments in feedback comments field");
		return this;
	}

	/*This method will perform click operation on "submit feedback" button
	 * return: Response msg after creation of feedback*/
	public String clickOnSubmitFeedback()
	{
		//Submit Feedback click
		click(By_submitFeedback,ExplicitWaitExpextecConditions.PRESENSCE);
		log.info("Clicked on submit button");

		//get response message after feedback submission
		return getText(By_successResponseMsg);
	}

}
