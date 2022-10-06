package com.qa.wishupDev.pageLayer;

import org.openqa.selenium.By;
import org.ravi.enums.ExplicitWaitExpextecConditions;
import org.ravi.pages.BasePage;

public class AddATask extends BasePage{

	private By By_taskName = By.xpath("//div[@class='ui computer tablet only grid']//input[contains(@name,'name')]");
	private By By_description = By.xpath("//trix-editor[@input='task_details']");
	private By By_selectResource = By.xpath("(//div[@class='ui computer tablet only grid']//div[contains(text(),'mj')])");
	private By By_createTaskBtn = By.xpath("//div[@class='ui computer tablet only grid']//button[text()=' Create this task']");
	private By By_selectCat = By.xpath("(//input[@class='search'])");
	private By By_stepsBox = By.tagName("trix-editor");
	private By By_saveDetails = By.xpath("//div[@class='ui computer tablet only grid']//button[@type='submit']");

	/*This will enter the task name in the field*/
	public AddATask enterTaskName()
	{
		//Enter task name in the field
		enterText(By_taskName, "task1", ExplicitWaitExpextecConditions.PRESENSCE);
		return this;
	}

	/*This method will enter the task description in the text box*/
	public AddATask enterTaskDescription()
	{
		//Enter task description in the field
		enterText(By_description, "This is task created for Demo testing", ExplicitWaitExpextecConditions.PRESENSCE);
		return this;
	}

	/*This method will select the resource profile to whom want to assign the task*/
	public AddATask selectResourceForAssignment()
	{
		//Select the resources 
		click(By_selectResource,ExplicitWaitExpextecConditions.PRESENSCE);
		return this;
	}

	/*This method will perform click operation on Create task button*/
	public AddATask clickOnCreateTaskButton()
	{
		//Click on create task button
		click(By_createTaskBtn,ExplicitWaitExpextecConditions.PRESENSCE);
		return this;
	}

	/*This method will handle the "Category" dropdown for selection of Categories*/
	public AddATask selectCategory()
	{
		//Select Category like Administration
		enterText(By_selectCat, "Administration", ExplicitWaitExpextecConditions.PRESENSCE);
		return this;
	}

	/*This method will enter the steps provided by user in text box*/
	public AddATask enterStepsToDoTask()
	{
		//Enter steps to do task
		enterText(By_stepsBox, "Task for Demo", ExplicitWaitExpextecConditions.PRESENSCE);
		return this;
	}

	/*Click on save details button, Task will get created & assigned to selected resource
	 * Return: Current Url of landed webpage*/
	public AddATask clickOnSaveDetails()
	{
		//Click on save details so that task gets created successfully & gets assigned to the selected resources
		click(By_saveDetails,ExplicitWaitExpextecConditions.PRESENSCE);
		//		String Str_currentURL = ""/*driver.getCurrentUrl()*/;
		//		return Str_currentURL;
		return this;
	}
}
