package com.spring.ex;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Person {
	
	@NotEmpty(message="�̸� �Է� ����")
	//@NotBlank(message="�̸� �Է� ����")
	//@NotNull(message="�̸� �Է� ����")
	private String name;
	
	//@NotEmpty(message="��� �Է� ����")
	//@Length(min = 3,max =5, message = "3~5���ڸ� �Է�")
	@Size(min = 3,max =5, message = "3~5���ڸ� �Է�")
	@Pattern(regexp = "^[0-9]+$", message = "���ڷθ� �Է�")
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
