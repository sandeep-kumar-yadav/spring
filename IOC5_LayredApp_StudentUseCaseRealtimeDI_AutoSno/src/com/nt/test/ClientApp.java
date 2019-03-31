package com.nt.test;

import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;


import com.nt.controller.StudentController;

public class ClientApp {
public static void main(String[] args) {
	Scanner sc=null;
	String sno=null,sname=null,sadd=null,m1=null,m2=null,m3=null;
	 
	
	//create IOC container 

	BeanFactory factory=new XmlBeanFactory(new FileSystemResource("src/com/nt/cfgs/applicationContext.xml"));
      
	 //Get Bean
	
	StudentController controller=factory.getBean("stController",StudentController.class);
	//call method
	
	try {
		sc=new Scanner(System.in);
		// read input 
		System.out.println("Enter Student Name:: ");

		sname=sc.next();
		System.out.println("Enter Student Address:: ");

		sadd=sc.next();
		System.out.println("Enter Student marks1:: ");

		m1=sc.next();
		System.out.println("Enter Student marks1:: ");

		m2=sc.next();
		System.out.println("Enter Student Marks3:: ");

		m3=sc.next();
		
		
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	System.out.println(controller.process(sname, sadd,m1,m2,m3));
         
}
	
}
         