package com.sk.simple;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MyCompanyStart {

	
	  private static final String INSERT_DETAILS="INSERT INTO my_company values(E_ID_NO2.NEXTVAL,?,?,?,?,?,?)";
	/*
	 * create table my_company(e_id number(10),e_name varchar2(10),e_desig varchar2(10),e_sal number(10),e_doj date,e_resume clob,e_photo blob);

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
	
	
	public static void main(String[] args) {
		
		  Scanner sc=null;
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
		long length=0l;
		File file=null;
		try
		{
		  sc=new  Scanner(System.in);
		  System.out.println("Enter Employee name::  ");
		     ename= sc.nextLine();
		   System.out.println("Enter Employee designation:: ");
		   edesig=sc.next();
			System.out.println("Enter Employee Salary:: ");
			esal=sc.nextDouble();
		
			
	        System.out.println("Enter Employee Date of Joining :: ");
		   edoj=sc.next();
		   System.out.println("Upload your file url ::  ");
	       eresume=sc.next();
	       System.out.println("Upload your photo url :: ");
		      ephoto=sc.next();
	       
	       //register Driver
	       
	       Class.forName("oracle.jdbc.driver.OracleDriver");
	       
	       // create the connection 
	       
	       con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
	       
	         //  create the  preparedStatement 
	        if(con!=null)	
	        	
	       ps=con.prepareStatement(INSERT_DETAILS);
	         
	        //   for date 
	    	SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
    		java.util.Date doj2=sdf1.parse(edoj);
    	//	long ms1=doj2.getTime();
    		java.sql.Date jsd1=new java.sql.Date(doj2.getTime());
    		 
    		
    	    
		       //locate the file 
		       
			        file = new File(eresume);
		        length = file.length();
		        reader=new FileReader(file);
    		
		        // photo inserting 
		        
		        
		        file=new File(ephoto);
		    //    length=file.length();
		      //  is=new FileInputStream(file);
		        is=new FileInputStream(file);
		        
    		
	        if(ps!=null) {
	         ps.setString(1, ename);
	         ps.setString(2, edesig);
	         ps.setDouble(3, esal);
	         ps.setDate(4, jsd1);
	         ps.setCharacterStream(5,reader,(int)length);
	         ps.setBinaryStream(6, is,length);
	        
	        
	        }
	        if(ps!=null) 
	        {
	       result=ps.executeUpdate();
	        }
	       if(result==0)
	       {
	    	   System.out.println("data not inserted ");
	       }
	       {
	    	   System.out.println("data inserted succesfull");
	    	   
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
