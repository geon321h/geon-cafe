package member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberDao;

@Controller
public class MemberDeleteController {

	private final String command = "delete.mb";
	private final String getPage = "redirect:list.mb";
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value = command)
	private ModelAndView delete(
			@RequestParam(value = "id") String id,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			@RequestParam(value = "pageNumber",required = false) String pageNumber) {
		ModelAndView mav = new ModelAndView();
		
		int cnt = memberDao.deleteMember(id);
		
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		return mav;
	}
	
}
