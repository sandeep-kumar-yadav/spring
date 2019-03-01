package com.sk.simple;


import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;


import oracle.jdbc.rowset.OracleCachedRowSet;




public class CachedRowSet1 {

	public static void main(String[] args) {
		CachedRowSet crset=null;
		try {
	           crset=new OracleCachedRowSet();
	           crset.setUsername("scott");
	           crset.setPassword("tiger");
	           crset.setUrl("jdbc:oracle:thin:@localhost:1521:ORACLE");
		       crset.setCommand("select * from student");
	           crset.execute();
		       
	           
  // process the RowSet
	           System.out.println("before modification");
	           while(crset.next()) {
	        	   
	        	   
	        	   System.out.println(crset.getInt(1)+"   \t"+crset.getString(2)+"   \t" +crset.getString(3));
	          
	           }
	           
	      Thread.sleep(40000);
	      crset.absolute(3);
	      crset.updateInt(1, 5555);
	      crset.updateString(2, "mukesh");
	      crset.updateString(3, "mp");
	      crset.updateRow();
	      System.out.println("RowSet update in offline mode");
	      
	      Thread.sleep(40000);  // restart DB s/w here 
	      crset.acceptChanges();
	      
	      
		}//try 
		catch(SQLException se) {
			
			se.printStackTrace();
			}
		catch(Exception e) {
			
		e.printStackTrace();
		}
	} // main
} //class
