package com.qa.wishupDev.pageLayer;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.ravi.driver.DriverManager;
import org.ravi.pages.BasePage;


public class CartPage extends BasePage {
	WebDriver driver;
	@FindBy(xpath = "//input[@type='checkbox']/following::label[text()='I agree to the ']")
	WebElement WE_termsOfUse;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement WE_proceedToPay;
	@FindBy(xpath = "//button[text()='Pay via Razorpay']")
	WebElement WE_paymentMode_Razorpay;
	@FindBy(xpath = "//input[@id='email']")
	WebElement WE_emailCart;
	@FindBy(xpath = "//div[@role='button']")
	WebElement WE_payUsingCard;
	@FindBy(xpath = "//button[@method='card']")
	WebElement WE_card;
	@FindBy(id = "card_number")
	WebElement WE_cardNo;
	@FindBy(id = "card_expiry")
	WebElement WE_expiry;
	@FindBy(id = "card_cvv")
	WebElement WE_cvv;
	@FindBy(xpath = "//div[@role='button']")
	WebElement WE_pay;
	@FindBy(xpath = "//button[text()='Success']")
	WebElement WE_success;
	@FindBy(xpath = "//div[@class='ui olive small top right attached label']")
	WebElement WE_payStatus;
	
	
	public CartPage()
	{
		this.driver = DriverManager.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	/*This method will click on terms of use checkbox on the cart page*/
	public void selectTermsOfUse()
	{
		try {
			//click on terms of use
			JavascriptExecutor Obj_js =(JavascriptExecutor)driver;
			Obj_js.executeScript("arguments[0].click();", WE_termsOfUse);
			Thread.sleep(1000);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/*This method will click on "proceed to pay button" to proceed for payment*/
	public void proceedToPay()
	{
		//Click on proceed to pay button
		WE_proceedToPay.click();
	}
	
	/*This method will select the payment mode from the available ones*/
	public void selectPaymentMode()
	{
		//Select payment mode
		WE_paymentMode_Razorpay.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*This method will complete the process of entering card details for payment to hire resource*/
	public void enterCardDetails()
	{
		//Enter email
		driver.switchTo().frame(0);
		WE_emailCart.sendKeys("monika.jadhav@wishup.co");
		
		//Click on pay button
		WE_payUsingCard.click();

		//Select card for payment
		WE_card.click();

		//Enter card number
		WE_cardNo.sendKeys("4242 4242 4242 4242");

		//Enter expiry date
		WE_expiry.sendKeys("424");

		//Enter cvv
		WE_cvv.sendKeys("424");
	}

	/*This method will click on pay button
	 * handle new window & click on options for payment confirmation accept or deny
	 * return: payment status Paid or failed*/
	public String completeThePayment()
	{
		//Click on pay button
		WE_pay.click();

		//Click on success for payment confirmation
		String Str_parentWindowID = driver.getWindowHandle();
		Set<String> SetStr_windowhandles = driver.getWindowHandles();
		for(String childwdw : SetStr_windowhandles)
		{
			if(!childwdw.equals(Str_parentWindowID))
			{
				driver.switchTo().window(childwdw);
				WE_success.click();
				driver.switchTo().window(Str_parentWindowID);
			}		
		}

		//Verify payment status
		String Str_payStatus = WE_payStatus.getText();
		return Str_payStatus;

	}

}
