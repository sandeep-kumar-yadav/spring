package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String STUDENT_IINSERT_QUERRY="INSERT INTO SP_STUDENT VALUES(SNO_NUMBER.NEXTVAL,?,?,?,?,?)";
	private BasicDataSource con;
	
	public StudentDAOImpl(BasicDataSource con) {
		
		this.con = con;
	}
	
  @Override
	public int insert(StudentBO bo) {
		 int count=0;
		 //write jdbc  code to insert record
		
		try {
			//get jdbc con
			Connection con1=con.getConnection();
			
			 //create preparedStatement obj
			
			PreparedStatement ps=con1.prepareStatement(STUDENT_IINSERT_QUERRY);
			//SET THE query values
			 
			ps.setString(1, bo.getSname());
			ps.setString(2,bo.getSadd());
			ps.setInt(3, bo.getTotal());
			ps.setFloat(4, bo.getAvg());
			ps.setString(5, bo.getResult()); 
			//execute the query
			
			 count=ps.executeUpdate();
	
			//close jdbc objs
			ps.close();
			con1.close();
			
			return count;
			
			
		}
		catch(SQLException se) {
			return 0;
		}
		
		catch(Exception e) {
			
			return 0;
		}
	}

}
