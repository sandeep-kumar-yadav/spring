package com.sk.simple;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class FlexibleTest {
 public static void main(String[] args) {
	
	 
    InputStream is=null;
    Properties props=null;
    Connection con=null;
    Statement st=null;
    String driver=null,url=null,user1=null,pass1=null;
	try {
		 // locate properties file
		is=new FileInputStream("src/com/sk/simple/DbDetials.properties");
		
		// load properties file data into  properties class obj
		
		 props = new Properties();
		
		 props.load(is);
		
		 //  read jdbc properties from properties file
		 
		 driver=props.getProperty("jdbc.driver");
		 url=props.getProperty("jdbc.url");
		 user1=props.getProperty("jdbc.user");
		 pass1=props.getProperty("jdbc.pass");
		 ResultSet rs=null;
		 
		System.out.println(props);
		 
		 
			/*
			 * // register jdbc driver
			 * 
			 * Class.forName(driver);
			 * 
			 * // establish the connection
			 * 
			 * con=DriverManager.getConnection(url,user1,pass1);
			 */
		 
			
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			  
			  System.out.println("Step 1");
			  
			  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger"); System.out.println("test");
			 
			
		 // create statement
		 
		 
		// st=con.createStatement();
		 if(con!=null)
		 st=con.createStatement();
		 
		 //send wquery
		 if(st!=null)
		 rs=st.executeQuery("SELECT SNO,SNAME,SADD FROM STUDENT");
		 
		 
		 
		 if(rs!=null)
		 {
			 while(rs.next())
			 {
		  System.out.println(rs.getInt(1)+"    "+rs.getString(2) +"    "+rs.getString(3));		 
				 
				 
			 }
			 
		 }
		 
		 
		 
		 
		 
		 
		 
		
		 
		 
		 
	} //try
	
     catch (ClassNotFoundException e) {
		System.out.println("ClassNotFoundException");
	}
	catch(SQLException e1){
		e1.printStackTrace();
	}

      catch(Exception e) {
    	  e.printStackTrace();
      }

	
} // main
  
}//class