package com.nt.test;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

import com.nt.bean.User;


public class Test {

	public static void main(String[] args) {
	    
		
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
	
		User b=null;
	     
	     factory=new DefaultListableBeanFactory();
          reader=new XmlBeanDefinitionReader(factory);
         
           reader.loadBeanDefinitions(new FileSystemResource("src/com/nt/cfgs/applicatoinContext.xml"));
           
       
        
          b=factory.getBean("com.nt.bean.B#0",User.class);
          b=factory.getBean("com.nt.bean.B#1",User.class);
          
          System.out.println(b);
	}
}
