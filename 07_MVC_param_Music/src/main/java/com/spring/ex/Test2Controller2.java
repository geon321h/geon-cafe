package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test2Controller2 {

	@RequestMapping(value = "test2form")
	public String form(){
		
		return "test2/Test2Form";
	}
	
	@RequestMapping(value = "test2/join2")
	public String join(HttpServletRequest request){
		
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		return "test2/test2result";
	}
	
}
