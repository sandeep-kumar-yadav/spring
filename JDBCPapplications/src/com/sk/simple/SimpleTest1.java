

package com.sk.simple;
/*   so that in Emp table  count all student .
* Version:1.0
* Author: team-j
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Scanner;
import java.util.Scanner;


public class SimpleTest1 {
public static void main(String[] args) {
	Scanner sc=null;
	Connection con=null;
	Statement st=null;
	 int no=0;
	 String sName=null;
	 String sAdd=null;
	int count=0;
	 String query=null;
		try {
			  sc=new Scanner(System.in);
			  //read input
			  if(sc!=null)
			  {
			System.out.println("Enter Student NO  for Inserting :"); 
			 no=sc.nextInt();	  
			 sc.nextLine();
			 System.out.println("Enter Student Name :"); 
			 sName=sc.next();	
			 System.out.println("Enter Student City :"); 
			 sAdd=sc.next();	
			  }
	//    set driver	  
//	Class.forName("oracle,jdbc,driver,OracleDriver");
	  Class.forName("oracle.jdbc.driver.OracleDriver");

	
	  //  set connecton
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
	//   set statement 
  if(con!=null)
		  
  st=con.createStatement();   	 
	
        sName="'"+sName+"'";
        sAdd="'"+sAdd+"'";
  	  // INSERT INTO STUDENT VALUES(117,'kuldee','udaipur');

        query="INSERT INTO STUDENT VALUES("+no+","+sName+","+sAdd+")";
	 count=st.executeUpdate(query);
	            System.out.println(query);
		
			
		    
		    if(count==0) {
		    	System.out.println("No records are found for inseted");
		    	
		    	
		    }
		    else {
		    	System.out.println(count+"   no. of records are found for inseted");
		    	
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



