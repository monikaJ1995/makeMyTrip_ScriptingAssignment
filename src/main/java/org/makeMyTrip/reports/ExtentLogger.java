package org.makeMyTrip.reports;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String logMessage) {
		ReportManager.getExtentTest().pass(logMessage);	
	}

	public static void fail(String logMessage) {
		ReportManager.getExtentTest().fail(logMessage);
	}

	public static void skip(String logMessage) {
		ReportManager.getExtentTest().skip(logMessage);
	}
}
