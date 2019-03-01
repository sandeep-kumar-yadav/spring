

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


public class SimpleTest2 {
public static void main(String[] args) {
	Scanner sc=null;
	Connection con=null;
	Statement st=null;

	 ResultSet rs=null;
	 boolean flag=false;

	
	int count=0;
	 String query=null;
		try {
			  sc=new Scanner(System.in);
			  //read input
			  if(sc!=null)
			  {
			System.out.println("Enter SQL query"); 
			 query=sc.nextLine();	  
			
			  }
	//    set driver	  
//	Class.forName("oracle,jdbc,driver,OracleDriver");
	  Class.forName("oracle.jdbc.driver.OracleDriver");

	
	  //  set connecton
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
	//   set statement 
  if(con!=null)
		  
  st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);   	 
	
  //  st=con.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability)
  	  // INSERT INTO STUDENT VALUES(117,'kuldee','udaipur');

       
     
	   flag=st.execute(query);
	   if (flag==true) {
		   
	   rs=st.getResultSet();
	   
	   if(rs.previous()) {
		   System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getNString(3));
	   }
	   }
	   else {
		   
	    System.out.println("non-select query is exexted");
	   count=st.getUpdateCount();
	   System.out.println("on. of records that are effected "+count);
	   }
	   

	       
	 
		
	} // try
	
	
	 catch(SQLException sql) {
		 if(sql.getErrorCode()==12899) {
				System.out.println("Value is too large plz enter from 0 to 10 only");
				
			}
		 else if(sql.getErrorCode()==942) {
			 System.out.println("This table not created !");
			 
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



