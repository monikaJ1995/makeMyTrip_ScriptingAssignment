package org.ravi.tests;

import org.makeMyTrip.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.qa.wishupDev.tests.BaseTest;

public final class HomePageTest extends BaseTest {

	private HomePageTest() {
		
	}

	@Test
	public void test2(){
		System.out.println("Home page test start");
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Ravichandra",Keys.ENTER);
		System.out.println("Home page test end");
	}
	
}
