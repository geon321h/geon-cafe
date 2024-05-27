package com.spring.bean;

public class MemberBean {
	
	private String id;
	private String pw;
	private String addr;
	private String age;
	
	 public MemberBean() {

		 System.out.println("MemberBean »ý¼º");
	 
	 }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	

}
