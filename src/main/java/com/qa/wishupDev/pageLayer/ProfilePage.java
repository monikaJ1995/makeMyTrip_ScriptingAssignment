package com.qa.wishupDev.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.ravi.driver.DriverManager;
import org.ravi.enums.ExplicitWaitExpextecConditions;
import org.ravi.pages.BasePage;


public class ProfilePage extends BasePage {

	private By By_toolExp = By.xpath("//span[text()='Tool Expertise']");
	private By By_toolsNames = By.xpath("//div[@class='top-tools tool-names']");
	private By By_techSkills = By.xpath("//span[text()='Technical Skills']");
	private By By_topSkillNames = By.xpath("//div[contains(@class,'top-skills tool-names')]");
	private By By_viewAllSkills = By.xpath("//div[contains(text(),'View all skills')]");
	private By By_allSkillNames = By.xpath("//div[@class='more-skills']");
	private By By_hireMeBtn = By.xpath("//a[@class='hire-me-button']");
	private By By_PlanPricingToggle = By.id("toggler");
	private By By_selectThisPlan = By.xpath("//div[@class='select-popular-button']/a[@class='half-url']");
	private By By_addedResourceGoToCart = By.xpath("//button[contains(text(),'Go to cart')]");

	/*This method will click on tools button & scrolled to resource tools section
	 * fetch the tools in string format & return the same for verification*/
	public String getToolsForResource()
	{
		//click on tools expertise option
		click(By_toolExp,ExplicitWaitExpextecConditions.CLICKABLE);

		//Fetch tools available on resource profile
		return getText(By_toolsNames);

	}

	/*This method will click on tech skills button & scrolled to resource skills section
	 * Check for availability of view all skills button & click operation if available
	 * fetch the skills in string format & return the same for verification*/
	public String getTechSkillsForResource()
	{
		/*verify skills for resource*/
		String Str_techSkills = null;
		try {
			//Click on Tech skills option
			click(By_techSkills,ExplicitWaitExpextecConditions.CLICKABLE);

			//Get available top skills of resource displayed on screen
			Str_techSkills = getText(By_topSkillNames);

			//Look for the presence of view all skills button
			WebElement WE_viewAllSkills = DriverManager.getDriver().findElement(By_viewAllSkills);
			Thread.sleep(2000);	

			/*If view all skills button is available & enabled then click on it 
			 * & get all skills available with resource*/ 
			if(WE_viewAllSkills.isEnabled())
			{
				//Click on view all skills button
				WE_viewAllSkills.click();
				Thread.sleep(1000);
				//Get all skills displayed on screen & store in variable
				Str_techSkills = getText(By_allSkillNames);
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
		return Str_techSkills;
	}


	/*This method will click on hire me button*/
	public ProfilePage hireMe()
	{
		click(By_hireMeBtn,ExplicitWaitExpextecConditions.CLICKABLE);
		return this;
	}

	/*This method will handle the Plan & Pricing toggle button*/
	public ProfilePage selectPlanAndPricing()
	{
		//Click on toggle button for quarterly plan selection
		click(By_PlanPricingToggle,ExplicitWaitExpextecConditions.CLICKABLE);
		return this;
	}

	/*This method will click on the select this plan button for half day selection*/
	public ProfilePage selectHalfDayPlan()
	{
		//Click on select this plan under half day section
		click(By_selectThisPlan,ExplicitWaitExpextecConditions.CLICKABLE);
		return this;
	}

	/*This method will click on Go to cart button available on pop-up 
	 * after resource added to the cart*/
	public String goToCart()
	{
		//Click on go to cart
		click(By_addedResourceGoToCart,ExplicitWaitExpextecConditions.CLICKABLE);
		return getURL();
	}
}
