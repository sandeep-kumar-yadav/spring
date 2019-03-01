

package com.sk.simple;
/*   so that in Emp table  count all student .
* Version:1.0
* Author: team-j
*/


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
public static void main(String[] args) {
//loading & registration oracle driver
	Connection con=null;
	try {
	//	Class.forName("oracle.jdbc.driver.OracleDriver");
		  Class.forName("oracle.jdbc.driver.OracleDriver");

		System.out.println("Step 1");
		
	//	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhos:1521:ORACLE","scott","tiger");
		System.out.println("Step 2");
	 
		Statement st=con.createStatement();
		System.out.println("Step 3");
		
		//String q="insert into student values(1,'dilip','Core Java','6-8','6 months','H.K')";
		String q="select * from student";
		int c=st.executeUpdate(q);

		System.out.println(c+"Row Stored");
		
		con.close();
		
		
	} catch (ClassNotFoundException e) {
		System.out.println("ClassNotFoundException e");
	}
	catch(SQLException e1){
		e1.printStackTrace();
	}
}


	

	

	
}







