package com.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	private static ThreadLocal<ExtentTest> exTest=new ThreadLocal<>(); 
	
	 static ExtentTest getExTest() {
		return exTest.get();
	}

	 static void setExTest(ExtentTest ExTest) {
		exTest.set(ExTest);
	}

	
	
}
class Demo{
	public static void main(String[] args) {
		String s=new String("8");
		System.out.println(1+10+s+1+10);
	}
}
