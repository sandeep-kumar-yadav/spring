package com.sk.simple;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.sql.SQLException;

import oracle.jdbc.rowset.OracleJDBCRowSet;
import oracle.jdbc.rowset.OracleWebRowSet;

public class WebRowSet {
	
	public static void main(String[] args) {
		OracleWebRowSet wrset=null;
		try {
			
	           wrset=new OracleWebRowSet();
	           wrset.setUsername("scott");
	           wrset.setPassword("tiger");
	           wrset.setUrl("jdbc:oracle:thin:@localhost:1521:ORACLE");
		       wrset.setCommand("select * from student");
		    // execute the query
		          
		       wrset.execute();
		       //create or locate file
		       File file=new File("G:/student1.xml");
		       
	           FileWriter fw=new FileWriter(file);
	           
	           wrset.writeXml(fw);
	           
	           //convert  xml to a String object for display purpose
	           StringWriter sw =new StringWriter();
	           
	           wrset.writeXml(sw);
	           System.out.println(sw.toString());
	           
	           fw.flush();
	           fw.close();
	           // process the RowSet
	           
	           while(wrset.next()) {
	        	   
	        	   
	        	   System.out.println(wrset.getInt(1)+"   \t"+wrset.getString(2)+"   \t" +wrset.getString(3));
	           }
		}//try 
		catch(SQLException se) {
			
			se.printStackTrace();
			}
		catch(Exception e) {
			
		e.printStackTrace();
		}
	} // main
} //class
