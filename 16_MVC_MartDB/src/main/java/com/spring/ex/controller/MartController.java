package com.spring.ex.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ex.command.MCommand;
import com.spring.ex.command.MDeleteAllCommand;
import com.spring.ex.command.MDeleteCommand;
import com.spring.ex.command.MInsertCommand;
import com.spring.ex.command.MListCommand;
import com.spring.ex.command.MUpdateCommand;
import com.spring.ex.command.MUpdateFormCommand;
import com.spring.ex.dto.MartBean;

@Controller
public class MartController {
	
	MCommand command = null;

	@RequestMapping("form")
	public String form() {
		
		return "insertForm";
	}
	
	@RequestMapping("insert")
	public String result(@ModelAttribute("mart") @Valid MartBean mb,BindingResult result,Model model) {

		String page="redirect:list";
		if(result.hasErrors()) {
			page = "insertForm";
		}else {
			command = new MInsertCommand();
			command.execute(model);
		}
		
		return page;
	}
	
	@RequestMapping(value = "list")
	public String list(Model model) {
		command = new MListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping(value = "deleteAll")
	public String deleteAll(Model model,HttpServletRequest request) {
		model.addAttribute("req", request);
		command = new MDeleteAllCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "delete")
	public String delete(Model model,HttpServletRequest request) {
		model.addAttribute("req", request);
		command = new MDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "updateForm")
	public String updateForm(Model model,HttpServletRequest request) {
		model.addAttribute("req", request);
		command = new MUpdateFormCommand();
		command.execute(model);
		
		return "updateForm";
	}
	
	@RequestMapping(value = "update")
	public String update(@ModelAttribute("mart") @Valid MartBean mb,BindingResult result,Model model) {
		String page="redirect:list";
		if(result.hasErrors()) {
			page = "updateForm";
		}else {
			command = new MUpdateCommand();
			command.execute(model);
		}
		
		return page;
	}
	
}
