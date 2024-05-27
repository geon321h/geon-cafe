package com.spring.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	// /요청을 get방식으로 요청하면 호출된다.
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); // el코드로 접근 가능하다.
		// request.setAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	// member 요청하면 view()가 호출되며 /WEB-INF/views/memberView.jsp로 간다.
	@RequestMapping(value="/member")
	public String view() {
		return "memberView";
	}
	
	@RequestMapping(value="/member/input")
	public String input(Model model) { // 
		
		model.addAttribute("id","kim");
		model.addAttribute("name","홍길동");
		return "/member/input"; // /WEB-INF/views/member/input.jsp
	}
	
	@RequestMapping(value="/member/list", method= RequestMethod.GET)
	public ModelAndView list() { // 
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "웬디");
		mav.setViewName("/member/list");
		
		return mav; // /WEB-INF/views/member/list.jsp
	}
	
	@RequestMapping(value="/member/list2", method= RequestMethod.GET)
	public ModelAndView list2() { // 
		ModelAndView mav = new ModelAndView("/member/list2"); // 가지고갈 값 없을시 setViewName과 같은 효과
		
		return mav; 
	}
	
	@RequestMapping(value="/fruit", method= RequestMethod.GET)
	public String fruit() {
		return "apple";
	}
	
}
