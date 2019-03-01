package com.nt.bean;

import java.util.Date;

public class User {

	
	private int no;
	  private String name;
	  private Date doj;
	  
	  public User(int no, String name, Date doj) {
		super();
		this.no = no;
		this.name = name;
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + ", doj=" + doj + "]";
	}

	
	
}
