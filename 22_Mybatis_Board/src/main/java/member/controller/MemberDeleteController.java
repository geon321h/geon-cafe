package member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberDao;

@Controller
public class MemberDeleteController {

	private final String command="/delete.mb";
	private final String goPage="redirect:list.mb";
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value =  command)
	public String delete(
			@RequestParam(value = "num") String num,
			@RequestParam(value = "pageNumber") String pageNumber,
			@RequestParam(value = "whatColumn") String whatColumn,
			@RequestParam(value = "keyword") String keyword,
			Model model) {
		
		memberDao.deleteMember(num);
		
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("whatColumn",whatColumn);
		model.addAttribute("keyword",keyword);
		
		return goPage;
	}
	
	
}
