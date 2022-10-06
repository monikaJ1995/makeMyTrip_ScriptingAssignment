package org.makeMyTrip.driver;

import java.util.Objects;

import org.makeMyTrip.enums.PropertyEnums;
import org.makeMyTrip.utils.ReadProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {

	private Driver() {

	}

	public static void initDriver() throws Exception {
		String browser = ReadProperties.get(PropertyEnums.BROWSER);
		if(Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome"))
			{
				//System.setProperty("webdriver.chrome.driver",FrameworkConstants.getChromrDriverPath());
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			}
			DriverManager.getDriver().manage().window().maximize();
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
