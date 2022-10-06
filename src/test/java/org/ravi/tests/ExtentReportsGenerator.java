package org.ravi.tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsGenerator {

	
		@Test
		public static void reportGenerator() throws IOException{
			ExtentReports extReport = new ExtentReports();
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter("index.html");
			extReport.attachReporter(sparkReporter);
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setDocumentTitle("Automation execution Report");
			sparkReporter.config().setReportName("Framework Creation");
			
			ExtentTest test = extReport.createTest("Test1");
			test.pass("Pass the first test");
			
			ExtentTest test1 = extReport.createTest("Test2");
			test1.fail("Fail the secondtest");
			
			extReport.flush();
			Desktop.getDesktop().browse(new File("index.html").toURI());
			
			
		}
}
