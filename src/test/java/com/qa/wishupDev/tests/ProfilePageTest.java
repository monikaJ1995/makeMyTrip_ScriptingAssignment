package com.qa.wishupDev.tests;

import org.makeMyTrip.driver.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.wishupDev.pageLayer.Dashboard;
import com.qa.wishupDev.pageLayer.HireResourcePage;
import com.qa.wishupDev.pageLayer.LoginPage;
import com.qa.wishupDev.pageLayer.ProfilePage;

public class ProfilePageTest{
	ProfilePage Obj_profile;
	@BeforeClass
	public void setup() throws Exception
	{	
		Driver.initDriver();
		//Login to app
		Dashboard Obj_dashboard = new LoginPage().enterUserName("monika.jadhav@wishup.co")
		.enterPassword("M0nika@Family")
		.clickLogin();
		System.out.println("Logged in to application");
		
		//Click on hire button
		HireResourcePage Obj_hire = Obj_dashboard.clickOnHire();
		
		//Click on virtual assistant category
		Obj_hire.selectCatergoryForResource("virtual assistant");
		
		//Set available hrs as 4hr
		Obj_hire.setAvailableHrsFilter();
		
		//Click on view profile button
		Obj_profile = Obj_hire.viewResourceProfile(1);
	}
 
	@Test(priority=1, enabled=false)
	public void verifyToolsExpertise()
	{
		//Verify the resource has MS office tools experience
		String Str_tools = Obj_profile.getToolsForResource();
		/****True***/Assert.assertTrue(Str_tools.contains("MS Office"));
	}
	
	@Test(priority=2, enabled=false)
	public void verifySkills()
	{
		//Verify the skill "CRM" is available in skill set for resource
		String Str_skills = Obj_profile.getTechSkillsForResource();
		Assert.assertTrue(Str_skills.contains("CRM"));
	}
	
	@Test(priority=3)
	public void addResourceToCart()
	{
		//Click on hire me button
		Obj_profile.hireMe();
		Obj_profile.selectPlanAndPricing();
		Obj_profile.selectHalfDayPlan();
		String Str_currentURL = Obj_profile.goToCart();
		Assert.assertEquals(Str_currentURL, "https://app-dev.wishup.co/cart");
	}
	
	

	@AfterClass
	public void teardown()
	{
		Driver.quitDriver();
	}


}
