package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardInsertController {

	private final String command="/insert.bd";
	private final String goPage="insertForm";
	private final String goToPage="redirect:list.bd";
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(value =  command,method = RequestMethod.GET)
	public String insert(HttpSession session) {
		
		if(session.getAttribute("userInfo")==null) {
			session.setAttribute("destination","redirect:/insert.bd");
			return "redirect:login.mb";
		}
		
		return goPage;
	}
	
	@RequestMapping(value =  command,method = RequestMethod.POST)
	public String insert(
			@ModelAttribute("board") @Valid BoardBean board,
			BindingResult result,
			HttpServletRequest request) {
		
		if(result.hasErrors()) {
			return goPage;
		}
		
		board.setIp(request.getRemoteAddr());
		
		int cnt = -1;
		cnt = boardDao.insertBoard(board);
		
		if(cnt>0) {
			return goToPage;
		}else {
			return goPage;
		}
		
	}
	
}
