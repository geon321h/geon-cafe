package com.spring.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sample") // ��û�� �տ� ���� �κ��� ����
public class SampleController {
	
	@RequestMapping(value = "/view")
	public ModelAndView view(){
		ModelAndView mav = new ModelAndView("/sample/view");
		
		return mav;
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView("/sample/list");
		
		return mav;
	}

}
