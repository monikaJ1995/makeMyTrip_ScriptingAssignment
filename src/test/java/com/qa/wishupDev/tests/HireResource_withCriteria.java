package com.qa.wishupDev.tests;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.ravi.driver.DriverManager;
import org.testng.annotations.Test;
import com.qa.wishupDev.pageLayer.Dashboard;
import com.qa.wishupDev.pageLayer.HireResourcePage;
import com.qa.wishupDev.pageLayer.LoginPage;
import com.qa.wishupDev.pageLayer.ProfilePage;


public class HireResource_withCriteria extends BaseTest {
	
	@Test(enabled=true)
	public void addResourceToCartWithMatchedCriteria()
	{
		Dashboard Obj_dashboard =  new LoginPage().enterUserName("monika.jadhav@wishup.co")
		.enterPassword("M0nika@Family")
		.clickLogin();
		
		HireResourcePage Obj_hire = Obj_dashboard.clickOnHire();
		//Sect category for resource
		Obj_hire.selectCatergoryForResource("digital marketing manager");//virtual assistant
		System.out.println("Selected category");
		//Set available hrs filter to 4hr
		Obj_hire.setAvailableHrsFilter();
		System.out.println("Avaliable hrs slider is set");

		//Get list & size of Resource which are available for 4 or more hrs
		List<WebElement> WEList_availableProfiles = Obj_hire.getListOfAvailableProfiles();
		int Int_countOfProfiles = WEList_availableProfiles.size();
		
		//start view profile from 1 index
		int Int_viewProfileIndex = 1;

		//Iterate through the list one by one & add resource to cart once criteria met.
		for(WebElement WE_profile:WEList_availableProfiles)
		{
			//View resource profile
			ProfilePage Obj_profile = Obj_hire.viewResourceProfile(Int_viewProfileIndex);
			System.out.println("Opened profile at number: "+Int_viewProfileIndex);

			try {
				Thread.sleep(1000);
				//Click on tool Expertise button.
				String Str_tools = Obj_profile.getToolsForResource();
				System.out.println("Clicked on tools expertise button");

				/*Verify resource have "MS Office" as tool experience,
				 *proceed to next step only if criteria meets */

				if(Str_tools.contains("MS Office"))
				{
					System.out.println("Resource have expertise in MS Office");

					//Click on technical skills 
					String Str_skillSet = Obj_profile.getTechSkillsForResource();
					Thread.sleep(2000);		

					//Verify resource have "Poster designing" as a skill in skill set, proceed to add to cart process only if criteria meets 
					if(Str_skillSet.contains("Poster Designing"))
					{
						System.out.println("Resource have Poster Designing as skill");
						//Click on Hire me button
						Obj_profile.hireMe();
						Thread.sleep(1000);

						//Click on toggle button for quarterly plan selection
						Obj_profile.selectPlanAndPricing();
						Thread.sleep(1000);

						//Click on select this plan under half day section
						Obj_profile.selectHalfDayPlan();
						Thread.sleep(1000);
						System.out.println("Half day plan is selected & resource is added to the cart");
					}
				}

			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			catch(NoSuchElementException e)
			{
				e.printStackTrace();
			}
			DriverManager.getDriver().navigate().to("https://app-dev.wishup.co/hire?bandwidth=4&search=&sort_by=&profiles=digital+marketing+manager");//virtual+assistant
			System.out.println("navigated back to the resource list");
			if(Int_viewProfileIndex<Int_countOfProfiles)
			{
				Int_viewProfileIndex++;
				System.out.println("Int_viewProfileIndex after increment: "+Int_viewProfileIndex);
			}
		}
	}

}
