package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberUpdateController {

	private final String command = "update.mb";
	private final String getPage = "memberUpdateForm";
	private final String goToPage = "redirect:list.mb";
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	private ModelAndView update(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			@RequestParam(value = "pageNumber",required = false) String pageNumber) {
			
			MemberBean member = memberDao.getMember(id);
			ModelAndView mav = new ModelAndView();
			mav.addObject("member", member);
			mav.setViewName(getPage);
			return mav;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	private ModelAndView update(
			@ModelAttribute("member") @Valid MemberBean member,
			BindingResult result,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("whatColumn") String whatColumn,
			@RequestParam("keyword") String keyword) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("whatColumn", whatColumn);
		mav.addObject("keyword", keyword);
		
		if (result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		int cnt = -1;
		cnt = memberDao.updateMember(member);
		
		if(cnt>0) {
			mav.setViewName(goToPage);
		}else{
			mav.setViewName(getPage);
		}
		return mav;
	}
	
}
