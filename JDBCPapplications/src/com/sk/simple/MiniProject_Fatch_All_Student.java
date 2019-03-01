package com.sk.simple;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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




/*
SQL> create or replace  procedure P_FIND_PASS_FAIL(m1 in number,m2 in number,m3 in number ,result out varchar)
  2  as
  3  begin
  4  if(m1<35 or m2<35 or m3<35 ) then
  5  result:='FAIL';
  6  else
  7  result:='PASS';
  8  end if
  9  ;
 10  end;
 11  /

Procedure created.
 * */
public  class MiniProject_Fatch_All_Student extends JFrame  implements ActionListener,WindowListener{
	private static final String ALL_SNO="SELECT SNO FROM ALL_STUDENT";
	private static final String FETCH_STUD_BY_SNO="SELECT SNAME,M1,M2,M3 FROM ALL_STUDENT WHERE SNO=?";
	private static final String CALL_QUERY="{CALL P_FIND_PASS_FAIL(?,?,?,?)}";
	 private JLabel lno,lname,lm1,lm2,lm3,lresult;
	 private JComboBox<Integer> cbno;
	 private JTextField tname,tm1,tm2,tm3,tresult;
	 
	 private JButton bResult,bDetails;
	 private Connection con;
	 private Statement st;
	 private ResultSet rs;
	 private PreparedStatement ps;
     private CallableStatement cs;


 public MiniProject_Fatch_All_Student(){
	       setTitle("Mini Project App");
	       setSize(150,400);
	       setLayout(new FlowLayout());
	      
	       // add component
	       
	       lno=new JLabel("Student Num:: ");
	       add(lno);
	       cbno=new JComboBox();
	       add(cbno);
	       
	       bDetails=new JButton("Details");
	       add(bDetails);
	       bDetails.addActionListener(this);
	       
	       lname=new JLabel("Student Name:: ");
	       add(lname);
	       tname=new JTextField(10);
	       add(tname);
	       
	       
	       lm1=new JLabel("Student markes 1:: ");
	       add(lm1);
	       tm1=new JTextField(10);
	       add(tm1);
	       lm2=new JLabel("Student markes 2:: ");
	       add(lm2);
	       tm2=new JTextField(10);
	       add(tm2);
	       lm3=new JLabel("Student markes 3:: ");
	       add(lm3);
	       tm3=new JTextField(10);
	       add(tm3);
	       
	       bResult=new JButton("Result");
	       add(bResult);
	       bResult.addActionListener(this);

	       lresult= new JLabel("Result");
	       add(lresult);
	       tresult= new JTextField(10);
	       add(tresult);
	       
	       setVisible(true);
	    //   set DefaultCloseOpen(JFrame.EXIT_ON_CLOSE);
	     initialize();
	     
	     // disable editin on text
	     tname.setEditable(false);
	     tm1.setEditable(false);
	     tm2.setEditable(false);
	     tm3.setEditable(false);
	     tresult.setEditable(false);

 }
 
public static void main(String[] args) {
	new MiniProject_Fatch_All_Student();
}

@Override
public void actionPerformed(ActionEvent ae) {
       int no=0;
       ResultSet rs1=null;
       int m1,m2,m3=0;
       if(ae.getSource()==bDetails) {
 	      System.out.println("details button is checked");
            try {
            	//  read select item from conbox
            	no=(int)cbno.getSelectedItem();            	
           
            	//set value to query params
            	
            	ps.setInt(1, no);
              //execute the query 
            	
            	rs1=ps.executeQuery();
            	
            	// get recored from resultset and set to text box
            	
            	if(rs1.next()) {
            		
            		tname.setText(rs1.getString(1));
            		tm1.setText(rs1.getString(2));
                   tm2.setText(rs1.getString(3)); 
                   tm3.setText(rs1.getString(4));
                   
                   
            	}  //if  
            
            
            } 
            catch(SQLException se) {
   	    	 se.printStackTrace();
   	    	  
   	      }
   	  
        	catch(Exception e) {
   	    	  e.printStackTrace();
   	      }  
    	 
 	      
    	   
       }
       else {
    	      System.out.println("result button is checked");
    	   try {
    		   
    		   // read match from textBoxes
    		   
    		    m1 = Integer.parseInt(tm1.getText());
    		    m2 = Integer.parseInt(tm3.getText());

    		    m3 = Integer.parseInt(tm3.getText());
           
    		    
    		    // set value to in param
    		    
    		    cs.setInt(1, m1);
    		    cs.setInt(2, m2);
    		    cs.setInt(3, m3);
            // execute the querey
    		    cs.execute();
    		    
    		  //  gether the result from out param and set to text box
    		    
    		    tresult.setText(cs.getString(4));
    	   }
       
       catch(SQLException se) {
	    	 se.printStackTrace();
	    	  
	      }
	  
   	catch(Exception e) {
	    	  e.printStackTrace();
	      }  
       }
}


public void initialize() {
	 
	  try {
		//register jdbc driver
		  //register driver
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      
	      // establish the connection
	     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger"); 
	       
	   // create the simple statement
	     st=con.createStatement();
	  // pass the query
	     
	     rs=st.executeQuery(ALL_SNO);
		  
	     //  COPY records to combbox
	     while(rs.next()) {
	    	 cbno.addItem(rs.getInt(1));
	    	 
	     }
	     
	     // create the preparedStatement 
	        ps=con.prepareStatement(FETCH_STUD_BY_SNO);
	     
	       // crete the callableStatement  
	        cs=con.prepareCall(CALL_QUERY);
	        // set out param 
		  cs.registerOutParameter(4, Types.VARCHAR);
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
 	 
	
	
}

@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e) {
     // close JDBC
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
			if (st != null)
				st.close();
		} catch (SQLException se) {
			se.printStackTrace();

		}
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException se) {
			se.printStackTrace();

		}
		
		
}

@Override
public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowIconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeiconified(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowActivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowDeactivated(WindowEvent e) {
	// TODO Auto-generated method stub
	
}
}