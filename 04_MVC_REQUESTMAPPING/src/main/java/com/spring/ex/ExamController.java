package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //��Ʈ�ѷ� Ŭ������ �����ؾ���
public class ExamController {
	
	// board/form ��û => form.jsp �̵�
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
// Ŭ������ �޶� ��û���� ������ ������ ���.	

}
