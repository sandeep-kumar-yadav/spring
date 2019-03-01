package com.sk.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.mysql.jdbc.CallableStatement;

import oracle.jdbc.OracleTypes;

public class CsByFunctionEmpDetails {
   
	

	/*SQL> create or replace function fx_fetch_EmpDetails
  2  (
  3  no in number,
  4  name out varchar,
  5  salary out number,
  6  desg out varchar
  7  )
  8   return number
  9  is
 10  dno number;
 11  begin
 12      select ename,job,sal,deptno into name,desg,salary,dno from emp where empno=no;
 13      return dno;
 14      end;
 15      /
	 */

	private static final String INSERT_NUMBER="{?=call fx_fetch_EmpDetails(?,?,?,?)}";
  
	public static void main(String[] args) {
		

	Scanner sc=null;
        int no=0;
        Connection con=null;
        java.sql.CallableStatement cs=null;
        int result=0;
        
        try  {
	    
	  sc=new Scanner(System.in);
	  if(sc!=null) 
	   System.out.println("Enter  Employee no:: ");
	   no=sc.nextInt();
	   
	   //regiser Driver
	//   Class.forName("oracle.jdbc.dirver.OracleDriver");
	   Class.forName("oracle.jdbc.driver.OracleDriver");

	  //establish the connection 
	   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
	   
	   if(con!=null)
		  cs=con.prepareCall(INSERT_NUMBER);
	  
	   if(cs!=null) {
		   
		   cs.registerOutParameter(1, OracleTypes.INTEGER); 
		   cs.registerOutParameter(3, Types.VARCHAR);
		   cs.registerOutParameter(4, Types.INTEGER); 
		  cs.registerOutParameter(5, Types.VARCHAR);
		 

	   }
	   // set the in param 
	   if(cs!=null)
	   {
		   
		   cs.setInt(2, no);
	   }
	   // call pl/sql query
	   System.out.println("test 1");
	    if(cs!=null)  
	    	
	   cs.execute();
	   // gether the result
	    
	     ///   rs=cs.getObject()
	       System.out.println("test 2");
	       
		   System.out.println("   Emp  is:: "+cs.getInt(1));
		 //  System.out.println("   Emp  is:: "+cs.getInt(8));

		   System.out.println("   Emp Name is:: "+cs.getString(2));

		//   System.out.println("   Emp Name is:: "+cs.getString(2));
		//	   System.out.println("   Emp Name is:: "+cs.getInt(3));
		  // System.out.println("   Emp Adderess is:: "+cs.getString(4));
		 
	    
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
