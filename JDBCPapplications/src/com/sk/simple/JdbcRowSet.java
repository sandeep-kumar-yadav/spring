package com.sk.simple;

import java.sql.SQLException;

import oracle.jdbc.rowset.OracleJDBCRowSet;




public class JdbcRowSet {

	public static void main(String[] args) {
		OracleJDBCRowSet jrset=null;
		try {
			
	           jrset=new OracleJDBCRowSet();
	           jrset.setUsername("scott");
	           jrset.setPassword("tiger");
	           jrset.setUrl("jdbc:oracle:thin:@localhost:1521:ORACLE");
		       jrset.setCommand("select * from student");
	           jrset.execute();
		       
	           // process the RowSet
	           
	           while(jrset.next()) {
	        	   
	        	   
	        	   System.out.println(jrset.getInt(1)+"   \t"+jrset.getString(2)+"   \t" +jrset.getString(3));
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
