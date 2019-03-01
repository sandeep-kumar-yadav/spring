package com.sk.simple;


import java.text.SimpleDateFormat;

public class WorkingWithDate {
public static void main(String[] args) throws Exception {
    /*
	  String dob="10-04-1996";
	 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date dob1=sdf.parse(dob);
		//long ms=dob1.getTime();
		java.sql.Date jsd=new java.sql.Date(dob1.getTime());
		System.out.println(jsd);
		*/
		
	String s1="24-10-1995";
	System.out.println("self date Format:: "+s1);
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	java.util.Date ud1=sdf.parse(s1);
	
	System.out.println("Util date Object:: "+ud1);
	
	
	//converting java.util.Date  to java.sql.Date  
	
	long ms=ud1.getTime();
	java.sql.Date jsd=new java.sql.Date(ms);
  System.out.println("sql date Object ::  "+jsd);
  
  
}
}
