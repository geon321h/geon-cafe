package com.spring.ex1;

public class Order {

	public void order() {

		String msg = "상품주문";
		
		System.out.println(msg+"을 하기 위한 로그인 수행"); // 공통사항
		System.out.println(msg+"하기"); // 핵심사항
		System.out.println(msg+"하고 DB에 저장"); // 공통사항
		System.out.println(msg+"후에 로그아웃"); // 공통사항
		
	}
	
}
