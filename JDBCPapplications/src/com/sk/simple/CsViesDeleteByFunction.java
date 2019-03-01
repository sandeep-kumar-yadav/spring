package com.sk.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import oracle.jdbc.OracleTypes;

public class CsViesDeleteByFunction {
   
	

	/*
SQL> create or replace function  fx_view_delete_student(no in number,cnt out number)return sys_refcursor
  2  as
  3  details sys_refcursor;
  4  begin
  5  open details for
  6  select sno,sname,sadd from student where sno=no;
  7  delete from student where sno=no;
  8  cnt:=SQL%ROWCOUNT;
  9  return details;
 10  end;
 11  /

Function created.
*/
	private static final String INSERT_NUMBER="{?=call fx_view_delete_student(?,?)";
  
	public static void main(String[] args) {
		

	Scanner sc=null;
        int no=0;
        Connection con=null;
        java.sql.CallableStatement cs=null;
        boolean flag=false;
        ResultSet rs=null;
        
        try  {
	    
	  sc=new Scanner(System.in);
	  if(sc!=null) 
	   System.out.println("Enter Student no  :: ");
	   no=sc.nextInt();
	   
	   //regiser Driver
	//   Class.forName("oracle.jdbc.dirver.OracleDriver");
	   Class.forName("oracle.jdbc.driver.OracleDriver");

	  //establish the connection 
	   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
	   
	   if(con!=null)
		  cs=con.prepareCall(INSERT_NUMBER);
	  
	   if(cs!=null) {
		   
		   cs.registerOutParameter(1, OracleTypes.CURSOR);
		   cs.registerOutParameter(3, Types.INTEGER); 

		   
		   
	   }
	   // set the in param 
	   if(cs!=null)
	   {
		   
		   cs.setInt(2, no);
	   }
	   // call pl/sql query
	    if(cs!=null)  
	   cs.execute();
	   // gether the result
	    
	            rs=(ResultSet) cs.getObject(1);
	       
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
