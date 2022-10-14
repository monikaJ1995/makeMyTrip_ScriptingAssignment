package org.makeMyTrip.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.makeMyTrip.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {
	
	
	public static String getScreenshot(String Str_testName){
		
		String path = "./Screenshots/"+Str_testName+".png";
		File ss = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
		File file = new File(path);
		try {
			FileUtils.copyFile(ss, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	

}
