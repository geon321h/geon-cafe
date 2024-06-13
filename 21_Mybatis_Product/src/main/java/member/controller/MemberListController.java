package member.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import member.model.MemberBean;
import member.model.MemberDao;
import utility.Paging;

@Controller
public class MemberListController {
	
	private final String command = "/list.mb";
	private final String getPage = "memberList";
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	private ModelAndView list(
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		String url = request.getContextPath()+ this.command;
		
		int count = memberDao.getTotalCount(map);
		Paging pageInfo = new Paging(pageNumber, null, count, url, whatColumn, keyword);
		
		List<MemberBean> memberList = memberDao.getMemberList(pageInfo,map);
		mav.addObject("memberList",memberList);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		mav.addObject("pageInfo",pageInfo);
		mav.setViewName(getPage);
			
		return mav;
	}

}
