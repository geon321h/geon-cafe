package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.ex.command.FCommand;
import com.spring.ex.command.FDeleteCommand;
import com.spring.ex.command.FInsertCommand;
import com.spring.ex.command.FListCommand;
import com.spring.ex.command.FUpdateCommand;
import com.spring.ex.command.FUpdateFormCommand;
import com.spring.ex.dto.FDto;


@Controller
public class FController {

	FCommand command = null;
	
	@RequestMapping("insertForm")
	public String form() {
		return "insertForm";
	}
	
	@RequestMapping(value = "insert")
	public String insert(@ModelAttribute("dto") @Valid FDto dto,BindingResult result,HttpServletRequest request,Model model) {
		
		String page="redirect:list";
		if(result.hasErrors()) { // 에러가 발생된 경우 다시 돌아가도록 지정
			page = "insertForm";
		}else{
			// model.addAttribute("req",request); // 넘어온 request 값을 model로 설정
			command = new FInsertCommand();
			command.execute(model);
		}
		return page;
	}
	
	@RequestMapping(value = "list")
	public String list(Model model) {
		command = new FListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping(value = "delete")
	public String delete(HttpServletRequest request,Model model) {
		model.addAttribute("req",request);
		command = new FDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "updateForm")
	public String updateForm(HttpServletRequest request,Model model) {
		model.addAttribute("req",request);
		command = new FUpdateFormCommand();
		command.execute(model);
		
		return "updateForm";
	}
	
	@RequestMapping(value = "update")
	public String update(@ModelAttribute("fdto") @Valid FDto dto,BindingResult result,HttpServletRequest request,Model model) {
		//model.addAttribute("req",request);

		String page="redirect:list";
		if(result.hasErrors()) { // 에러가 발생된 경우 다시 돌아가도록 지정
			page = "updateForm";
		}else{
			command = new FUpdateCommand();
			command.execute(model);
		}
		return page;
	}
	
}
