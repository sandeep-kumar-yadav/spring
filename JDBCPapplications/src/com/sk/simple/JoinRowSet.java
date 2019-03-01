package com.sk.simple;

import java.sql.SQLException;

import oracle.jdbc.rowset.OracleJoinRowSet;

public class JoinRowSet {

	public static void main(String[] args) {
		OracleJoinRowSet frset=null;
		try {
		
	           frset=new OracleJoinRowSet();
	           frset.setUsername("scott");
	           frset.setPassword("tiger");
	           frset.setUrl("jdbc:oracle:thin:@localhost:1521:ORACLE");
		       
		}//try ''
		catch(SQLException se) {
			
			se.printStackTrace();
			}
		catch(Exception e) {
			
		e.printStackTrace();
		}
	} // main
} //class
