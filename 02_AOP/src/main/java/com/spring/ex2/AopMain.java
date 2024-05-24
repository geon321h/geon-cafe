package com.spring.ex2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		
//		Login mylogin = new Login();
//		Logout mylogout = new Logout();
//		Dao mydao = new Dao();
//		
//		BoardImpl myboard = new BoardImpl();
//		mylogin.login();
//		myboard.board();
//		mydao.dao();
//		mylogout.logout();
//		
//		System.out.println("---------------------");
//		OrderImpl myorder = new OrderImpl();
//		mylogin.login();
//		myorder.order();
//		mydao.dao();
//		mylogout.logout();
		
		AbstractApplicationContext  fatory = new GenericXmlApplicationContext("aopExam.xml");
		Order or = (Order)fatory.getBean("myOrder");
		or.order();
		
		System.out.println("--------------------");
		Board br = (Board)fatory.getBean("myBoard");
		br.board();
		
		
	}
	
}
