package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardReplyController {

	private final String command="/reply.bd";
	private final String goPage="replyForm";
	private final String goToPage="redirect:list.bd";
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(value =  command,method = RequestMethod.GET)
	public String reply(
			@RequestParam(value = "ref") String ref,
			@RequestParam(value = "re_step") String re_step,
			@RequestParam(value = "re_level") String re_level,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			HttpSession session,Model model) {
		
		if(session.getAttribute("userInfo")==null) {
			session.setAttribute("destination","redirect:/reply.bd?ref="+ref+"&re_step="+re_step+"&re_level="+re_level+"&pageNumber="+pageNumber+"&whatColumn="+whatColumn+"&keyword="+keyword);
			return "redirect:login.mb";
		}
		model.addAttribute("ref", ref);
		model.addAttribute("re_step", re_step);
		model.addAttribute("re_level", re_level);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("whatColumn", whatColumn);
		model.addAttribute("keyword", keyword);
		
		return goPage;
	}
	
	@RequestMapping(value =  command,method = RequestMethod.POST)
	public ModelAndView reply(
			@ModelAttribute("board") @Valid BoardBean board,
			BindingResult result,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			HttpServletResponse response,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("ref", board.getRef());
		mav.addObject("re_step", board.getRe_step());
		mav.addObject("re_level", board.getRe_level());
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("whatColumn", whatColumn);
		mav.addObject("keyword", keyword);
		
		if(result.hasErrors()) {
			board.setSubject(board.getSubject().replace("[답글]", ""));
			mav.setViewName(goPage);
			return mav;
		}
		board.setIp(request.getRemoteAddr());
		int cnt = -1;
		cnt = boardDao.replyBoard(board);
		
		if(cnt>0) {
			mav.setViewName(goToPage);
		}else {
			board.setSubject(board.getSubject().replace("[답글]", ""));
			mav.setViewName(goPage);
		}
		return mav;
		
	}
	
}
