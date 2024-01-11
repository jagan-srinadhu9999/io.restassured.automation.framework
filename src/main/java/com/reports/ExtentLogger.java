package com.reports;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public final class ExtentLogger {

	
  private ExtentLogger() {}
  
  public static void pass(String message)
  {
	  ExtentManager.getExTest().pass(message);
  }
  
  public static void fail(String message)
  {
	  ExtentManager.getExTest().fail(message);
  }
  
  public static void info(String message)
  {
	  ExtentManager.getExTest().info(message);
  }
  
  public static void logResponse(String message)
  {
	  ExtentManager.getExTest().info(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
		
  }
}
