package com.qa.wishupDev.pageLayer;

import org.openqa.selenium.By;
import org.ravi.driver.DriverManager;
import org.ravi.enums.ExplicitWaitExpextecConditions;
import org.ravi.pages.BasePage;
import org.ravi.reports.ExtentLogger;


public class LoginPage extends BasePage{
	
	By By_emailField = By.id("email");
	By By_passwordField = By.xpath("//input[@type='password']");
	By By_logInSubmit = By.xpath("//input[@type='submit']");
	
	/*This method will perform login to the application by accepting parameters from test class
	 * input param: String email_Id & String password
	 * return: current url after login operation*/

	public LoginPage enterUserName(String Str_email){

		DriverManager.getDriver().manage().window().maximize();
		//Enter valid email in the field
		enterText(By_emailField, Str_email , ExplicitWaitExpextecConditions.PRESENSCE);
		return this;
	}
	
	public LoginPage enterPassword(String password) {

		enterText(By_passwordField, password,ExplicitWaitExpextecConditions.NONE);
		ExtentLogger.pass("Password Entered");
		return this;
	}

	public Dashboard clickLogin() {
		click(By_logInSubmit,ExplicitWaitExpextecConditions.CLICKABLE);
		return new Dashboard();
	}
	public String getTitle() {

		return getPageTitle();
	}
	public String getPageURL() {

		return getURL();
	}


}
