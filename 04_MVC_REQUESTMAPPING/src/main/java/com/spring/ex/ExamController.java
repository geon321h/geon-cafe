package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //컨트롤러 클래스로 지정해야함
public class ExamController {
	
	// board/form 요청 => form.jsp 이동
	@RequestMapping(value = "board/form")
	public ModelAndView move() {
		ModelAndView mav = new ModelAndView("/board/form");
		
		return mav;
	}
	
//	@RequestMapping(value = "/member")
//	public ModelAndView view() {
//		ModelAndView mav = new ModelAndView("/form");
//		
//		return mav;
//	}
// 클래스가 달라도 요청명이 같으면 에러가 뜬다.	

}
