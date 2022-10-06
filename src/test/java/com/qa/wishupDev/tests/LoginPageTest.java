package com.qa.wishupDev.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.wishupDev.pageLayer.Dashboard;
import com.qa.wishupDev.pageLayer.LoginPage;


public class LoginPageTest extends BaseTest{


	@Test(enabled=true,dataProviderClass= org.makeMyTrip.dataprovider.DataProviderUtil.class, dataProvider="testData")
	public void verifyLogin(Map<String, String> map)
	{
		System.out.println(" method start");
		//Login to application by passing valid UN & invalid pwd
		Dashboard obj_dashboard = new LoginPage()
				.enterUserName(map.get("Username"))
				.enterPassword(map.get("Password"))
				.clickLogin();
		System.out.println("Login click");
		String Str_actualURLAfterLogin = new LoginPage().getPageURL();

		if(map.get("DataStatus").equalsIgnoreCase("valid"))
		{		
			Assert.assertEquals(Str_actualURLAfterLogin, "https://app-dev.wishup.co/org/90014/my_daily_reports?fb_request=true");
			//Perform logout from account
			obj_dashboard.clickOnLogout();
			System.out.println("creds are: "+map.get("Password"));
		}
		else if(map.get("DataStatus").equalsIgnoreCase("invalid"))
		{
			Assert.assertNotEquals(Str_actualURLAfterLogin, "https://app-dev.wishup.co/org/90014/my_daily_reports?fb_request=true");
			System.out.println("invalid status case");
			System.out.println("creds are: "+map.get("Password"));
		}
		System.out.println(" method end");

	}
}
