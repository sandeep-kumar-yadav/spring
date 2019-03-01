package com.sk.simple;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MatrimonyMySql {
    
	/*  create table Matrimony(aid int(10) primary key auto_increment,aName varchar(10),aAddr varchar(10),aGender varchar(6),aPhoto blob);
	 *  create table Matrimony(aid number(10),aName varchar2(10),aAddr varchar2(10),aGender varchar2(6),aPhoto blob);

Table created.

SQL> create sequence MATRIMONY_ID start with 1 increment by 1;
	 */
	private static final String INSERT_PHOTO="INSERT INTO MATRIMONY(aName,aAddr,aGender,aPhoto) VALUES(?,?,?,?)";

	public static void main(String[] args) {
		
	   Scanner sc=null;
	    String name=null;
	    String addr=null;
	    String gender=null;
	     String photoPath=null;
	     File file=null;
	     InputStream is=null;
	     Connection con=null;
	     PreparedStatement ps=null;
	     int result=0;
	     long length=0l;
	  try {
		   sc=new Scanner(System.in);
		   if(sc!=null)
		   {
			   System.out.println("Enter App Name::  ");
		       name=sc.next();
		  
		       System.out.println("Enter App Addr::  ");
		       addr=sc.next();
		       
		       System.out.println("Entet App Gender::  ");
		       gender=sc.next();
		       
		       System.out.println("Enter App PHOTOPATH::  ");
		       photoPath=sc.next();
		       
		   }
		       
		        file=new File(photoPath);
		        length=file.length();
		        is=new FileInputStream(file);
		        
		        
		       //register driver
		      Class.forName("com.mysql.jdbc.Driver");
		    //establish the connection 
				con=DriverManager.getConnection("jdbc:mysql:///sandeep", "root", "root");
         
				if(con!=null)
	               ps=con.prepareStatement(INSERT_PHOTO);
		      
				//set values to query params
				if(ps!=null)		
		      {    
		    ps.setString(1, name);
		    ps.setString(2, addr);
		    ps.setString(3, gender);
		    ps.setBinaryStream(4, is,length);
		    
		     }
		    // execute the query
		    if(ps!=null)
		    result=ps.executeUpdate();
		     //process the result
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

