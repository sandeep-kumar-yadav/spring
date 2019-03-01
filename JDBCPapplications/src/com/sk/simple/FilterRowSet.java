package com.sk.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;

import com.mysql.jdbc.ResultSet;

import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleFilteredRowSet;
import oracle.jdbc.rowset.OracleJDBCRowSet;




public class FilterRowSet {

	public static void main(String[] args) {
		FilteredRowSet frset=null;
		try {
		
	           frset=new OracleFilteredRowSet();
	           frset.setUsername("scott");
	           frset.setPassword("tiger");
	           frset.setUrl("jdbc:oracle:thin:@localhost:1521:ORACLE");
		      
		       
		}//try 
		catch(SQLException se) {
			
			se.printStackTrace();
			}
		catch(Exception e) {
			
		e.printStackTrace();
		}
	} // main
} //class
