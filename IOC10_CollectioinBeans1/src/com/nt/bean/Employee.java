package com.nt.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Employee {
   
	private Properties empDesg;

	public void setEmpDesg(Properties empDesg) {
		this.empDesg = empDesg;
	}

	@Override
	public String toString() {
		return "Employee [empDesg=" + empDesg + "]";
	}
    
}