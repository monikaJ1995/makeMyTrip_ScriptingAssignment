package org.ravi.pages;



import org.openqa.selenium.By;
import org.ravi.enums.ExplicitWaitExpextecConditions;

public class OrangeHRMHomePage extends BasePage{


	private By imgProfilepic = By.xpath("//img[@alt='profile picture']");
	private By linkLogout = By.xpath("//a[text()='Logout']");

	public OrangeHRMHomePage clickOnProfilePic() {
		click(imgProfilepic,ExplicitWaitExpextecConditions.PRESENSCE);
		return this;
	}

	public Login clickLogout() {

		click(linkLogout,ExplicitWaitExpextecConditions.NONE);
		return new Login();
	}
	
	

}
