package com.sk.simple;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class  GUIExampleRegApp  extends JFrame implements ActionListener,WindowListener {
   @Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		try
		{
			
			ps.close();
			con.close();
			
		}
		  catch(SQLException se) {
		    	 se.printStackTrace();
		    	  
		      }
		  
		
		      catch(Exception e1) {
		    	  e1.printStackTrace();
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

	/*
	 * create table emp111( eno number(10) primary key ,ename varchar2(10),esal
	 * number(10),edesg varchar2(10));
	 * 
	 * Table created.
	 * 
	 * SQL> create sequence ENO_SEQ start with 1000 increment by 1;
	 * 
	 * Sequence created.
	 */
private static final String INSERT_DATA_EMP="insert into emp111 values(ENO_SEQ.NEXTVAL,?,?,?)";
	private JLabel lname,lsal,ldesg,lresult;          
    private JButton btn;
    private JTextField tname,tsal,tdesg;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int count;
     public GUIExampleRegApp() {
    	 System.out.println("constructor");
    	//  show window
    	 
    	 setTitle("Employee reg aap");
    	 setBackground(Color.BLUE);
    	 setSize(200,400);
    	 setLayout(new FlowLayout());
    	 
    	 //  add comps
    	 
    	 lname=new JLabel("Enter Name:");
    	 add(lname);
    	 tname=new JTextField(10);
    	 add(tname);
    	 
    	 lsal=new JLabel("Enter Salary:");
    	 add(lsal);
    	 tsal=new JTextField(10);
    	 add(tsal);
    	 
    	 ldesg=new JLabel("Enter designation : ");
    	 add(ldesg);
    	 tdesg=new JTextField(10);
    	 add(tdesg);
    	 
    	 
    	 btn=new JButton("Register");
    	 add(btn);
    	 btn.addActionListener(this);
    	 lresult=new JLabel("");
    	 add(lresult);
    	
    	 setVisible(true);
    	
    	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	 
    	 initiJDBC();
    	 
    	 
     }
     
     public void initiJDBC() {
    	  //
    	 try
    	 {
    		//register jdbc driver
    		  //register driver
		      Class.forName("oracle.jdbc.driver.OracleDriver");
		      
		      // establish the connection
		     con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORACLE","scott","tiger"); 
		       
		   // create the PreparedStatement 
    			//create preparedStatement object
    		
    				ps=con.prepareStatement(INSERT_DATA_EMP);
    		 
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
     public static void main(String[] args) {
    	 System.out.println("show main methods");
    	 new GUIExampleRegApp();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		  String name=null;
		  int sal=0;
		  String desg=null;

        //   System.out.println(e.getActionCommand());
		System.out.println("show button clicking processing ");
		
		/* name=setText(lname);
			sal=Integer.parseInt(setText(lsal));
			desg=setText(ldesg);*/
			
		try {
			name=tname.getText();
			desg=tdesg.getText();
			sal= Integer.parseInt(tsal.getText());
			
			  ps.setString(1, name);
			  ps.setInt(2, sal);
			  ps.setString(3, desg);
			  
				   //   execute the query
				 
			  count=ps.executeUpdate();
			  
			  //process the query
			  if(count==0) {
				
				  lresult.setForeground(Color.red);
				  lresult.setText("Regrastration failed");
							  }
			  
			  else {
				  lresult.setForeground(Color.green);
				  lresult.setText("Regrastration successed");
			
			   }
		}
			  catch(Exception se){
		    
				  se.printStackTrace();
			/*
			 * if(se.getErrorCode()==12899) { lresult.setText("String value is too large");
			 * 
			 * } else if(se.getErrorCode()==1) {
			 * lresult.setText("Employee already register");
			 * 
			 * }
			 * 
			 * if(se.getErrorCode()==12899) { lresult.setText("Number value is too large");
			 * 
			 * }
			 */

			  }
			
	}
}
