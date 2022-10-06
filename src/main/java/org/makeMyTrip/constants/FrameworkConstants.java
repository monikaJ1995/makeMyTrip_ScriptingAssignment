package org.makeMyTrip.constants;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}
	
	private static String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static String CHROMEDRIVERPATH = RESOURCESPATH+"/executables/chromedriver.exe";
	private static String CONFIGFILEPATH = RESOURCESPATH+"/config/config.properties";
	private static int EXPLIXITWAITTIME = 10;
	
	public static int getExplicitWaitTime() {
		return EXPLIXITWAITTIME;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static String getChromrDriverPath() {
		return CHROMEDRIVERPATH;
	}


}
