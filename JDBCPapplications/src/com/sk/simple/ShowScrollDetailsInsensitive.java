package com.sk.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Scanner;
import java.util.Scanner;
public class ShowScrollDetailsInsensitive {
	private static final String SELECT_STU=" select sno,sname,sadd  from student";

public static void main(String[] args) {
	Scanner sc=null;
	Connection con=null;
	Statement st=null;
	ResultSet rs=null;
		try {
			 
			 
	//    set driver	  
//	Class.forName("oracle,jdbc,driver,OracleDriver");
	  Class.forName("oracle.jdbc.driver.OracleDriver");

	
	  //  set connecton
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
	//   set statement 
  if(con!=null)
		  
  st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);   	 
	
        
  	  
             if(st!=null)
            rs=st.executeQuery(SELECT_STU);
               if(rs!=null)   {
				/*
				 * Thread.sleep(20000);
				 *                                                for sensitive and insensitive checking 
				 * while(rs.next()) {
				 * 
				 * 
				 * System.out.println(rs.getInt(1)+" \t "+rs.getString(2)+"  \t"+rs.getString(3)
				 * ); }
			
				 */
				/*
				 * rs.moveToInsertRow(); 
				 * rs.updateInt(1, 231);             // for inserting value
				 * rs.updateString(2, "ram");
				 * rs.updateString(3, "ayodhya");
				 *  rs.insertRow();
				 */
			  
				/*
				 * rs.absolute(3); //row line no. rs.updateString(3, "new ayodhya"); // in all
				 * any one choose for updating rs.updateRow();
				 */
            	   
            	   
            	   //  deleting 
            	   
            	   rs.absolute(2);
            	   rs.deleteRow();
            	   
            	   
            	   
		      
		    
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




	

