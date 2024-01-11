package com.Rest.Util.org;

public final class RandomUtils {

	/*
	 * 1.business layer--->from this layer we use the methods from "servicelayer"
	 * 2.For suppose if any business changes are occured from project we can change
	 * from this class only
	 */
	
	
	private RandomUtils() {}
	
	public static int getId()
	{
		return FakerUtils.getId(1, 2000);
	}
	
	public static String getfirstname()
	{
		return FakerUtils.getfirstname().toLowerCase();
	}
	public static String getlastname()
	{
		return FakerUtils.getlastname().toLowerCase();
	}

	/*
	 * public static String getemail() { return
	 * FakerUtils.getemail("abcdf@gmail.com"); }
	 */
	public static String getEmail()
	{
		return FakerUtils.getEmail();
	}
}
