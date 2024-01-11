package com.Rest.Util.org;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.jagan.constants.FrameworkConstants;
import com.rest1.enums.PropertyType;

public final class PropertyUtils {

	private PropertyUtils() {}

	//read the content from propertyfile and store it in hashmap
	//read the content only once and store it in some java collection.

	private static final	Properties properties =new Properties();
	private static final     Map<String,String> MAP=new HashMap();

	/*
	 * Generic exception, some one has to make call
	 * try with resource it automatically close the inputstream
	 * before the whole test execution starts
	 * closebale class is automatically closes
	 */
	
	
	 static 
	      {
		try(FileInputStream	inputstream=new FileInputStream(FrameworkConstants.getProperty_File_PATH());) {

			properties.load(inputstream);
		} catch (IOException e) {

			e.printStackTrace();
			System.exit(0);
		}

		//	properties.entrySet().forEach(e-> MAP.put(String.valueOf(e.getKey()),String.valueOf( e.getValue())));

		for(Map.Entry<Object, Object> temp : properties.entrySet())
		{

			String key=	 String.valueOf(temp.getKey());
			String value=	String.valueOf(temp.getValue());

			MAP.put(key, value);

		}
    
		
	}
	 public static String getValue(PropertyType key)
     {
    	 
		 return MAP.get(key.name().toLowerCase());
		 
     }



}
