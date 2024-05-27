package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.Bean.BookBean;

@Controller
public class BookController {

	/*
	 * input1 ��û request�� �޾� result1���� ���
	 * 
	 * input2 ��û ������̼����� �޾� result2���� ���
	 * 
	 * input3 ��û request�� �޾Ƽ� ModelAndView result3���� ���
	 * 
	 * input4 ��û command��ü�� ���� result4���� ���
	 * 
	 * input5 ��û command��ü ��Ī�����ؼ� result5���� ���
	 */
	
	@RequestMapping(value = "form")
	public String form(){
		return "form";
	}
	
	@RequestMapping(value = "input1")
	public String input1(HttpServletRequest request){
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		String publisher = request.getParameter("publisher");
		
		request.setAttribute("title", title);
		request.setAttribute("author", author);
		request.setAttribute("price", price);
		request.setAttribute("publisher", publisher);
		
		return "book/result1";
	}
	
	@RequestMapping(value = "input2")
	public String input2(@RequestParam("title") String title,
									@RequestParam("author") String author,
									@RequestParam("price") String price,
									@RequestParam("publisher") String publisher,
									HttpServletRequest request){
		
		request.setAttribute("title", title);
		request.setAttribute("author", author);
		request.setAttribute("price", price);
		request.setAttribute("publisher", publisher);
		
		return "book/result2";
	}
	
	@RequestMapping(value = "input3")
	public ModelAndView input3(@RequestParam("title") String title,
									@RequestParam("author") String author,
									@RequestParam("price") String price,
									@RequestParam("publisher") String publisher,
									HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", title);
		mv.addObject("author", author);
		mv.addObject("price", price);
		mv.addObject("publisher", publisher);
		mv.setViewName("book/result3");
		
		request.setAttribute("title", title);
		request.setAttribute("author", author);
		request.setAttribute("price", price);
		request.setAttribute("publisher", publisher);
		
		return mv;
	}
	
	@RequestMapping(value = "input4")
	public String input4(BookBean bb){
		
		return "book/result4";
	}
	
	@RequestMapping(value = "input5")
	public String input5(@ModelAttribute("bk") BookBean bb){
		
		return "book/result5";
	}
	
	
}
