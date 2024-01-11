package com.restcalls.org;

import static org.testng.Assert.fail;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.reports.ExtentLogger;
import com.reports.ExtentReport;

public class BaseTest {
private static  ExtentReports extent= new ExtentReports();
	
	@BeforeSuite
	public void setUPSuite()
	{
		 ExtentReport.initReports();
		
	}
	
	@BeforeMethod
	public void setUp(Method m)
	{
	ExtentReport.createTest(m.getName());
		
	}
	@AfterSuite
	public void tearDown()
	{
		ExtentReport.tearDownReports();
		
	}
	
	@AfterMethod
	public void teststatus(ITestResult result)
	{
	  if(!result.isSuccess())
	  {
		ExtentLogger.fail(String.valueOf(result.getThrowable()));
	  }
		
	}
	
	/*
	 * result = Reporter.getCurrentTestResult(); switch (result.getStatus()) { case
	 * ITestResult.SUCCESS: System.out.println("======PASS=====");
	 * ExtentLogger.pass("test-pass"); break;
	 * 
	 * case ITestResult.FAILURE: System.out.println("======FAIL=====");
	 * ExtentLogger.fail("my expected test result is fail"); break;
	 * 
	 * case ITestResult.SKIP: System.out.println("======SKIP BLOCKED====="); // my
	 * expected functionality here when passed break;
	 * 
	 * default: throw new RuntimeException("Invalid status"); }
	 */

}
