package com.qa.wishupDev.tests;

import org.ravi.enums.PropertyEnums;
import org.ravi.utils.ReadProperties;
import org.testng.annotations.Test;
import com.qa.wishupDev.pageLayer.AddATask;
import com.qa.wishupDev.pageLayer.Dashboard;
import com.qa.wishupDev.pageLayer.LoginPage;


public class AddATaskTest extends BaseTest{

	private AddATaskTest()
	{

	}

	@Test
	public void beforeMethod() throws Exception
	{
		new LoginPage()
		.enterUserName(ReadProperties.get(PropertyEnums.USERNAME))
		.enterPassword(ReadProperties.get(PropertyEnums.PASSWORD))
		.clickLogin();
		System.out.println("login clicked");

		new Dashboard().clickOnAddATask();

		new AddATask().clickOnCreateTaskButton()
		.enterTaskName()
		.enterTaskDescription()
		.selectResourceForAssignment()
		.clickOnCreateTaskButton()
		.selectCategory()
		.enterStepsToDoTask()
		.clickOnSaveDetails();


	}



}
