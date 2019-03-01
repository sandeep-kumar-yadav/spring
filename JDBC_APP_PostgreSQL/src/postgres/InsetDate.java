package postgres;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.sql.PreparedStatement;
public class InsetDate {
	
   //	yyyy-mm-dd format e.g., 2000-12-31.
	
	//CREATE TABLE DATEFORMAT(sno number(10),sname varchar(10),dob varchar2(10),doj varchar2(10));
	private static final String INSERT_VAL="INSERT INTO DATEFORMAT1(sno,sanme,dob,doj) VALUES(?,?,?,?)";
  public static void main(String[] args) throws ParseException {
	Scanner sc=null;
	int sno=0;
	String name=null;
	  String dob=null;
	  String doj=null;
	  Connection con=null;
	  PreparedStatement ps=null;
	  int result=0;
	
	try {
		sc= new Scanner(System.in);
		if(sc!=null) {
			System.out.println("Enter sno:: ");
			sno=sc.nextInt();
			System.out.println("Enter Name:: ");
			name=sc.next();
			System.out.println("Enter DOB:: ");
			dob=sc.next();
			
			System.out.println("Enter DOJ:: ");
			doj=sc.next();
			
		}
		   // execute driver 
//        Class.forName("com.mysql.jdbc.Driver");

	    // establish the connection 
   	 con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "root");
 

	    //
	    if(con!=null)
	    	
	     ps=con.prepareStatement(INSERT_VAL);
	     
	      
	    	  
	    	  SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	    		java.util.Date dob1=sdf.parse(dob);
	    		//long ms=dob1.getTime();
	    		java.sql.Date jsd=new java.sql.Date(dob1.getTime());
	    		
	    		SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
	    		java.util.Date doj2=sdf1.parse(doj);
	    	//	long ms1=doj2.getTime();
	    		java.sql.Date jsd1=new java.sql.Date(doj2.getTime());
	    		 if(ps!=null)
	    	  ps.setInt(1, sno);		 
	    	  ps.setString(2, name);
	    	  ps.setDate(3, jsd);
	    	  ps.setDate(4, jsd1);
	    	  
	      
	      
	         //  execute the query 
	         
	          result=ps.executeUpdate();
	           if(result==0)
	          System.out.println(" Studnt details are not inserted");
	           else
	               System.out.println(" Studnt details are  inserted");
	               
	}
	  catch(SQLException se) {
	    	 se.printStackTrace();
	    	  
	      }
	/*    
	catch(ClassNotFoundException cnf) {
	    	  cnf.printStackTrace();
	      }
	      catch(Exception e) {
	    	  e.printStackTrace();
	      }  */
	      finally {
	    	  try {
	    		  if(ps!=null)
	    			  ps.close();
	    	  }
	    	  catch(SQLException se)
	    	  {
	    		  se.printStackTrace();
	    		  
	    	  }
	    	  try {
	    		  if(con!=null)
	    	   con.close();
	    	  }
	    	  catch(SQLException se)
	    	  {
	    		  se.printStackTrace();
	    		  
	    	  }
	    	  
	    	  try {
	    		  if(sc!=null)
	    	   con.close();
	    	  }
	    	  catch(Exception s)
	    	  {
	    		  s.printStackTrace();
	    		  
	    	  }
	    	  
	    	  
	
	
}
}
}