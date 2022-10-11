package org.makeMyTrip.driver;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.makeMyTrip.enums.PropertyEnums;
import org.makeMyTrip.utils.ReadProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {

	static Logger log = LogManager.getLogger(Driver.class);
	private Driver() {

	}

	public static void initDriver() throws Exception {
		log.debug("Reading browser value from properties file");
		String browser = ReadProperties.get(PropertyEnums.BROWSER);
		log.debug("Browser property retrived is "+browser);
		if(Objects.isNull(DriverManager.getDriver())) {
			log.debug("Driver instance is null");
			if(browser.equalsIgnoreCase("chrome"))
			{
				log.debug("Initializing driver instance with chromedriver");
				WebDriverManager.chromedriver().setup();
				DriverManager.setDriver(new ChromeDriver());
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				log.debug("Initializing driver instance with firefoxdriver");
				WebDriverManager.firefoxdriver().setup();
				DriverManager.setDriver(new FirefoxDriver());
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				DriverManager.setDriver(new EdgeDriver());
			}
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().get(ReadProperties.get(PropertyEnums.URL));
			log.info("URL launched successfully");

		}
	}

	public static void quitDriver() {
		log.info("Closing driver");
		if(Objects.nonNull(DriverManager.getDriver())){
			log.debug("CloseDriver: Driver instance is not null");
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
