package com.qa.wishupDev.pageLayer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.ravi.driver.DriverManager;
import org.ravi.enums.ExplicitWaitExpextecConditions;
import org.ravi.pages.BasePage;

public class Dashboard extends BasePage {
	By By_addATask = By.xpath("//a[contains(@class,'create_task_button')]");
	By By_dashboard = By.xpath("//span[text()='Dashboard']");
	By By_feedback = By.xpath("//span[text()='Feedback']");
	By By_hire = By.xpath("//div[@class='right menu']//a[text()='Hire']");
	By By_userName = By.xpath("//div[@class='right menu']//div[@class='ui simple dropdown item']");
	By By_logoutButton = By.xpath("//div[@class='menu left transition visible']");

	Logger log = LogManager.getLogger(Dashboard.class);
	/*This method will click on Add a Task button*/
	public String clickOnAddATask()
	{
		click(By_addATask,ExplicitWaitExpextecConditions.PRESENSCE);
		log.info("Clicked on Add a task button");
		return getURL();
	}

	/*This method will click on Dashboard button*/
	public WeeklyReportPage clickOnDashboard()
	{
		//Click on dashboard button
		click(By_dashboard,ExplicitWaitExpextecConditions.PRESENSCE);
		return new WeeklyReportPage();
	}

	/*This method will click on Feedback button*/
	public FeedbackPage clickOnFeedback()
	{
		//Click on Feedback 
		click(By_feedback,ExplicitWaitExpextecConditions.PRESENSCE);
		return new FeedbackPage();
	}
	/*This method will click on hire button & navigates to hire page*/
	public HireResourcePage clickOnHire()
	{
		//Click on hire 
		click(By_userName,ExplicitWaitExpextecConditions.PRESENSCE);
		return new HireResourcePage();
	}

	/* This method will perform logout operation */
	public LoginPage clickOnLogout()
	{
		//Identify and click on username
		click(By_hire,ExplicitWaitExpextecConditions.PRESENSCE);
		//Identify and click on logout
		click(By_logoutButton,ExplicitWaitExpextecConditions.PRESENSCE);
		return new LoginPage();
	}
}
