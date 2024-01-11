package com.restcalls.org;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvoderTest {
@Test(dataProvider = "getData1")
	public void test1(Map<String,String> data)
	{
		System.out.println("username "+ data.get("username"));
		System.out.println("password "+ data.get("password"));
		System.out.println("email "+ data.get("email"));
	}
	

@DataProvider
public Object[][] getData1()
{
	Object[][] data = new Object[3][1];
	Map<String,String> MAP=new HashMap<String,String>();
	MAP.put("username" , "jagan");
	MAP.put("password" , "srinadhu");
	MAP.put("email" , "jagan123@gmail.com");
	
	Map<String,String> MAP1=new HashMap<String,String>();
	MAP1.put("username" , "jagan");
	MAP1.put("password" , "srinadhu");
	MAP1.put("email" , "jagan123@gmail.com");
	
	Map<String,String> MAP2=new HashMap<String,String>();
	MAP2.put("username" , "jagan");
	MAP2.put("password" , "srinadhu");
	MAP2.put("email" , "jagan123@gmail.com");
	
	data[0][0]=MAP;
	data[1][0]=MAP1;
	data[2][0]=MAP2;
	
	return data;
}
	
	
	
	//@Test(dataProvider = "getData")
	public void test(String username,String password)
	{
		System.out.println("username : "+username+ " password : "+password);
	//	Assertions.assertThat(username).isEqualTo("fail");
	}
	
	@DataProvider
	public Object[][] getData()
	{
	//2-d represents
// 1.how many itterations, 2. how many parameters it is 3x2 matrix
		return new  Object[][] {
			{"ashbw","djikdn"},
			{"qgqsbj123","123qbsjn"},
			{"3y83nsndw","12y8bbnd"}
			
		};
	}
	
}
