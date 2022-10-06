package org.ravi.listeners;

import java.io.IOException;

import org.ravi.reports.ExtentLogger;
import org.ravi.reports.GenerateReport;
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
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+ " is skipped");
	}
		
}
