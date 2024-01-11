package com.restcalls.org;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.requestpayload.org.RequestBuilder;
import static com.Rest.Util.org.RandomUtils.*;

import com.Rest.Util.org.ApiUtils;
import com.Rest.Util.org.RandomUtils;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jagan.constants.FrameworkConstants;
import com.jagan.pojo.Student;
import com.reports.ExtentLogger;
import com.reports.ExtentManager;
import com.reports.ExtentReport;

import io.restassured.response.Response;
public class PostCall extends BaseTest{
     
	@Test
	public void test()
	{
		
	 	Student reqdata =Student.builder()
		.setId(getId())
		.setFname(getfirstname())
		.setLname(getlastname())
		.setEmail(getEmail()).build();
	 /*
	  * Read data from external file	
	  */
String reqdata1=ApiUtils.readJsonGetAsString(FrameworkConstants.getREQUESTJSON_FOLDER_PATH())
	 	.replace("number", String.valueOf(RandomUtils.getId()))
	 	.replace("fname", RandomUtils.getfirstname())
	 	.replace("lname", RandomUtils.getlastname()); //arrrange
	 	
	 	Response response=	RequestBuilder.buildRequestForPost()
	 	                             .body(reqdata1)
	 	                             .post("/Employes"); //actions
	 	

	 	/*
	 	 * Write response in external file
	 	 */
	 	ApiUtils.storeJsonResponseString(FrameworkConstants.getRESPONSEJSON_FOLDER_PATH()+"postresponse1.json", response);
	 
	 	Assertions.assertThat(response.getStatusCode()) //assertions
	 	.isEqualTo(201)
	 	.isPositive();
	
	 	/*
	 	 * ExtentReports
	 	 */
	 	//ExtentReport.getExTest().pass(response.asPrettyString());
	 	//	ExtentManager.getExTest().pass(MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));
	
	 	ExtentLogger.logResponse(response.asPrettyString());
	}
	
	
}
