package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex.command.PCommand;
import com.spring.ex.command.PDeleteCommand;
import com.spring.ex.command.PInsertCommand;
import com.spring.ex.command.PListCommand;
import com.spring.ex.command.PUpdateCommand;
import com.spring.ex.command.PUpdateFormCommand;

@Controller
public class PController {
	
	PCommand command = null;
	
	@RequestMapping("insertForm")
	public String form() {
		return "insertForm";
	}
	
	@RequestMapping(value = "insert" ,method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {
		
		System.out.println(request.getParameter("id"));
		
		command = new PInsertCommand();
		command.execute(request);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "list" )
	public String list(HttpServletRequest request) {
		
		command = new PListCommand();
		command.execute(request);
		
		return "list";
	}
	
	@RequestMapping(value = "delete" )
	public String delete(HttpServletRequest request) {
		
		command = new PDeleteCommand();
		command.execute(request);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "updateForm" )
	public String updateForm(HttpServletRequest request) {
		
		command = new PUpdateFormCommand(); 
		command.execute(request);
		
		return "updateForm";
	}
	
	@RequestMapping(value = "update" )
	public String update(HttpServletRequest request) {
		
		command = new PUpdateCommand();
		command.execute(request);
		
		return "redirect:list";
	}
	

}
