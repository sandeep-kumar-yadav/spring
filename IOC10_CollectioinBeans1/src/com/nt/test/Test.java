package com.nt.test;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

import com.nt.bean.College;
import com.nt.bean.Employee;
import com.nt.bean.Student;
import com.nt.bean.User;


public class Test {

	public static void main(String[] args) {
	    
		
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
	
		Employee b=null;
	     
	     factory=new DefaultListableBeanFactory();
          reader=new XmlBeanDefinitionReader(factory);
          
         
           reader.loadBeanDefinitions(new FileSystemResource("src/com/nt/cfgs/applicatoinContext.xml"));
           
       
        
          b=factory.getBean("desg",Employee.class);
          
          System.out.println(b);
          
	}
}
