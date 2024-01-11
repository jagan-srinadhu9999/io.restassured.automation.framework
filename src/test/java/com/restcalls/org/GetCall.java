package com.restcalls.org;

import static io.restassured.RestAssured.DEFAULT_BODY_ROOT_PATH;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.reports.ExtentLogger;
import com.reports.ExtentManager;
import com.reports.ExtentReport;
import com.requestpayload.org.RequestBuilder;

import io.restassured.response.Response;
public class GetCall extends BaseTest {


	@Test
	public void getEmployees()
	{

		Response response=	RequestBuilder.buildRequestForGet()
				.get("/Employes");

		response.prettyPrint();
		assertThat(response.statusCode())
		.isEqualTo(200);
		
		//ExtentReport.getExTest().pass(response.asPrettyString());
		/*
		 * for response report we got it on json format
		 */
		
		ExtentLogger.pass("test-passed");
		ExtentLogger.logResponse(response.asPrettyString());
		
		System.out.println(response.jsonPath().getList(DEFAULT_BODY_ROOT_PATH).size());
		int  size=	response.jsonPath().getList(DEFAULT_BODY_ROOT_PATH).size();
		assertThat(response.jsonPath().getList("$").size())
		.isEqualTo(size);


	}
	//@Test(dataProvider = "getData")
	public void getEmployee(Integer id,String first_Name,String last_Nmae)
	{

		Response response=	RequestBuilder.buildRequestForGet()
				.pathParam("id", id)
				.get("/Employes/{id}");


		ExtentLogger.logResponse(response.asPrettyString());

		assertThat(response.getStatusCode())
		.isEqualTo(200);
		assertThat(response.jsonPath().getString("first_Name"))
		.isEqualTo(first_Name)
		.hasSizeBetween(2, 10);

		assertThat(response.jsonPath().getString("last_Nmae"))
		.isEqualToIgnoringCase(last_Nmae)
		.hasSizeBetween(1, 10);
		/*
		 * String body = response.getBody().asString(); String headerValue =
		 * response.getHeader("headerName"); String cookieValue =
		 * response.getCookie("cookieName"); System.out.println(body);
		 * System.out.println(headerValue); System.out.println(cookieValue);
		 * 
		 * Message message = get("/Employes").as(Message.class);
		 * System.out.println(message);
		 */
	}

	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {
			{1,"srinadhu","jagan"},
			{3,"brock","lesnar"},
			{10,"sachin","tendulkar"},
			{4,"pawan","kalyan"}
		};
	}
	@Test(dataProvider = "getData1")
	public void getEmployee1(Map<String,String> data)
	{

		Response response=	RequestBuilder.buildRequestForGet()
				.pathParam("id", data.get("id"))
				.get("/Employes/{id}");


		//ExtentReport.getExTest().pass(response.asPrettyString());

		//ExtentManager.getExTest().pass(MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));
		
		ExtentLogger.logResponse(response.asPrettyString());
		
		assertThat(response.getStatusCode())
		.isEqualTo(201);
		assertThat(response.jsonPath().getString("first_Name"))
		.isEqualTo(data.get("first_Name"))
		.hasSizeBetween(2, 18);

		assertThat(response.jsonPath().getString(("last_Nmae")))
		.isEqualToIgnoringCase(String.valueOf(data.get("last_Nmae")))
		.hasSizeBetween(2, 18);

		/*
		 * String body = response.getBody().asString(); String headerValue =
		 * response.getHeader("headerName"); String cookieValue =
		 * response.getCookie("cookieName"); System.out.println(body);
		 * System.out.println(headerValue); System.out.println(cookieValue);
		 * 
		 * Message message = get("/Employes").as(Message.class);
		 * System.out.println(message);
		 */
	}
	@DataProvider
	public Object[][] getData1()
	{
		Object[][] data=new Object[4][1];

		Map<String,String> MAP=new HashMap();
		MAP.put("id","1" );
		MAP.put("first_Name", "srinadhu");
		MAP.put("last_Nmae", "jagan");

		Map<String,String> MAP1=new HashMap();
		MAP1.put("id","3" );
		MAP1.put("first_Name", "brock");
		MAP1.put("last_Nmae", "lesnar");

		Map<String,String> MAP2=new HashMap();
		MAP2.put("id","10" );
		MAP2.put("first_Name", "sachin");
		MAP2.put("last_Nmae", "tendulkar");

		Map<String,String> MAP3=new HashMap();
		MAP3.put("id","4" );
		MAP3.put("first_Name", "pawan");
		MAP3.put("last_Nmae", "kalyan");

		data[0][0] = MAP;
		data[1][0] = MAP1;
		data[2][0] = MAP2;
		data[3][0] = MAP3;
		return data;

	}

}
