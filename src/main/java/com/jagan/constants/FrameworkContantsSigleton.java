package com.jagan.constants;

import lombok.Getter;

@Getter
public class FrameworkContantsSigleton {
//sigle ton --->single instance for an class for a particular point of time
	//creational design pattern
	
	private static FrameworkContantsSigleton INSTANCE=null;
	
	private FrameworkContantsSigleton() {}
	
	public static synchronized FrameworkContantsSigleton getInstance() //10 threads
	{
		if(INSTANCE == null)
		{
			INSTANCE=new FrameworkContantsSigleton();
		}
		return INSTANCE;
	}
	private   final String  REQUESTJSON_FOLDER_PATH=System.getProperty("user.dir")+"/src/test/java/Resources/request.json";
	private  final String  RESPONSEJSON_FOLDER_PATH=System.getProperty("user.dir")+"/Output/";
	private static  final String  Property_File_PATH=System.getProperty("user.dir")+"/src/test/java/Resources/config.properties";
	
}
