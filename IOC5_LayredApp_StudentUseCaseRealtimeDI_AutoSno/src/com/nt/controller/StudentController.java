package com.nt.controller;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

public class StudentController {
      
	private StudentService service;
	 public StudentController(StudentService service) {
		
		this.service = service;
	}

	  public String process(String sname,String sadd,String m1,String m2,String m3) {
		  //  prepare VO obj
		  
		  StudentVO vo=new StudentVO();
		  vo.setSname(sname);
		  vo.setSadd(sadd);
		  vo.setM1(m1);
		  vo.setM2(m2);
		  vo.setM3(m3);
		  
		  //convert to VO obj to DTO obj
		  
		  StudentDTO dto=new StudentDTO();
		   
		//  dto.setSno(Integer.parseInt(vo.getSno()));
		  dto.setSname(vo.getSname());
		  dto.setSadd(vo.getSadd());
		  dto.setM1(Integer.parseInt(vo.getM1()));
		  
		  dto.setM2(Integer.parseInt(vo.getM2()));
		  
		  dto.setM3(Integer.parseInt(vo.getM3()));
		  // use Service class
		  
		  String result=service.generateResult(dto);
		  return result;
	  }//method
	
	 
}
