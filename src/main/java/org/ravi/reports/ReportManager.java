package org.ravi.reports;

import com.aventstack.extentreports.ExtentTest;

public class ReportManager {

		private ReportManager() {
			
		}
		private static ThreadLocal<ExtentTest> et = new ThreadLocal<>();

		static synchronized ExtentTest getExtentTest() {

			return et.get();
		}

		static synchronized void setExtentTest(ExtentTest reportRef) {

			et.set(reportRef);
		}

		static void unload() {
			et.remove();
		}
}
