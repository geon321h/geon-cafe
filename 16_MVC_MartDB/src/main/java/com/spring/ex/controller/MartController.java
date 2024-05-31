package com.spring.ex.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.ex.command.MCommand;
import com.spring.ex.command.MInsertCommand;
import com.spring.ex.command.MListCommand;
import com.spring.ex.dto.MartBean;

@Controller
public class MartController {
	
	MCommand command = null;

	@RequestMapping("form")
	public String form() {
		
		return "insertForm";
	}
	
	@RequestMapping("insert")
	public String result(@ModelAttribute("mart") @Valid MartBean pb,BindingResult result,Model model) {

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
	
}
