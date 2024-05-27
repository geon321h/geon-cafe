package com.spring.ex;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	
	@RequestMapping(value = "form")
	public String form(){
		return "form";
	}
	
	@RequestMapping(value = "sub")
	public String view(HttpServletRequest request,Model model,RedirectAttributes attr){
		System.out.println("sub요청 view()");
		String name = request.getParameter("name");
		System.out.println("name : "+name);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("map_name", name);
		attr.addFlashAttribute("mapAttr",map);
		
		request.setAttribute("rname", name);
		model.addAttribute("mname", name);
		
		return "redirect:/sub2";
	}
	
	@RequestMapping(value = "sub2")
	public String view2(HttpServletRequest request,Model model){
		System.out.println("sub2요청 view2()");
		String name = request.getParameter("name");
		System.out.println("name : "+name);
		
		String rname = request.getParameter("rname");
		System.out.println("rname : "+rname);
		
		String mname = request.getParameter("mname"); // model로 설정하여 parameter로 받는 것만 가능
		System.out.println("mname : "+mname);
		
		String rname2 = (String)request.getAttribute("rname");
		System.out.println("rname2 : "+rname2);
		
		String mname2 =  (String)request.getAttribute("mname");
		System.out.println("mname2 : "+mname2);
		
		return "result";
	}
	
}
