
package com.sk.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PsSelect {
 public static void main(String[] args) {
      Scanner sc=null;
      Connection con=null;
      PreparedStatement ps=null;
     ResultSet rs=null;
     String query=null;
     boolean flag=false;
      try {
    	  
          sc=new Scanner(System.in);	 
          
         
    	  //conncet to driver
      Class.forName("oracle.jdbc.driver.OracleDriver");

    	  // Establish the connection 
    	  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");

    	  
    	  // prepare quer
    	  query="select * from student";
    	  //create Statement
    	  if(con!=null)
    		  ps=con.prepareStatement(query);
    	  //execute the query
    	  rs=ps.executeQuery();
    	  
    	  while(rs.next()) {
    		  flag=true;
    		  
    	System.out.println(rs.getInt(1)+" \t"+rs.getString(2)+"  \t"+rs.getString(3));
    	  }
    	  
    	if(flag==true) {
    		 
    		System.out.println("records valid and display !");
    	}	 
    	else {
    		
    		System.out.println("records are invalid not display");
    	}
      }  //try
      
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
