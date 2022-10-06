package com.qa.wishupDev.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.wishupDev.pageLayer.Dashboard;
import com.qa.wishupDev.pageLayer.LoginPage;
import com.qa.wishupDev.pageLayer.WeeklyReportPage;

public class WeeklyReportTest extends BaseTest{
	
	@Test
	public void generateWeeklyReport()
	{
		//Login to app
		Dashboard Obj_dashboard= new LoginPage().enterUserName("monika.jadhav@wishup.co")
		.enterPassword("M0nika@Family")
		.clickLogin();
		//Click on dashboard option
		WeeklyReportPage Obj_report = Obj_dashboard.clickOnDashboard();
		String Str_msg = Obj_report.generatePreviousWeekReport();
		Assert.assertEquals(Str_msg, "");
	}

}
