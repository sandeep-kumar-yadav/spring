package com.sk.simple;

import java.io.File;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileInputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class RetriveDetalisMyCompanyStart2 {

	
	/*
	 * SELECT E_NAME,E_DESIG,E_SAL,E_DOJ,E_RESUME,E_PHOTO FROM MY_COMPANY WHERE E_ID=1001;

          Table created.
        create sequence E_ID_NO2 start with 1000 increment by 1;
    
	 SQL> desc my_company;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 E_ID                                               NUMBER(10)
 E_NAME                                             VARCHAR2(10)
 E_DESIG                                            VARCHAR2(10)
 E_SAL                                              NUMBER(10)
 E_DOJ                                              DATE
 E_RESUME                                           CLOB
 E_PHOTO                                            BLOB

		 */
	  private static final String SELECT_DETAILS="SELECT E_NAME,E_DESIG,E_SAL,E_DOJ,E_RESUME,E_PHOTO FROM MY_COMPANY WHERE E_ID=?";

	public static void main(String[] args) {
		
		  Scanner sc=null;
		  int id=0;
	   String ename=null;
	   String edesig=null;
	   double esal=0.0;
	   String edoj=null;
	   String eresume=null;
	   String ephoto=null;
	   Connection con=null;
	   PreparedStatement ps=null;
	    int result=0;
	    InputStream is=null;
		FileReader reader=null;
		FileWriter writer=null;
		long length=0l;
		File file=null;
		 ResultSet rs=null;
		  boolean flag=false;
		  java.sql.Date sqdoj=null;
		  java.util.Date udoj=null;
		  SimpleDateFormat sdf=null;
		  int charsRead=0;
		  int bytesRead=0;
		  char[] buffer=null;
		  byte[] buffer1=null;
		  FileOutputStream os=null;
		try
		{
		  sc=new  Scanner(System.in);
		  System.out.println("Enter Employee ID::  ");
		     id= sc.nextInt();
		 
	       
	       //register Driver
	       
	       Class.forName("oracle.jdbc.driver.OracleDriver");
	       
	       // create the connection 
	       
	       con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
	       
	         //  create the  preparedStatement 
	        if(con!=null)	
	        	
	       ps=con.prepareStatement(SELECT_DETAILS);
	         
	       
	        if(ps!=null) {
	         ps.setInt(1, id);
	        }
	     	
	         if(ps!=null)
		    	  rs=ps.executeQuery();
		         
		          
		           if(rs!=null) 
		           {
			          if(rs.next()) {
			        	  flag=true;
			        	   id=rs.getInt(1);
			        	   ename=rs.getString(2);
			        	   edesig=rs.getString(3);
			        	   esal=rs.getDouble(4);
			        	 sqdoj=rs.getDate(5);
			        	  is=rs.getBinaryStream(6);
			        	 
			        	  System.out.println(ename);
			        	 
			        	 
			        	 
			        	 //   date retriving   .........................................
			        	 //convert java.sql.Date to java.util.Date 
			        	
			        	   udoj=sqdoj;
			        	   //convert   java.util.Date to class object to string date 
			        	   sdf=new SimpleDateFormat("MMM-dd-yyy");
			        	 
			        	 
			        	   edoj=sdf.format(udoj);

			        	   //............................................................
			        	   
			        	   //  text file retriving ......................................
			        	  
			        	   writer= new FileWriter("kuldeep.txt");  
					        buffer=new char[2048];
					        while((charsRead=reader.read(buffer))!=-1) {
					        	writer.write(buffer,0,charsRead);
					        }
			        	 // phot retriving 
					        
						       
					         os= new FileOutputStream("sk.jpg");  
					       buffer1=new byte[4096]; 
					       
					       while((bytesRead=is.read(buffer1))!=-1)
					       {
					    	   os.write(buffer1,0,bytesRead);
					       }
			
	        
			          }
	     
	       if(flag==true)
	       {
	    	   System.out.println("data  inserted ");
	       }
	       {
	    	   System.out.println("data not succesfull");
	    	   
	       }
	        
	        	
	       
	          
		           } 
	       
		} // try 
		
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
