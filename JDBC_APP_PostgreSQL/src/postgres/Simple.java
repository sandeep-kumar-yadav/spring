



package postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.Class;
public class Simple {

	/**
	 * @param args
	 */
	public static void main(String[] args)   {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		boolean flag=false;
	  try {
		  
 Class.forName("org.postgresql.Driver");
		  //Establish the connection
	//	  con=DriverManager.getConnection("jdbc:postgresql:example", "sandeep", "sandeep");
	 con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "root");
		  //create Statement object
		  if(con!=null)
		    st=con.createStatement();
		  //send and execute SQL Query in DB s/w
		  if(st!=null)
			  rs=st.executeQuery("SELECT *  FROM student WHERE SNO=101");
		  //process the ResultSet
		  if(rs!=null) {
			  while(rs.next()) {
				  flag=true;
				  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
			  }//while
		  }//if
		  if(!flag)
			  System.out.println("Record not found");
		  else
			  System.out.println("Records found and displayed");
			  
	  }
  catch(ClassNotFoundException cnf) {
		  cnf.printStackTrace();
  }
	  catch(SQLException se) {
		  se.printStackTrace();
	  }
	  finally {
		  //close jdbc objs
		  try {
			  if(rs!=null)
				  rs.close();
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
			  if(con!=null)
				  con.close();
		  }
		  catch(SQLException se) {
			  se.printStackTrace();
		  }
	  }//finally
	}//main
}//class
