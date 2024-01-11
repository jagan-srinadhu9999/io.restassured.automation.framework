package com.jagan.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder(setterPrefix = "set")
public class Student {

	private int Id;
	private String fname;
	private String lname;
	private String email;
	
	Student(){}
	
	
	
	
}
