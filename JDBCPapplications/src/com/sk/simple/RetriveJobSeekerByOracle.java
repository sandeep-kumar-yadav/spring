package com.sk.simple;


import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;

public class RetriveJobSeekerByOracle {
    
	/*
	 *  create table Matrimony(aid int(10) primary key auto_increment,aName varchar(10),aAddr varchar(10),aGender varchar(6),aPhoto blob);
	 *  create table Matrimony(aid number(10),aName varchar2(10),aAddr varchar2(10),aGender varchar2(6),aPhoto blob);

Table created.

SQL> create sequence MATRIMONY_ID start with 1 increment by 1;
	 */
	private static final String INSERT_RESUME="SELECT * FROM JOBPORTAL WHERE JSID=?";

	public static void main(String[] args) {
	
		 Scanner sc=null;
		    String name=null;
		 
		    String qlfy=null;
		   
		    Connection con=null;
		    int id=0;
		    
		    PreparedStatement ps=null;
		  
		    Reader reader=null;
		    ResultSet rs=null;
		   
		    FileWriter writer=null;
		    char buffer[]=null;
		    int charsRead=0;
	  try {
		   sc=new Scanner(System.in);
		   if(sc!=null)
		   {
			   System.out.println("Enter App  jobseeker  id::  ");
		      id =sc.nextInt();
		  
		      
		       
		   }
		       
		       
		       //register driver
		     // Class.forName("oracle.jdbc.driver,OracleDriver");
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      
		      // establish the connection
		     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger"); 
		       
		   // create the PreparedStatement 
		     if(con!=null)
		    ps=con.prepareStatement(INSERT_RESUME);   
		    
		    ps.setInt(1, id);
		  
		    
		    
		    // execute the query
		    if(ps!=null)
		   rs=ps.executeQuery();
		    if(rs.next())
		    {
		    	  id=rs.getInt(1);
		         name=rs.getString(2);
		         qlfy=rs.getString(3);
		         
		         reader=rs.getCharacterStream(4);
		         
		         
		         System.out.println(id+"    "+name+"    "+qlfy);
		     
		         writer= new FileWriter("kuldeep.txt");  
		        buffer=new char[2048];
		        while((charsRead=reader.read(buffer))!=-1) {
		        	writer.write(buffer,0,charsRead);
		        	
		        }
	
		        
		  //      IOUtils.copy(reader, writer);
		    
		    
		    
		    }
		    System.out.println("resume get sucessfully ");
		 
		    
	  }
	  catch (SQLException se) {
			se.printStackTrace();

		}

		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
	catch (Exception e) {
			e.printStackTrace();
		} 
	finally {
		 // close JDBC objects
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException se) {
			se.printStackTrace();
  
		}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
      
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();

			}

			try {
				if (sc != null)
					con.close();
			} catch (Exception s) {
				s.printStackTrace();

			}
         
			try {
				if (reader != null)
					reader.close();
			} catch (Exception se) {
				se.printStackTrace();

			}
			try {
				if (writer != null)
				   writer.close();
			} catch (Exception se) {
				se.printStackTrace();

			}
	  }
	}
}

