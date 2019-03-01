package com.sk.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class psInsertAIValue {
	private static final String INSERT_VAL="insert into student values(INSERT_VALUE.nextval,?,?)";
	
	
 public static void main(String[] args) {
	 while(true) {
      Scanner sc=null;
      Connection con=null;
      PreparedStatement ps=null;
     
      String name=null;
      String add=null;
       int result=0;
       int swit=0;
       // FOR CASE 2
       Statement st=null;
       ResultSet rs=null;
       boolean flag=false;
      try {
    	  sc=new Scanner(System.in);	 
          System.out.println("Enter 1 for Insert and Enter 2 for other !");
          swit=sc.nextInt();
          
          Class.forName("oracle.jdbc.driver.OracleDriver");

			
		  //  set connecton
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
		//   set statement 
    	  switch(swit) {
    	  case 1:
    		 
    	  //create Statement
    	  if(con!=null)
    		  ps=con.prepareStatement(INSERT_VAL);
    	  //read multiple sets of input values from enduser
    	  
    	  if(sc!=null)
    	  { 
    		
       
         System.out.println("Enter name:: ");
         name=sc.next();
         System.out.println("Enter address:: ");
         add=sc.next();
         
         // set the input values read fromo enduser to query params
         
         ps.setString(1, name);
         ps.setString(2, add);
         
         //  execute the query 
         
          result=ps.executeUpdate();
           if(result==0)
          System.out.println(" Studnt details are not inserted");
           else
               System.out.println(" Studnt details are  inserted");
               } //if
    	  break;
    	  
    	  
    	  case 2:
    		   Class.forName("oracle.jdbc.driver.OracleDriver");

   			
    			  //  set connecton
    			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
    			//   set statement 
    		 
    	  if(con!=null)
    			  
    	  st=con.createStatement();   	 
    	        if(st!=null)
    		 rs=st.executeQuery("SELECT * FROM STUDENT");
    	           System.out.println();
    		          while(rs.next()) {
    		        	  flag=true;
    		        	  System.out.println("       "+rs.getInt(1)+" \t "+rs.getString(2)+" \t "+rs.getString(3));
    		          }
    		        	if(flag==true) {
    		        		System.out.println("  Record are  display");
    		        	}
    		        	else {
    		        		System.out.println("   Record are not display !");

    		        		
    		        	}
    		        	
    		        	
    		          
    			
    			//	
    			 

    		            break;
    		            
    		            
    	  default:
    		  System.out.println("please enter only 1 or 2   "); 
    	  }//switch
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
} // while 
 }
}
