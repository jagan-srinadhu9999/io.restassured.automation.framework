package com.restcalls.org;

import java.lang.reflect.Method;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.Rest.Util.org.ApiUtils;
import com.Rest.Util.org.RandomUtils;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jagan.constants.FrameworkConstants;
import com.jagan.constants.FrameworkContantsSigleton;
import com.reports.ExtentLogger;
import com.reports.ExtentManager;
import com.reports.ExtentReport;
import com.requestpayload.org.RequestBuilder;

import io.restassured.response.Response;
import lombok.SneakyThrows;

public class PutCall extends BaseTest {

	//@Test
	@SneakyThrows
	public void putRequestUsingExtenalFile(Method method)
	{

		String resource=ApiUtils.readJsonGetAsString(FrameworkConstants.getREQUESTJSON_FOLDER_PATH())
				.replace("number", String.valueOf(RandomUtils.getId()))			
				.replace("fname", RandomUtils.getfirstname())
				.replace("lname", RandomUtils.getlastname());

		Response response=	
				RequestBuilder.buildRequestForPut()
				.pathParam("id", "2")
				.body(resource)
				.put("/Employes/{id}");

		//ExtentManager.getExTest().pass(MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));
		ExtentLogger.logResponse(response.asPrettyString());
		
		ApiUtils.storeJsonResponseString(FrameworkConstants.getRESPONSEJSON_FOLDER_PATH()+method.getName()+"response1.json", response); 

		Assertions.assertThat(response.getStatusCode())
		.isEqualTo(200);

		/*
		 * Response response= given() .baseUri("http://localhost:3000") .pathParam("id",
		 * "45") .log().all() .get("/Employes/{id}");
		 */


	}
	@Test
	@SneakyThrows
	public void putRequestUsingExtenalFile1(Method method)
	{

		String resource=ApiUtils.readJsonGetAsString(FrameworkContantsSigleton.getInstance().getREQUESTJSON_FOLDER_PATH())
				.replace("number", String.valueOf(RandomUtils.getId()))			
				.replace("fname", RandomUtils.getfirstname())
				.replace("lname", RandomUtils.getlastname());

		Response response=	
				RequestBuilder.buildRequestForPut()
				.pathParam("id", "2")
				.body(resource)
				.put("/Employes/{id}");

		//ExtentManager.getExTest().pass(MarkupHelper.createCodeBlock(response.asPrettyString(), CodeLanguage.JSON));
		ExtentLogger.logResponse(response.asPrettyString());
		
		ApiUtils.storeJsonResponseString(FrameworkContantsSigleton.getInstance().getRESPONSEJSON_FOLDER_PATH()+method.getName()+"response1.json", response); 

		Assertions.assertThat(response.getStatusCode())
		.isEqualTo(200);

		/*
		 * Response response= given() .baseUri("http://localhost:3000") .pathParam("id",
		 * "45") .log().all() .get("/Employes/{id}");
		 */


	}

}
