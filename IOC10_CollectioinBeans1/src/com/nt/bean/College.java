package com.nt.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class College {
    private Map<String,String> FacultyName;

	public void setFacultyName(Map<String,String> facultyName) {
		FacultyName = facultyName;
	}

	@Override
	public String toString() {
		return "College [FacultyName=" + FacultyName + "]";
	}
    
}