package com.sk.simple;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;




public class MiniProject_Fatch_All_Student2 extends JFrame  implements ActionListener{
	
	/*
	 * this.addWindowListener(new WindowAdapter()){
	 * 
	 * 
	 * }
	 */
	
	private static final String INSERT_STU = "insert into student values(?,?,?)";
	/*
	 * SQL> update student set sname='rrr',sadd='dfdf' where sno=123;
	 * 
	 * 1 row updated.
	 */
	private static final String UPDATE_STU = "update student set sname=?,sadd=? where sno=?";

 
	/*
	 * SQL> delete from student where sno=1006;
	 * 
	 * 1 row deleted.
	 */
	private static final String DELETE_STU = "delete from student where sno=?";

//	SQL> select sname,sadd from student where sno=123;
	
	private static final String VIEW_STU="select sname,sadd from student where sno=?";
	
	
	private JLabel lsno, lsname, lsadd;
	private JTextField tsno, tsname, tsadd;
	private JButton binsert, bupdate, bdelete, bview;
	private Connection con;
	
  
	public MiniProject_Fatch_All_Student2() {
		setTitle("Mini Project App");
		setSize(150, 400);
		setLayout(new FlowLayout());

		// add component

		lsno = new JLabel("Student no:: ");
		add(lsno);
		tsno = new JTextField(10);
		add(tsno);

		lsname = new JLabel("Student name:: ");
		add(lsname);
		tsname = new JTextField(10);
		add(tsname);

		lsadd = new JLabel("Student addr:: ");
		add(lsadd);
		tsadd = new JTextField(10);
		add(tsadd);

		binsert = new JButton("Insert");
		add(binsert);
		binsert.addActionListener(this);

		bupdate = new JButton("Update");
		add(bupdate);
		bupdate.addActionListener(this);

		
		bdelete = new JButton("Delete");
		add(bdelete);
		bdelete.addActionListener(this);


		bview = new JButton("View");
		add(bview);
		bview.addActionListener(this);


		setVisible(true);
		// set DefaultCloseOpen(JFrame.EXIT_ON_CLOSE);
		initialize();

		// disable editin on text
		
		

	}
	
	public static void main(String[] args) {
		new MiniProject_Fatch_All_Student2();
		
		
		
	}

	public void initialize() {
		try {
		//  register driver
  Class.forName("oracle.jdbc.driver.OracleDriver");
	      
	      // establish the connection
	     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger"); 
	      
		}
		catch(ClassNotFoundException cnf) {
  	    	 cnf.printStackTrace();
  	    	  
  	      }
		 catch(SQLException se) {
   	    	 se.printStackTrace();
   	    	  
   	      }
		
   	  
        	catch(Exception e) {
   	    	  e.printStackTrace();
   	      }  
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		   PreparedStatement ps=null;
		   ResultSet rs=null;
		  boolean ins_Flag=false;
		  int result=0;
		  boolean view_Flag=false;
		  boolean update_Flage=false;
              if(ae.getSource()==binsert) {
            	  
            	  try {
               System.out.println("insert  button is click");
         	   ps=con.prepareStatement(INSERT_STU);
         	   
         	  if(ps!=null)
         	  {
               ps.setInt(1, Integer.parseInt(tsno.getText()));
         	   ps.setString(2, tsname.getText());
         	   ps.setString(3, tsadd.getText());
         	   
         	   
         	   ps.execute();
         	  }
         	  ins_Flag=true;

}
	
	 catch(SQLException se) {
	    	 se.printStackTrace();
	    	  
	      }
	
	  
   	catch(Exception e) {
	    	  e.printStackTrace();
	      }  
    
        } //if  
              else  if(ae.getSource()==bupdate) {
            	  
            	  try {
            		  System.out.println("update  button is click");
                	
            		  ps=con.prepareStatement(UPDATE_STU); 
            	      
                	
                	  ps.setString(1, tsname.getText());
                	   ps.setString(2, tsadd.getText());
                	   ps.setInt(3,  Integer.parseInt(tsno.getText()));
                	  
                	   
                	   ps.execute();
             	
            	  
            	  }
            	  catch(SQLException se) {
         	    	 se.printStackTrace();
         	    	  
         	      }
         	
         	  
            	catch(Exception e) {
         	    	  e.printStackTrace();
         	      }  

            	  
            	  }
              
              
  else  if(ae.getSource()==bdelete) {
            	  
            	  try {
            		  System.out.println("delete  button is click");
                	
            		  ps=con.prepareStatement(DELETE_STU); 
            	      
                	
                	
                	   ps.setInt(1,  Integer.parseInt(tsno.getText()));
                	  
                	   
                	   result=ps.executeUpdate();
             	            
                	   if(result==0) {
                		   System.out.println("row is deleted");
                	   }
                	   else {
                		   
                		   System.out.println("row not deleted");
                	   }
            	  
            	  }
            	  catch(SQLException se) {
         	    	 se.printStackTrace();
         	    	  
         	      }
         	
         	  
            	catch(Exception e) {
         	    	  e.printStackTrace();
         	      }  

            	  
            	  }
              
              
  else  if(ae.getSource()==bview) {
	  
	  try {
		  System.out.println("view  button is click");
    	 
    	  
		  ps=con.prepareStatement(VIEW_STU); 
	      
    	
    	 
    	   ps.setInt(1,  Integer.parseInt(tsno.getText()));
    	  
    	   
    	 
    	  
    	   rs=ps.executeQuery();
	     
    	           if(rs!=null)
    	           {
    	             if(rs.next()) {
    	            	    view_Flag=true;
    	            	 tsname.setText(rs.getString(1));
    	            	  tsadd.setText(rs.getString(2));  
    	             }
    	           }
    	               if(view_Flag==false){
    	            	   System.out.println("recored not view");
    	            	    
    	               }
    	               else {
    	            	   
    	            	   System.out.println("recore found");
    	               }
    	           
	  }
	  catch(SQLException se) {
	    	 se.printStackTrace();
	    	  
	      }
	
	  
	catch(Exception e) {
	    	  e.printStackTrace();
	      }  

	  
	  }

	}//  acitoion performed
	
}