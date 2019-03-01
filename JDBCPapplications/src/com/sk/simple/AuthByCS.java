package com.sk.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.mysql.jdbc.CallableStatement;

public class AuthByCS {
   
	

	/*

SQL>  CREATE OR REPLACE PROCEDURE P_AUTH_PRO(user in varchar,passs in varchar,result out varchar)
  2      as
  3   v_count number(4);
  4      begin
  5      select count(*) into v_count from vali where uname=user and pass=passs;
  6      if(v_count<>0) then
  7      result:='VALID_CREDENTIALS';
  8      else
  9      result:='INVALID_CREDENTIALS';
 10  end if;
 11      END;
 12     /
  6  /

Procedure created.
	 */

	private static final String INSERT_NUMBER="{CALL P_AUTH_PRO(?,?,?)}";
  
	public static void main(String[] args) {
		

	Scanner sc=null;
        String user=null;
        String passs=null;
        Connection con=null;
        java.sql.CallableStatement cs=null;
       
        
        try  {
	    
	  sc=new Scanner(System.in);
	  if(sc!=null) 
	   System.out.println("Enter  User name:: ");
	   user=sc.next();
	   
	   System.out.println("Enter  password:: ");
	   passs=sc.next();
	   //regiser Driver
	//   Class.forName("oracle.jdbc.dirver.OracleDriver");
	   Class.forName("oracle.jdbc.driver.OracleDriver");

	  //establish the connection 
	   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
	   
	   if(con!=null)
		  cs=con.prepareCall(INSERT_NUMBER);
	  
	   if(cs!=null) {
		   
		   cs.registerOutParameter(3, Types.VARCHAR);
		
		
		   
		   
	   }
	   // set the in param 
	   if(cs!=null)
	   {
		   
		   cs.setString(1, user);
		   cs.setString(2, passs);
	   }
	   // call pl/sql query
	    if(cs!=null)  
	   cs.execute();
	   // gether the result
	    
	  
	       
		 System.out.println();
		   System.out.println(cs.getString(3));
		
	    
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
