package org.ravi.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public final class GenerateReport {

	private static  ExtentReports extReport;


	private GenerateReport() {

	}

	public static void intiReports() {
		if(Objects.isNull(extReport)) {
			extReport = new ExtentReports();
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("index.html");
			extReport.attachReporter(sparkReporter);
			sparkReporter.config().setTheme(Theme.STANDARD);
			sparkReporter.config().setDocumentTitle("Automation execution Report");
			sparkReporter.config().setReportName("Framework Creation");
		}
	}
	public static void flushReports() throws IOException {
		if(Objects.nonNull(extReport)) {
			extReport.flush();
		}
		Desktop.getDesktop().browse(new File("index.html").toURI());
	}

	public static void createTest(String testCaseName) {

		ReportManager.setExtentTest(extReport.createTest(testCaseName));

	}
}
