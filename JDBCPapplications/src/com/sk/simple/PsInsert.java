package com.sk.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PsInsert {
	private static final String INSERT_VALUE="insert into student values(?,?,?)";
 public static void main(String[] args) {
      Scanner sc=null;
      Connection con=null;
      PreparedStatement ps=null;
     int  count=0;
   
      int no=0;
      String name=null;
      String add=null;
       int result=0;
      try {
    	  
          sc=new Scanner(System.in);	 
          
          if(sc!=null)
        	  System.out.println("Enter the student number:: ");
              count=sc.nextInt();
    	  //conncet to driver
      Class.forName("oracle.jdbc.driver.OracleDriver");

    	  // Establish the connection 
    	  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");

    	  
    	  // prepare quer
    	
    	  //create Statement
    	  if(con!=null)
    		  ps=con.prepareStatement(INSERT_VALUE);
    	  //read multiple sets of input values from enduser
    	  
    	  if(sc!=null)
    	  { 
    		 for (int i = 1; i <= count; i++) {
			 
         System.out.println("Enter "+i+" Student deatails");  
         System.out.println("Enter number:: ");
         no=sc.nextInt();
         System.out.println("Enter name:: ");
         name=sc.next();
         System.out.println("Enter address:: ");
         add=sc.next();
         
         // set the input values read fromo enduser to query params
         ps.setInt(1, no);
         ps.setString(2, name);
         ps.setString(3, add);
         
         //  execute the query 
         
          result=ps.executeUpdate();
           if(result==0)
          System.out.println(i+"  Studnt details are not inserted");
           else
               System.out.println(i+"  Studnt details are  inserted");

    	  }// for
    		 
    	  } //if
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
