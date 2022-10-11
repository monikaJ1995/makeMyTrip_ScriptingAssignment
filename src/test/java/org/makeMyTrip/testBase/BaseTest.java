package org.makeMyTrip.testBase;

import org.makeMyTrip.driver.Driver;
import org.makeMyTrip.pageLayer.HotelsWebPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	protected HotelsWebPage hotel;
	protected BaseTest() {

	}

	@BeforeMethod
	protected void setUp() throws Exception {
		Driver.initDriver();
		hotel = new HotelsWebPage();
	}

	@AfterMethod()
	protected void tearDown() {
		Driver.quitDriver();
	}

}
