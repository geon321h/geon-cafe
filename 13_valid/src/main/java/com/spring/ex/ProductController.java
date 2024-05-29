package com.spring.ex;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

	@RequestMapping("form")
	public String form() {
		
		return "insertForm";
	}
	
	@RequestMapping("insert")
	public String result(@ModelAttribute("pro") @Valid ProductBean pb,BindingResult result) {
		System.out.println(pb.getTime());
		String page="result";
		if(result.hasErrors()) {
			page = "insertForm";
		}
		
		return page;
	}
	
}
