package com.nt.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Student {
     
	  private int marks[];
	 List<String> names;
	 
	public void setNames(List<String> names) {
		this.names = names;
	}

	@Override
	public String toString() {
		return "User [marks=" + Arrays.toString(marks) + ", names=" + names + "]";
	}
	 
}