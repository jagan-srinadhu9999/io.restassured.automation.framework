package com.Listners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.reports.ExtentReport;

public class TestListner implements ITestListener,ISuiteListener {

	@Override//@BeforeSuite
	public void onStart(ISuite suite) {
		 ExtentReport.initReports();
	  }
	@Override//@AfterSuite
	public void onFinish(ISuite suite) {
		ExtentReport.tearDownReports();
	  }
	@Override //@Beforemethod
	public void onTestStart(ITestResult result) {
	    
	  }
	
	public void onTestSuccess(ITestResult result) {
	    
	  }
	
	public void onTestFailure(ITestResult result) {
	    
		
	  }
}
