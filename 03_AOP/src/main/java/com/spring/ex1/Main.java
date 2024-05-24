package com.spring.ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	 public static void main(String[] args) {
		
		 AbstractApplicationContext factory = new GenericXmlApplicationContext("AopExam.xml");
		 Student student = (Student)factory.getBean("myStudentImpl");
		 Worker worker = (Worker)factory.getBean("myWorkerImpl");
		 
		 student.getStudentInfo();
		 System.out.println("================");
		 worker.getWorkerInfo(); 
		 
	}
	
}
