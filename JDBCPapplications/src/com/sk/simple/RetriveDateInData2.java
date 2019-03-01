package com.sk.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class RetriveDateInData2 {
	
	//SELECT SNO,SNAME,DOB,DOJ FROM DATEFORMAT1 WHERE SNO=2;
	private static final String INSERT_VAL="SELECT SNO,SNAME,DOB,DOJ FROM DATEFORMAT1 WHERE SNO=?";
  public static void main(String[] args) {
	Scanner sc=null;
	  int sno=0;
	String name;
	  Connection con=null;
	  PreparedStatement ps=null;
	  ResultSet rs=null;
	  boolean flag=false;
	  java.sql.Date sqdob=null,sqdoj=null;
	  java.util.Date udob=null,udoj=null;
	  SimpleDateFormat sdf=null;
	   String sdob=null,sdoj=null;
	try {
		sc= new Scanner(System.in);
		if(sc!=null) {
			System.out.println("Enter SNO:: ");
			 sno=sc.nextInt();
			
			
		}
		   // register driver 
        Class.forName("oracle.jdbc.driver.OracleDriver");

	    // establish the connection 
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");

	    //
	    if(con!=null)
	    	
	     ps=con.prepareStatement(INSERT_VAL);
	       ps.setInt(1, sno);
	    	 
	      
	        if(ps!=null)
	    	  rs=ps.executeQuery();
	         
	          
	           if(rs!=null) 
	           {
		          while(rs.next()) {
		        	  flag=true;
		        	   sno=rs.getInt(1);
		        	   name=rs.getString(2);
		        	   sqdob=rs.getDate(3);
		        	   sqdoj=rs.getDate(4);
		        	   //convert java.sql.Date to java.util.Date 
		        	   
		        	   udob=sqdob;
		        	   udoj=sqdoj;
		        	   //convert   java.util.Date to class object to string date 
		        	   sdf=new SimpleDateFormat("MMM-dd-yyy");
		        	   sdob=sdf.format(udob);
		        	   sdoj=sdf.format(udoj);
		        	   
		        	   System.out.println(sno+"  \t "+name+"  \t  "+sdob+"  \t  "+sdoj);
		        	   
                    		        	  
		          }
	           }
		        	if(flag==true) {
		        		System.out.println("  Record are  display");
		        	}
		        	else {
		        		System.out.println("   Record are not display !");

		        		
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