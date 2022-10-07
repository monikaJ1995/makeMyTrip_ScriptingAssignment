package com.qa.wishupDev.pageLayer;

import org.makeMyTrip.base.BasePage;
import org.makeMyTrip.driver.DriverManager;
import org.makeMyTrip.enums.ExplicitWaitExpectedConditions;
import org.makeMyTrip.reports.ExtentLogger;
import org.openqa.selenium.By;


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
		enterText(By_emailField, Str_email , ExplicitWaitExpectedConditions.PRESENSCE);
		return this;
	}
	
	public LoginPage enterPassword(String password) {

		enterText(By_passwordField, password,ExplicitWaitExpectedConditions.NONE);
		ExtentLogger.pass("Password Entered");
		return this;
	}

	public Dashboard clickLogin() {
		click(By_logInSubmit,ExplicitWaitExpectedConditions.CLICKABLE);
		return new Dashboard();
	}
	public String getTitle() {

		return getPageTitle();
	}
	public String getPageURL() {

		return getURL();
	}


}
