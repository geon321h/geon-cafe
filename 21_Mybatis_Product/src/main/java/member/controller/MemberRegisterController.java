package member.controller;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberRegisterController {

	private final String command = "register.mb";
	private final String getPage = "memberRegister";
	private final String goToPage = "redirect:loginForm.mb";
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	private String register() {
			
			return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	private ModelAndView register(@ModelAttribute("member") @Valid MemberBean member,BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		
		if (result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		int cnt = -1;
		cnt = memberDao.insertMember(member);
		
		if(cnt>0) {
			mav.setViewName(goToPage);
		}else {
			mav.setViewName(getPage);
		}
		return mav;
	}
	
}
