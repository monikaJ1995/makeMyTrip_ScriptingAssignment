package org.makeMyTrip.pageLayer;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.makeMyTrip.driver.DriverManager;
import org.makeMyTrip.enums.ExplicitWaitExpectedConditions;
import org.makeMyTrip.generics.MouseActions;
import org.makeMyTrip.pageBase.BasePage;
import org.openqa.selenium.By;

public class HotelBookingPaymentWebPage extends BasePage{
	Logger log = LogManager.getLogger(HotelsSearchResultsWebPage.class);
	private By By_guestTitleDrpDwn = By.cssSelector("#title");
	private By By_firstName = By.id("fName");
	private By By_lastName = By.id("lName");
	private By By_emailAddress = By.id("email");
	private By By_contactNumber = By.id("mNo");
	private By By_payNowBtn = By.cssSelector(".btnContinuePayment");
	private By By_PANCardNumber = By.id("panToken");
	private By By_confirmPANBtn = By.id("panToken");
	private By By_upiPayMode = By.cssSelector(".payment__icon__upi");
	private By By_upiId = By.cssSelector("#inputVpa");
	private By By_verifyAndPayBtn = By.cssSelector(".prime__btn.paynow__btn");
	
//	public HotelBookingPaymentWebPage()
//	{
//		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	}
	
	/*This method will select title for Guest by handling dropdown*/
	public HotelBookingPaymentWebPage selectGuestTitle()
	{
		click(By_guestTitleDrpDwn, ExplicitWaitExpectedConditions.NONE);
		log.info("");
		return this;
				
	}
	
	/*This method will enter input in the text field
	 * input: String First Name
	 * return: Instance of class*/
	public HotelBookingPaymentWebPage enterFirstName(String Str_firstName)
	{
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		MouseActions.pageDown();
		log.info("Scroll down to enter user details");
		enterText(By_firstName, Str_firstName, ExplicitWaitExpectedConditions.NONE);
		log.info(Str_firstName +" entered in text field");
		return this;
	}
	
	/*This method will enter input in the text field
	 * input: String Last Name
	 * return: Instance of class*/
	public HotelBookingPaymentWebPage enterLastName(String Str_lastName)
	{
		enterText(By_lastName,Str_lastName, ExplicitWaitExpectedConditions.NONE);
		log.info(Str_lastName +" entered in text field");
		return this;
	}
	
	/*This method will enter input in the text field
	 * input: String emailAddress
	 * return: Instance of class*/
	public HotelBookingPaymentWebPage enterEmailAddress(String Str_email)
	{
		enterText(By_emailAddress,Str_email, ExplicitWaitExpectedConditions.NONE);
		log.info(Str_email +" entered in text field");
		return this;
	}
	
	/*This method will enter input in the text field
	 * input: String contact number
	 * return: Instance of class*/
	public HotelBookingPaymentWebPage enterContactNumber(String Str_contactNumber)
	{
		enterText(By_contactNumber,Str_contactNumber, ExplicitWaitExpectedConditions.NONE);
		log.info(Str_contactNumber +" entered in text field");
		return this;
	}
	
	/*This method will click on Pay now button
	 * return: Instance of class*/
	public HotelBookingPaymentWebPage clickOnPayNow()
	{
		click(By_payNowBtn,ExplicitWaitExpectedConditions.NONE);
		log.info("Clicked on pay now button");
		return this;
	}
	
	/*This method will enter input in the text field & press TAB for PAN name confirmation
	 * input: String PAN card number
	 * return: Instance of class*/
	public HotelBookingPaymentWebPage enterPANCardNumber(String Str_PANNumber)
	{
		enterText(By_PANCardNumber,Str_PANNumber,ExplicitWaitExpectedConditions.NONE);
		log.info(Str_PANNumber +" entered in text field");
		MouseActions.simulateTAB();
		return this;
	}
	
	/*This method will click on confirm button for PAN number
	 * return: Instance of class*/
	public HotelBookingPaymentWebPage clickOnConfirmBtn()
	{
		click(By_confirmPANBtn,ExplicitWaitExpectedConditions.CLICKABLE);
		log.info("Clicked on confirm button");
		return this;
	}
	
	/*This method will select payment mode for booking
	 * return: Instance of class*/
	public HotelBookingPaymentWebPage selectPaymentMode()
	{
		click(By_upiPayMode,ExplicitWaitExpectedConditions.NONE);
		log.info("Selected payment mode");
		return this;
	}
	
	/*This method wll enter input in the UPI id text field
	 * input: String UPI id
	 *return: Instance of class*/
	public HotelBookingPaymentWebPage enterUPIId(String Str_UPIId)
	{
		enterText(By_upiId,Str_UPIId, ExplicitWaitExpectedConditions.NONE);
		log.info(Str_UPIId +" entered in text field");
		return this;
	}
	
	/*This method will click on  verify & pay button & proceed for payment for booking
	 * return: Instance of class*/
	public HotelBookingPaymentWebPage clickOnVerifyAndPayBtn()
	{
		click(By_verifyAndPayBtn,ExplicitWaitExpectedConditions.NONE);
		log.info("Clicked on verify & pay button");
		return this;
	}
	
}
