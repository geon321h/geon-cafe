package com.spring.ex;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VaildController {

	@RequestMapping("form")
	public String form(){
		return "form";
	}
	
	@RequestMapping("insert")
	public String result(@ModelAttribute("per") @Valid Person ps,BindingResult result){
		/*
		 * String name = request.getParameter("name"); 
		 * String pw = request.getParameter("pw");
		 * request.setAttribute("name",name); 
		 * request.setAttribute("pw",pw);
		 */
		
		// BindingResult ���� �߻��� ���� ��
		
		System.out.println("result.hasErrors() : "+result.hasErrors());
		
		String page = "result";
		if(result.hasErrors()) {// ������ �ִ�.
			page = "form";
		}

		return page;
		
	}
	
	
	
}
