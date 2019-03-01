package com.sk.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class AgeCalculaotrMySql {
	
	// select year(curdate())-year(dob) from dateformat1 where sno=1;
	private static final String INSERT_VAL="select year(curdate())-year(dob) from dateformat1 where sno=?";
  public static void main(String[] args) {
	Scanner sc=null;
	  int sno=0;
	  Connection con=null;
	  PreparedStatement ps=null;
	  ResultSet rs=null;
	   double result=0.0;
	try {
		sc= new Scanner(System.in);
		if(sc!=null) {
			System.out.println("Enter Sno  for Age Calculate :: ");
			 sno=sc.nextInt();
			
			
		}
		   // register driver 
       
		 Class.forName("com.mysql.jdbc.Driver");
	    // establish the connection 
		con=DriverManager.getConnection("jdbc:mysql:///sandeep", "root", "root");

	    //
	    if(con!=null)
	    	//execute the query
	     ps=con.prepareStatement(INSERT_VAL);
	     //set the value in query  
	    ps.setInt(1, sno);
	    	 
	      
	        if(ps!=null)
	    	  rs=ps.executeQuery();
	         
	          
	           if(rs!=null) 
	           {
		          while(rs.next()) {
		        	 result=rs.getDouble(1);
                    System.out.println("Age is :: "+result);		        	  
		          }
	           }
	         
	               
	}
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
	    		  if(rs!=null)
	    	   rs.close();
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