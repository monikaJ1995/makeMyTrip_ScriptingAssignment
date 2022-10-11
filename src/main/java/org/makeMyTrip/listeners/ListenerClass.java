package org.makeMyTrip.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.makeMyTrip.driver.DriverManager;
import org.makeMyTrip.generics.Screenshot;
import org.makeMyTrip.reports.ExtentLogger;
import org.makeMyTrip.reports.GenerateReport;
import org.makeMyTrip.reports.ReportManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener , ISuiteListener{
	
	@Override
	public void onStart(ISuite suite) {
		GenerateReport.intiReports();
	}
	
	@Override
	public void onFinish(ISuite suite) {
		try {
			GenerateReport.flushReports();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		GenerateReport.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+ " is passed");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName()+ " is failed");
		String path = Screenshot.getScreenshot(result.getMethod().getMethodName());
//		File ss = ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
//		File file = new File(path);
//		try {
//			FileUtils.copyFile(ss, file);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		ReportManager.getExtentTest().addScreenCaptureFromPath(path, result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+ " is skipped");
	}
		
}
