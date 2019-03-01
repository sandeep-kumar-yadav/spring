package com.sk.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.mysql.jdbc.CallableStatement;

public class RetriveStuDetailsByCS2 {
   
	

	/*
SQL> CREATE OR REPLACE PROCEDURE P_getEmpDetails(no in number,name out varchar,salary out number,desg out varchar)
  2  as
  3  begin
  4  select ename,esal,edesg into name,salary,desg from emp111 where eno=no;
  5  end;
  6  /

Procedure created.
	 */

	private static final String INSERT_NUMBER="{CALL P_getEmpDetails(?,?,?,?)}";
  
	public static void main(String[] args) {
		

	Scanner sc=null;
        int no=0;
        Connection con=null;
        java.sql.CallableStatement cs=null;
        int result=0;
        
        try  {
	    
	  sc=new Scanner(System.in);
	  if(sc!=null) 
	   System.out.println("Enter  Emp no:: ");
	   no=sc.nextInt();
	   
	   //regiser Driver
	//   Class.forName("oracle.jdbc.dirver.OracleDriver");
	   Class.forName("oracle.jdbc.driver.OracleDriver");

	  //establish the connection 
	   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
	   
	   if(con!=null)
		  cs=con.prepareCall(INSERT_NUMBER);
	  
	   if(cs!=null) {
		   
		   cs.registerOutParameter(2, Types.VARCHAR);
		   cs.registerOutParameter(3, Types.INTEGER);
		   cs.registerOutParameter(4, Types.VARCHAR);
		   
		   
	   }
	   // set the in param 
	   if(cs!=null)
	   {
		   
		   cs.setInt(1, no);
	   }
	   // call pl/sql query
	    if(cs!=null)  
	   cs.execute();
	   // gether the result
	    
	  
	       
		   System.out.println("   Emp Name is:: "+cs.getString(2));
		   System.out.println("   Emp salary is:: "+cs.getInt(3));
		   System.out.println("   Emp Desg  is:: "+cs.getString(4));
	    
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
			if (cs != null)
				cs.close();
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

	}//finally
  } //  main
}  // class
