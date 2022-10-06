package org.ravi.tests;

import org.assertj.core.api.Assertions;
import org.ravi.pages.Login;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.wishupDev.tests.BaseTest;

public class OrangeHRMTests extends BaseTest{

	private OrangeHRMTests() {

	}

	@Test(dataProvider="data")
	public void loginLogoutTest(String userNme, String password){

		String title= new Login()
				.enterUserName(userNme)
				.enterPassword(password)
				.clickLogin()
				.clickOnProfilePic()
				.clickLogout()
				.getTitle();

		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
		//https://www.youtube.com/watch?v=yvC2RjkVblA
	}

	@DataProvider(name="data",parallel=true)
	public static Object[][] getData(){

		return new Object[][] {

			{"Admin","admin123"},
			{"Admin","admin12"}


		};

	}
}
