package com.sk.simple;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MiniProject_Fatch_All_StudentScroll extends JFrame  implements ActionListener{
	
	
	private static final String SELECT_STU = "select sno,sname,sadd  from student";

	
	
	private JLabel lsno, lsname, lsadd;
	private JTextField tsno, tsname, tsadd;
	private JButton bfirst, bnext, bprevious, blast;
	private Connection con;
    PreparedStatement ps;	
    ResultSet rs;

	public MiniProject_Fatch_All_StudentScroll() {
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

		bfirst = new JButton("First");
		add(bfirst);
		bfirst.addActionListener(this);

		bnext = new JButton("Next");
		add(bnext);
		bnext.addActionListener(this);

		
		bprevious = new JButton("Previous");
		add(bprevious);
		bprevious.addActionListener(this);


		blast = new JButton("Last");
		add(blast);
		blast.addActionListener(this);


		setVisible(true);
		// set DefaultCloseOpen(JFrame.EXIT_ON_CLOSE);
		initialize();

		// disable editin on text

	}

	public static void main(String[] args) {
		new MiniProject_Fatch_All_StudentScroll();
	}

	public void initialize() {
		try {
		//  register driver
  Class.forName("oracle.jdbc.driver.OracleDriver");
	      
	      // establish the connection
	     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger"); 
	     
	  ps=con.prepareStatement(SELECT_STU,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);  
		rs=ps.executeQuery();
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
		 
		
              if(ae.getSource()==bfirst) {
            	  
            	  try {
               System.out.println("first  button is click");
         	
         	   if(rs.first()) {
         	   tsno.setText(rs.getString(1));
         	  tsname.setText(rs.getString(2));
         	 tsadd.setText(rs.getString(3));
         	  
         	   }
         	

}
	
	 catch(SQLException se) {
	    	 se.printStackTrace();
	    	  
	      }
	  
   	catch(Exception e) {
	    	  e.printStackTrace();
	      }  
    
        } //if  
              else  if(ae.getSource()==bnext) {
            	  
            	  try {
            		  System.out.println("next  button is click");
                	
            		 
                     
                    	
                    	   if(!rs.isLast()) {
                    		   
                    		   if(rs.next())
                    		   tsno.setText(rs.getString(1));
                         	  tsname.setText(rs.getString(2));
                         	 tsadd.setText(rs.getString(3));
                    	   }
                    	
                    	   
                    	  
             	
            	  
            	  }
            	  catch(SQLException se) {
         	    	 se.printStackTrace();
         	    	  
         	      }
         	
         	  
            	catch(Exception e) {
         	    	  e.printStackTrace();
         	      }  

            	  
            	  }
              
              
  else  if(ae.getSource()==bprevious) {
            	  
            	  try {
            		  System.out.println("previous  button is click");
                	

               	   if(!rs.isFirst()) {
               		   if(rs.previous()) {
               		   tsno.setText(rs.getString(1));
                    	  tsname.setText(rs.getString(2));
                    	 tsadd.setText(rs.getString(3));
               	   }
               	
               	   }
            	  
            	  }
            	  catch(SQLException se) {
         	    	 se.printStackTrace();
         	    	  
         	      }
         	
         	  
            	catch(Exception e) {
         	    	  e.printStackTrace();
         	      }  

            	  
            	  }
              
              
  else  if(ae.getSource()==blast) {
	  
	  try {
		  System.out.println("last  button is click");
    	 

   	 
   		   if(rs.last()) {
   		   tsno.setText(rs.getString(1));
        	  tsname.setText(rs.getString(2));
        	 tsadd.setText(rs.getString(3));
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