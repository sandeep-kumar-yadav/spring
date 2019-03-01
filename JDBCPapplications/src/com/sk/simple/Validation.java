

package com.sk.simple;
/*   so that in Emp table  count all student .
* Version:1.0
* Author: team-j
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Scanner;
import java.util.Scanner;


public class Validation {
public static void main(String[] args) {
	Scanner sc=null;
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	 String user=null;
	 String passs=null;
	
	  int count=0;
	 String query=null;
		try {
			  sc=new Scanner(System.in);
			  //read input
			  if(sc!=null)
			  {
			System.out.println("Enter userName:"); 
			 user=sc.nextLine();	  
			
			 System.out.println("Enter Password :"); 
			 passs=sc.nextLine();	
				
			  }
	//    set driver	  
//	Class.forName("oracle,jdbc,driver,OracleDriver");
	  Class.forName("oracle.jdbc.driver.OracleDriver");

	
	  //  set connecton
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
	//   set statement 
  if(con!=null)
		  
  st=con.createStatement();   	 
	user="'"+user+"'";
	passs="'"+passs+"'";
  	  //  select count(*) from vali where uname='sandeep'AND pass='yadav';

       // query="select count(*) from vali where uname="+user1+"AND pass="+passs1;

	       
        query="SELECT COUNT(*) FROM VALI WHERE UNAME="+user+" AND PASS="+passs;
      if(st!=null)  

    	  rs=st.executeQuery(query);
	
	    if(rs.next())
	  count=rs.getInt(1);
	     //  System.out.println(query);
	               
		    if(count==0) {
		    	System.out.println("invalid Credential !");
		    	
		    	
		    }
		    /*    else if(count==1)
		  {
		    	System.out.println("username and password is vallied !");s
		    }  */
		    else {
		    //	System.out.println("another problem!");
		    	System.out.println("valid Credential !");
		    	
		    } 
	       
	 
		
	} // try
	
	
	 catch(SQLException sql) {
		 if(sql.getErrorCode()==12899) {
				System.out.println("Value is too large plz enter from 0 to 10 only");
				
			}
			else{
				
				System.out.println("Invalid SQL Commend/Query");
			}
	 }
	 catch(ClassNotFoundException cnf) {
		 System.out.println(cnf.toString());
		 
	 }     
	catch(Exception e) {
        e.printStackTrace();		 
	 }  
	
	finally {
		
		
		
		try {
			if(st!=null)
				st.close();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		try {
			if(con!=null)
				con.close();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		try {
			if(sc!=null)
				sc.close();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		
		
	}

	
}



}



