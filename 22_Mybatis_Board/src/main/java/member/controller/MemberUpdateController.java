package member.controller;


import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class MemberUpdateController {

	private final String command="/update.mb";
	private final String goPage="updateForm";
	private final String goToPage="redirect:list.mb";
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value =  command,method = RequestMethod.GET)
	public String update(
			@RequestParam(value = "num") String num,
			@RequestParam(value = "pageNumber") String pageNumber,
			@RequestParam(value = "whatColumn") String whatColumn,
			@RequestParam(value = "keyword") String keyword,
			Model model) {
		
		MemberBean member = memberDao.getMemberByNum(num);
		model.addAttribute("member",member);
		
		return goPage;
	}
	
	@RequestMapping(value =  command,method = RequestMethod.POST)
	public String update(
			@ModelAttribute("member") @Valid MemberBean member,
			BindingResult result,
			@RequestParam(value = "pageNumber") String pageNumber,
			@RequestParam(value = "whatColumn") String whatColumn,
			@RequestParam(value = "keyword") String keyword,
			HttpServletResponse response,
			Model model) {
		
		if(result.hasErrors()) {
			return goPage;
		}
		
		int cnt = -1;
		cnt = memberDao.updateMember(member);
		
		if(cnt>0) {
			model.addAttribute("pageNumber",pageNumber);
			model.addAttribute("whatColumn",whatColumn);
			model.addAttribute("keyword",keyword);
			return goToPage;
		}else {
			return goPage;
		}
		
	}
	
}
