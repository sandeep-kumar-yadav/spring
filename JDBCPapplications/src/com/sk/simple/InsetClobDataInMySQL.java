package com.sk.simple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsetClobDataInMySQL {
    
	/* 
	 *   create table jobPortal (jsid int(10) primary key auto_increment,jsname varchar(10),qlfy varchar(10),resume text);
	 *  INSERT INTO JOBPORTAL VALUES(JSID_SNO.NEXTVAL,?,?,?);
Table created.

SQL> create sequence MATRIMONY_ID start with 1 increment by 1;
	 */
	private static final String INSERT_RESUME="INSERT INTO JOBPORTAL VALUES(?,?,?)";

	public static void main(String[] args) {
	
	   Scanner sc=null;
	    String name=null;
	 
	    String qlfy=null;
	    String resumePath=null;
	    Connection con=null;
	    
	    PreparedStatement ps=null;
	    File file=null;
	    FileReader reader=null;
	    long length=0l;
	    int result=0;
	  try {
		   sc=new Scanner(System.in);
		   if(sc!=null)
		   {
			   System.out.println("Enter jobseeker Name::  ");
		       name=sc.next();
		  
		       System.out.println("Enter jobseeker qlfy::  ");
		       qlfy=sc.next();
		       sc.nextLine();
		       
		       System.out.println("upload resume::  ");
		       resumePath=sc.next();
		       
		   }
		   //register driver
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      
		      Class.forName("com.mysql.jdbc.Driver");
		      // establish the connection
		  //   con=DriverManager.getConnection("jdbc.mysql:///sandeep","root","root"); 
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep", "root", "root");

		     
			   // create the PreparedStatement 
			     if(con!=null)
			    ps=con.prepareStatement(INSERT_RESUME);   
			     
		       //locate the file 
		        file=new File(resumePath);
		        length=file.length();
		        reader=new FileReader(file);
		    //   System.out.println(file);
		      //  System.out.println(reader);
		        
		        
		   if(ps!=null) {
		    ps.setString(1, name);
		    ps.setString(2, qlfy);
		    
		    ps.setClob(3, reader,(int)length);
		   }
		    
		    // execute the query
		    if(ps!=null)
		    result=ps.executeUpdate();
		     
		    if(result==0) {
		    	System.out.println("data not inserted");
		    }
		    else {
		    System.out.println("data inserted");	
		    }
		    
	  }
	  catch(SQLException se) {
	    	 se.printStackTrace();
	    	  
	      }
	  
	catch(ClassNotFoundException cnf) {
	    	  cnf.printStackTrace();
	      }
	  
	  catch(FileNotFoundException fnf) {
    	  fnf.printStackTrace();
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
	    		  if(reader!=null)
	    	   reader.close();
	    	  }
	    	  catch(Exception e)
	    	  {
	    		  e.printStackTrace();
	    		  
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

