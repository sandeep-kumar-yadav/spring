package com.sk.simple;





import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MatrimonyMySql2 {
    
	/*
	 *  create table Matrimony(aid int(10) primary key auto_increment,aName varchar(10),aAddr varchar(10),aGender varchar(6),aPhoto blob);

Table created.

	 */
	private static final String INSERT_PHOTO="INSERT INTO MATRIMONY(aName,aAddr,aGender,aPhoto) VALUES(?,?,?,?)";
public static void main(String[] args) {

    Scanner sc=null;
    String name=null;
    String addr=null;
    String gender=null;
    String photoPath=null;
    File file=null;
    long length=0;
    FileInputStream fis=null;
    Connection con=null;
    PreparedStatement ps=null;
    int result=0;
    
    try {
  	  //read inputs
  	  sc=new Scanner(System.in);
  	  if(sc!=null) {
  		  System.out.println("Enter Applicanent Name:");
  		  name=sc.next();
  		  System.out.println("Enter Applicanent Addr:");
  		  addr=sc.next();
  		  System.out.println("Enter gender:");
  		  gender=sc.next();
  		  System.out.println("Enter Applicanent Photo Location:");
  		  sc.nextLine();
  		  photoPath=sc.next();

        	  }//if
  	  
  	  //locate the photo file
  	  
  	
  	  file=new File(photoPath);
  	  //get the length of the file
  	  length=file.length();
  	  //create input holding photo location
  	  fis=new FileInputStream(file);
  	
  	//register jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//establish the connection
		con=DriverManager.getConnection("jdbc:mysql:///sandeep", "root", "root");
		
		//create preparedStatement object
		if(con!=null) 
			ps=con.prepareStatement(INSERT_PHOTO);
		  //set value to query param
		if(ps!=null) {
			ps.setString(1, name);
			ps.setString(2, addr);
			ps.setString(3, gender);
			ps.setBlob(4, fis);
		
		}
  	 //execute the query
		if(ps!=null)
		result=ps.executeUpdate();
		//process the result
		if(result==0) 
			System.out.println("Record Not Inserted");
		else
			System.out.println("Record Inserted");
    
    }//try
		    
	  
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

