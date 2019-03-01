package com.nt.test;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

import com.nt.bean.EngCollege;


public class Test {

	public static void main(String[] args) {
	    
		
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
	
		EngCollege b=null;
	     
	     factory=new DefaultListableBeanFactory();
          reader=new XmlBeanDefinitionReader(factory);
         
           reader.loadBeanDefinitions(new FileSystemResource("src/com/nt/cfgs/applicatoinContext.xml"));
           
       
        
          b=factory.getBean("emp2",EngCollege.class);
         
          
          System.out.println(b);
	}
}
