package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@RequestMapping("form")
	public String form() {
		
		return "form";
	}
	
	@RequestMapping("insert")
	public String result(@ModelAttribute("book") @Valid BookBean bb,BindingResult result) {
		String page="result";
		if(result.hasErrors()) {
			page = "form";
		}
		
		return page;
	}
	
}
