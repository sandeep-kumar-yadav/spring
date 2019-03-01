package com.sk.simple;


import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class RetriveMatrmony {
    
	/*
	 *  create table Matrimony(aid int(10) primary key auto_increment,aName varchar(10),aAddr varchar(10),aGender varchar(6),aPhoto blob);
	 *  create table Matrimony(aid number(10),aName varchar2(10),aAddr varchar2(10),aGender varchar2(6),aPhoto blob);

Table created.

SQL> create sequence MATRIMONY_ID start with 1 increment by 1;
	 */
	private static final String INSERT_PHOTO="SELECT  ANAME,AADDR,AGENDER,APHOTO FROM MATRIMONY WHERE AID=?";

	public static void main(String[] args) {
	
	   Scanner sc=null;
	    String name=null;
	    String addr=null;
	    String gender=null;
	    Connection con=null;
	    PreparedStatement ps=null;
	    InputStream is=null;
	    int sno=0;
	    ResultSet rs=null;
	    FileOutputStream os=null;
	    byte buffer[]=null;
	   int bytesRead=0;
	  try {
		   sc=new Scanner(System.in);
		   if(sc!=null)
		   {
			   System.out.println("Enter App  sno::  ");
		       sno=sc.nextInt();
		  
		      
		       
		   }
		       
		       
		       //register driver
		     // Class.forName("oracle.jdbc.driver,OracleDriver");
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      
		      // establish the connection
		     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger"); 
		       
		   // create the PreparedStatement 
		     if(con!=null)
		    ps=con.prepareStatement(INSERT_PHOTO);   
		    
		    ps.setInt(1, sno);
		  
		    
		    
		    // execute the query
		    if(ps!=null)
		   rs=ps.executeQuery();
		    if(rs.next())
		    {
		    	 name=rs.getString(1);
		         addr=rs.getString(2);
		         gender=rs.getString(3);
		         is=rs.getBinaryStream(4);
		         System.out.println(name+"y   "+addr+"    "+gender);
		       
		         os= new FileOutputStream("sk.jpg");  
		       buffer=new byte[4096]; 
		       
		       while((bytesRead=is.read(buffer))!=-1)
		       {
		    	   os.write(buffer,0,bytesRead);
		       }
		  
		    
		    
		    
		    }
		    System.out.println("photo uploaded sucessfully ");
		 
		    
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

