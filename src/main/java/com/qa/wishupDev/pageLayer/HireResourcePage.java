package com.qa.wishupDev.pageLayer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.ravi.driver.DriverManager;
import org.ravi.enums.ExplicitWaitExpextecConditions;
import org.ravi.pages.BasePage;

public class HireResourcePage extends BasePage {
	String category;
	int Int_viewProfileIndex;
	By By_VA_Category; 
	By By_availableHoursSlider = By.className("slider");
	By ByList_availableProfiles = By.xpath("//section[@class='ui computer only client_dashboard grid va-list-container']//div[@class='appeal']");
	By By_viewProfile;
	By By_cart = By.xpath("//a[@class='cart-icon']");
	By By_backToDashboard = By.xpath("//a[@class='ui fluid basic button']");

	
	/*This method will apply filter for resource category by accepting String "category name"
	 * and click on option*/
	public HireResourcePage selectCatergoryForResource(String category)
	{
		setCategoryDynamicXpath(category);
		//Click on virtual assistant category
		click(By_VA_Category,ExplicitWaitExpextecConditions.PRESENSCE);
		return this;
	}

	/*This method will set available hours filter to 4 hr by handling available hours slider*/
	public HireResourcePage setAvailableHrsFilter()
	{
		//Set available hours to 4hr
		WebElement WE_availableHoursSlider = DriverManager.getDriver().findElement(By_availableHoursSlider);
		Actions Obj_Action = new Actions(DriverManager.getDriver());
		Obj_Action.dragAndDropBy(WE_availableHoursSlider, 4, 0).perform();
		return this;
	}
	
	/*It will return list of all available profiles by looking into availability status */
	public List<WebElement> getListOfAvailableProfiles()
	{
		//Get the list of profiles available for hiring
		List<WebElement> WEList_availableProfiles = DriverManager.getDriver().findElements(ByList_availableProfiles);
		return WEList_availableProfiles;
		
	}
	
	/*It will accept int value as input parameter for profile indexing &
	 * perform click operation on specific profile's "View Profile" button */
	public ProfilePage viewResourceProfile(int Int_viewProfileIndex)
	{
		setProfileIndexDynamicXpath(Int_viewProfileIndex);
		click(By_viewProfile,ExplicitWaitExpextecConditions.PRESENSCE);
		return new ProfilePage();
	}

	/*It will click on cart option available on the hire page to view resources added in the cart*/
	public CartPage goToCart()
	{
		//Click on cart option
		click(By_cart,ExplicitWaitExpextecConditions.PRESENSCE);
		return new CartPage();
	}
	
	/*It will click on the "back To Dashboard" button available on the hire page
	 * to go to the main user account dashboard*/
	public Dashboard backToDashboard()
	{
		//Click on back to dashboard button
		click(By_backToDashboard,ExplicitWaitExpextecConditions.PRESENSCE);
		return new Dashboard();
	}
	
	/*This method is to set the dynamic xpath by passing string category name from test method
	 * Replaces the category in VA_Category xpath 
	 * to apply filter for specific resource category*/
	public void setCategoryDynamicXpath(String category){
		By_VA_Category = By.xpath("//span[text()='"+category+"']");	
	}
	
	/*This method is to set the dynamic xpath by passing indexing from test method
	 * Replaces the profile index in xpath to click specific resource view profile every time*/
	public void setProfileIndexDynamicXpath(int Int_viewProfileIndex){
		By_viewProfile = By.xpath("(//section[@class='ui computer only client_dashboard grid va-list-container']//button[@class='profile-button'])["+Int_viewProfileIndex+"]");	
	}

}
