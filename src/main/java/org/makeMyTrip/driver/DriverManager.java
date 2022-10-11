package org.makeMyTrip.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public final class DriverManager {
	Logger log = LogManager.getLogger(DriverManager.class);
	private DriverManager() {

	}
	private static ThreadLocal<WebDriver> dr = new ThreadLocal();

	public static synchronized WebDriver getDriver() {
		
		return dr.get();
	}

	public  static synchronized void setDriver(WebDriver driverRef) {

		dr.set(driverRef);
	}

	public static void unload() {
		dr.remove();
	}
}
