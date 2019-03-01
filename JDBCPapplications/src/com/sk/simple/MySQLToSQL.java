package com.sk.simple;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLToSQL {
	private static final String ORACLE_INSERT="INSERT INTO BANK VALUES(?,?,?,?)";
			private static final String MYSQL_SELECT="SELECT bid,holderName,addr,bal FROM BANK";		
	public static void main(String[] args) {
		 Connection oracleCon=null;
		 Connection  con=null;
		 PreparedStatement ps=null;
		
		 Statement st=null;
		 ResultSet rs=null;
		 int bid=0;
		 String holderName=null;
		 String addr=null;
		 int bal=0;
		 int result=0;
		try {
			//connect to oracle driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// connect to the mysql driver
		Class.forName("com.mysql.jdbc.Driver");
		
		// satblish the connetion in oracle 
		//con=DriverManager.getConnection()
		
		oracleCon=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger");
		// stablish the connnection for mysql 
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep", "root", "root");
		
		 if(con!=null)
		    	// create statement for mysql
		    st=con.createStatement();
		  
		    //st=mysqlCon.createStatement(); 
		    
		     //set the query
		    rs=st.executeQuery(MYSQL_SELECT);
		    while(rs.next())
		    {
		    	bid=rs.getInt(1);
		        holderName=rs.getString(2);
		        addr=rs.getString(3);
		        bal=rs.getInt(4);
		  //      System.out.println(bid+"    "+holderName+"    "+addr+"    "+bal);
		    
		
		    
		if(oracleCon!=null)
		{
			ps=oracleCon.prepareStatement(ORACLE_INSERT);
		     
		    ps.setInt(1, bid);
		    ps.setString(2, holderName);
		    ps.setString(3, addr);
		    ps.setDouble(4, bal);
		    
		    if(ps!=null)
		    	result=ps.executeUpdate();
		   
		
		}  
		    }
		    if(result==0)
		          System.out.println(" records not insert ");
		           else
		               System.out.println(" records are inserted into oracle !");

		
		}
		
		catch(SQLException se) {
		   se.printStackTrace();	
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				if(oracleCon!=null) 
				oracleCon.close();	
				}	
			catch(SQLException se) {
				se.printStackTrace();
				
			}
			try {
				if(con!=null) 
				con.close();	
				}	
			catch(SQLException se) {
				se.printStackTrace();
				
			}
			try {
				if(st!=null) 
				st.close();	
				}	
			catch(SQLException se) {
				se.printStackTrace();
				
			}
			try {
				if(ps!=null) 
				ps.close();	
				}	
			catch(SQLException se) {
				se.printStackTrace();
				
			}
			try {
				if(rs!=null) 
				rs.close();	
				}	
			catch(SQLException se) {
				se.printStackTrace();
				
			}
			
			
		}
		
		
		
		
	}

}
