package com.Rest.Util.org;

import com.github.javafaker.Faker;

public final class  FakerUtils {

	/*
	 *1. Faker is third part library to create dynamic data/values from run time.
	 * 2.the aim of this Service layer[the name it self Service, which is providing
	 * services to others[the main purpose of third party library's to use the services
	 * in our code]
	 * 3.Here we use Faker library methods so we create methods to use Access
	 * Modifier as "default"[the scope is with in package]
	 *4.I create Class as final so no one extends my Servicelayer Class
	 *5.I create private constructor why because i leverage my class scope no will
	 *create Constructor.
	 *6.Create a object of Faker with private final no one will access out side the
	 *class.
	 *7.Only i am exposing default access modifiers getters[services to use/access users from this util]
	 * 8.If in case any changes are happened from Service layer methods we can levirage
	 * from this class[required changes]
	 */


	private FakerUtils() {}

	private final static Faker faker = new Faker();


	static int getId(int startvalue,int endvalue)
	{

		return new Faker().number().numberBetween(startvalue, endvalue);
	}

	static String getfirstname(){

		return new Faker().name().firstName();
	}

	static String getlastname()
	{
		return new Faker().name().lastName();
	}
	static String getemail(String email)
	{
		return new Faker().expression(email);
	}
	static String getEmail()
	{
		return new Faker().internet().emailAddress();
	}
	{

	}

}
