package com.qa.wishupDev.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.wishupDev.pageLayer.Dashboard;
import com.qa.wishupDev.pageLayer.FeedbackPage;
import com.qa.wishupDev.pageLayer.LoginPage;


public class FeedbackPageTest extends BaseTest{
	 
	@Test
	public void giveFeedbackToResource()
	{
		Dashboard Obj_dashboard = new LoginPage().enterUserName("monika.jadhav@wishup.co")
		.enterPassword("M0nika@Family")
		.clickLogin();
		
		//Click on Feedback from dashboard page
		FeedbackPage Obj_feedback = Obj_dashboard.clickOnFeedback();
		System.out.println("Clicked on Feedback button");
//		Assert.assertEquals(Str_currentUrlCreateTask, "https://app-dev.wishup.co/org/90014/feedback");
		
		//Click on create feedback button from feedback page
		String Str_currentUrlCreateFeedback = Obj_feedback.clickOnCreateFeedback();
		System.out.println("Clicked on create feedback button");
		Assert.assertEquals(Str_currentUrlCreateFeedback, "https://app-dev.wishup.co/org/90014/feedback/create");
		
		String Str_respMsg = Obj_feedback.clickOnGiveFeedback()
				.selectFromToDate()
				.giveStarRating()
				.enterComments()
				.clickOnSubmitFeedback();
		System.out.println("Selected time span for feedback");
			
		//verify response msg for recorded feedback
		Assert.assertEquals(Str_respMsg, "Feedback recorded successfully");
		System.out.println("Response message validated successfully");
	}
	
	
}
