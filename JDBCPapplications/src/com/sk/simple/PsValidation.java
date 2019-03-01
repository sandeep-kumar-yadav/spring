package com.sk.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PsValidation {
public static void main(String[] args) {
	Scanner sc=null;
	  String user=null,pass=null;
	  Connection con=null;
	  String query=null;
	  PreparedStatement ps=null;
	  ResultSet rs=null;
	  int result=0;
	  
	try {
	sc=new Scanner(System.in);
		
		if(sc!=null)
			System.out.println("Enter the Username:: ");
		   user=sc.next();
		   System.out.println("Enter the password:: ");
		   pass=sc.next();
		
	    // connect to the dirver
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		//  establish the connection 
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
		// create query
		 query="Select count(*) from vali where uname=? and pass=?";
		  // create the statements
		 
		 if(con!=null)
		 ps=con.prepareStatement(query);
		 //execute the query
	      
		   ps.setString(1, user);
		   ps.setString(2, pass);
		   
		   rs=ps.executeQuery();
		  if(rs.next())
		  result=rs.getInt(1);
		   if(result==0) {
			   
			   System.out.println("Invalid Credential");
		   }
		   else {
			   System.out.println("valid Credential");
		   }
		  
	}//try
	  catch(SQLException se) {
	    	 se.printStackTrace();
	    	  
	      }
	      catch(ClassNotFoundException cnf) {
	    	  cnf.printStackTrace();
	      }
	      catch(Exception e) {
	    	  e.printStackTrace();
	      }
	      finally {
	    	  try {
	    		  if(ps!=null)
	    			  ps.close();
	    	  }
	    	  catch(SQLException se)
	    	  {
	    		  se.printStackTrace();
	    		  
	    	  }
	    	  try {
	    		  if(con!=null)
	    	   con.close();
	    	  }
	    	  catch(SQLException se)
	    	  {
	    		  se.printStackTrace();
	    		  
	    	  }
	    	  
	    	  try {
	    		  if(sc!=null)
	    	   con.close();
	    	  }
	    	  catch(Exception s)
	    	  {
	    		  s.printStackTrace();
	    		  
	    	  }
	    	  

	}
}
}
