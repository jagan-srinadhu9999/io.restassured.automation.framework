package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {

	private ExtentReport() {}

	private static	ExtentReports extent= new ExtentReports();
	
	private static ExtentTest test;
	

	public static void initReports()
	{
		extent= new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/index.html");
		extent.attachReporter(spark);
		
		
		
	}

	public static void tearDownReports()
	{
		extent.flush();
	}

	public static void createTest(String message)
	{
		 test=	extent.createTest(message);
		 ExtentManager.setExTest(test);
		
	}
}
