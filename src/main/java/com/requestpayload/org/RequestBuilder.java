package com.requestpayload.org;
import static io.restassured.RestAssured.given;

import com.Rest.Util.org.PropertyUtils;
import com.rest1.enums.PropertyType;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
public final class RequestBuilder {
	
	private RequestBuilder(){}
	
	public static RequestSpecification buildRequestForGet()
	{
		return given()
				.baseUri(PropertyUtils.getValue(PropertyType.BASEURL))
				.log()
				.all();
	}
	public static RequestSpecification buildRequestForPost()
	{
		
		return buildRequestForGet()
				.header("Content-Type",ContentType.JSON);
	}
	public static RequestSpecification buildRequestForPut()
	{
		
		return buildRequestForGet()
				.header("Content-Type",ContentType.JSON);
	}

	
	
}
