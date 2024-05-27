package com.spring.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.bean.MemberBean;

@Controller
public class MemberController {

	@RequestMapping(value = "member/input")
	public String input(){
		System.out.println("member/input 요청");
		
		return "member/result";
	}
	
	// http://localhost:8081/ex/member/input2?id=kim&pw=1234
	@RequestMapping(value = "member/input2")
	public String input2(HttpServletRequest request){
		System.out.println("member/input 요청");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		return "member/result2";
	}
	
	// http://localhost:8081/ex/member/input3?id=kim&pw=1234&addr=경기도&age=20
	@RequestMapping(value = "member/input3")
	public String input3(@RequestParam("id") String id,
									@RequestParam("pw") String pw,
									@RequestParam("addr") String addr,
									@RequestParam("age") String age,
									HttpServletRequest request){
		System.out.println("member/input 요청");
		request.setAttribute("id", id);
		request.setAttribute("pw", pw);
		
		MemberBean mb = new MemberBean();
		mb.setId(id);
		mb.setPw(pw);
		mb.setAddr(addr);
		mb.setAge(age);
		request.setAttribute("mb", mb);
		
		return "member/result3";
	}
	
	// http://localhost:8081/ex/member/input4?id=kim&pw=1234&addr=경기도&age=20
	@RequestMapping(value = "member/input4")
	public String input4(MemberBean mb,HttpServletRequest request){
		// request.setAttribute("memberBean", mb); 자동으로 객체 속성 생성
		
		return "member/result4";
	}
	
	// http://localhost:8081/ex/member/input5?id=kim&pw=1234&addr=경기도&age=20
	@RequestMapping(value = "member/input5")
	public String input5(@ModelAttribute("abcd") MemberBean mb){
		// request.setAttribute("abcd", mb); @ModelAttribute 속성명 변경
		
		return "member/result5";
	}
	
}
