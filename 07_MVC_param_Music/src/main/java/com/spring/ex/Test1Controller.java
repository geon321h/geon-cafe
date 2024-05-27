package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test1Controller {

	@RequestMapping(value = "test1form")
	public String form(){
		
		return "test1/Test1Form";
	}
	
	@RequestMapping(value = "test1/join")
	public String join(HttpServletRequest request){
		
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		return "test1/test1result";
	}
	
}
