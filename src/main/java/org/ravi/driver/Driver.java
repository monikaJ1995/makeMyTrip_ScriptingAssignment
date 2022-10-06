package org.ravi.driver;

import java.util.Objects;

import org.openqa.selenium.chrome.ChromeDriver;
import org.ravi.constants.FrameworkConstants;
import org.ravi.enums.PropertyEnums;
import org.ravi.utils.ReadProperties;

public final class Driver {


	private Driver() {

	}

	public static void initDriver() throws Exception {
		if(Objects.isNull(DriverManager.getDriver())) {

			System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromrDriverPath());
			DriverManager.setDriver(new ChromeDriver());
			DriverManager.getDriver().get(ReadProperties.get(PropertyEnums.URL));

		}
	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())){
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}


	}
}
