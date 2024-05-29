package com.spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Person {
	
	@NotEmpty(message="이름 입력 누락")
	//@NotBlank(message="이름 입력 누락")
	//@NotNull(message="이름 입력 누락")
	private String name;
	
	//@NotEmpty(message="비번 입력 누락")
	//@Length(min = 3,max =5, message = "3~5글자만 입력")
	@Size(min = 3,max =5, message = "3~5글자만 입력")
	@Pattern(regexp = "^[0-9]+$", message = "숫자로만 입력")
	private String pw;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	

}
