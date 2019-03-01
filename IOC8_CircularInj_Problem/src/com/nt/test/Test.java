package com.nt.test;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.FileSystemResource;

import com.nt.bean.A;
import com.nt.bean.B;


public class Test {

	public static void main(String[] args) {
	    
		
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		A a=null;
		B b=null;
	     
	     factory=new DefaultListableBeanFactory();
          reader=new XmlBeanDefinitionReader(factory);
         
           reader.loadBeanDefinitions(new FileSystemResource("src/com/nt/cfgs/applicatoinContext.xml"));
           
          a=factory.getBean("aa",A.class);
          System.out.println(a.toString());
        
          b=factory.getBean("bb",B.class);
          System.out.println(b.toString());
	}
}
