package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.Bean.MusicBean;

@Controller
public class MusicController {

	@RequestMapping(value = "form")
	public String form(){
		
		return "form";
	}
	
	@RequestMapping(value = "input1")
	public String input1(){
		
		return "music/result1";
	}
	
	@RequestMapping(value = "input2")
	public String input2(@RequestParam("title") String title,
									@RequestParam("singer") String singer,
									@RequestParam("price") int price,
									HttpServletRequest request){
		
		request.setAttribute("title",title);
		request.setAttribute("singer",singer);
		request.setAttribute("price",price);
		
		return "music/result2";
	}
	
	@RequestMapping(value = "input3")
	public ModelAndView input3(@RequestParam("title") String title,
									@RequestParam("singer") String singer,
									@RequestParam("price") String price,
									HttpServletRequest request){
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("title", title);
		mv.addObject("singer", singer);
		mv.addObject("price", price);
		mv.setViewName("music/result3");
		
		request.setAttribute("title",title);
		request.setAttribute("singer",singer);
		request.setAttribute("price",price);
		
		
		return mv;
	}
	
	@RequestMapping(value = "input4")
	public String input4(MusicBean mb){
//		MusicBean mb 는 request 3줄 객체생성1줄 setter 3줄 속성세팅 1줄 
		
		return "music/result4";
	}
	
	@RequestMapping(value = "input5")
	public String input5(@ModelAttribute("msc") MusicBean mb){
		
		
		return "music/result5";
	}
	
	
	
	
}
