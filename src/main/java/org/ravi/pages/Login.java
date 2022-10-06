package org.ravi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.ravi.driver.DriverManager;
import org.ravi.enums.ExplicitWaitExpextecConditions;
import org.ravi.reports.ExtentLogger;

public class Login extends BasePage{


	private By txtboxUserName = By.xpath("//input[@name='username']");
	private By txtboxPassword = By.xpath("//input[@name='password' and @type='password']");
	private By btnLogin = By.xpath("//button[@type='submit']");

	public Login enterUserName(String userName){

		DriverManager.getDriver().manage().window().maximize();
		
		enterText(txtboxUserName, userName , ExplicitWaitExpextecConditions.PRESENSCE);
		
		return this;
	}

	public Login enterPassword(String password) {

		enterText(txtboxPassword, password,ExplicitWaitExpextecConditions.NONE);
		ExtentLogger.pass("Password Entered");
		return this;
	}

	public OrangeHRMHomePage clickLogin() {
		WebElement element = DriverManager.getDriver().findElement(btnLogin);
		
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[1].click();","RRR", element);
		click(btnLogin,ExplicitWaitExpextecConditions.NONE);
		return new OrangeHRMHomePage();
	}
	public String getTitle() {

		return getPageTitle();
	}
}
