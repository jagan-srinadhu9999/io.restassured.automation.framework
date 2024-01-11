package com.jagan.constants;

import lombok.Getter;

public class FrameworkConstants {

	/*
	 * @Getter is comming from lambok , if field is non-static we can use class level
	 * or else if field is static we can use inside class .
	 */
	
	private static @Getter final String  REQUESTJSON_FOLDER_PATH=System.getProperty("user.dir")+"/src/test/java/Resources/request.json";
	private static @Getter final String  RESPONSEJSON_FOLDER_PATH=System.getProperty("user.dir")+"/Output/";
	private static @Getter final String  Property_File_PATH=System.getProperty("user.dir")+"/src/test/java/Resources/config.properties";
	
}
