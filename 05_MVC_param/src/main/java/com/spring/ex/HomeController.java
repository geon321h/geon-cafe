package com.spring.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.bean.PersonBean;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "person/input")
	public String result(HttpServletRequest request){
		
		String name = request.getParameter("name");
		System.out.println("name: "+name);
		request.setAttribute("name2", name+"¾¾~");
		
		return "person/result";
	}
	
	// http://localhost:8081/ex/person/join?id=choi&pw=1234&name=kim&addr=seoul
	@RequestMapping(value = "person/join")
	public String join(@RequestParam("id") String id,
								@RequestParam("pw") String pw,
								@RequestParam("name") String name,
								@RequestParam("addr") String addr,
								HttpServletRequest request){
		// String a = request.getParameter("id"); ¿Í °°´Ù.
		
		System.out.println("id:"+id);
		System.out.println("pw:"+pw);
		System.out.println("name"+name);
		System.out.println("addr"+addr);
		
		request.setAttribute("id2", id+"-2");
		request.setAttribute("pw2", pw+"-2");
		request.setAttribute("name2", name+"-2");
		request.setAttribute("addr2", addr+"-2");
		
		return "person/personView";
	}
	
	// http://localhost:8081/ex/person/join2?id=choi&pw=1234&name=kim&addr=seoul
		@RequestMapping(value = "person/join2")
		public String join2(PersonBean pb) {
			
			return "person/personView2";
		}
	
}
