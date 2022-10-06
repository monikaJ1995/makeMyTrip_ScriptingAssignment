package com.qa.wishupDev.tests;

import org.ravi.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected BaseTest() {

	}

	@BeforeMethod
	protected void setUp() throws Exception {
		Driver.initDriver();
		
	}

	@AfterMethod()
	protected void tearDown() {
		Driver.quitDriver();
	}

}
