package com.sk.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CsCursorFatchDetails {
   
	

	/*
SSQL> CREATE OR REPLACE PROCEDURE P_FATCHDETAILS(initChar in varchar,details out sys_refcursor)
  2  as
  3  begin
  4  open details for
  5  select sno,sname,sadd from student where sname like initChar;
  6  end;
  7  /

Procedure created.
	 */

	private static final String INSERT_NUMBER="{CALL P_FATCHDETAILS(?,?)}";
  
	public static void main(String[] args) {
		

	Scanner sc=null;
        String initChar=null;
        Connection con=null;
        java.sql.CallableStatement cs=null;
        boolean flag=false;
        ResultSet rs=null;
        
        try  {
	    
	  sc=new Scanner(System.in);
	  if(sc!=null) 
	   System.out.println("Enter Initial letter  :: ");
	   initChar=sc.next();
	   
	   //regiser Driver
	//   Class.forName("oracle.jdbc.dirver.OracleDriver");
	   Class.forName("oracle.jdbc.driver.OracleDriver");

	  //establish the connection 
	   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
	   
	   if(con!=null)
		  cs=con.prepareCall(INSERT_NUMBER);
	  
	   if(cs!=null) {
		   
		   cs.registerOutParameter(2, OracleTypes.CURSOR);
		
		   
		   
	   }
	   // set the in param 
	   if(cs!=null)
	   {
		   
		   cs.setString(1, initChar+"%");
	   }
	   // call pl/sql query
	    if(cs!=null)  
	   cs.execute();
	   // gether the result
	    
	            rs=(ResultSet) cs.getObject(2);
	       
	            if(rs!=null)
	            {
	            while(rs.next()) {
	            	flag=true;
	            	System.out.println(rs.getInt(1)+" \t"+rs.getString(2)+" \t"+rs.getString(3));
	            }	
	            	
	            }
		 if(flag==false)
		   System.out.println("data not found");
		 else
			 System.out.println("data found");
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
