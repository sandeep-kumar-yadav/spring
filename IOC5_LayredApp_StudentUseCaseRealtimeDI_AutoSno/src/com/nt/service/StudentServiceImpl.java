package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentServiceImpl implements StudentService {
	String result;
	 

		private StudentDAO dao;
		
	    public StudentServiceImpl(StudentDAO dao) {
			
			this.dao = dao;
		}
	   
	@Override
	public String generateResult(StudentDTO dto) {
	      // write b.logic 
		
		int total= dto.getM1()+dto.getM2()+dto.getM3();
		float avg=(float)total/3.0f;
		int count=0;
		
		
		if(avg<35)
		
		   result="Fail";
		
		else
		
			result="Pass";
		
		
		//create BO class obj
		
		StudentBO bo= new StudentBO();
		
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setSadd(dto.getSadd());
		bo.setTotal(total);
               bo.setAvg(avg);
               bo.setResult(result);
        
        //uer DAO
            count=dao.insert(bo);
        
        if(count==0)
        	return "  Result     "+bo.getResult()+"  "+bo.getSno()+"   Registration Faild";
        else 
        	return "  Result    "+bo.getResult()+"  "+bo.getSno()+"Registration Successful";

	
	} // method

}//class
