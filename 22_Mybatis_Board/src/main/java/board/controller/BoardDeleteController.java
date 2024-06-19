package board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardDeleteController {

	private final String command="/delete.bd";
	private final String goPage="deleteForm";
	private final String goToPage="redirect:list.bd";
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(value =  command,method = RequestMethod.GET)
	public String delete(
			@RequestParam(value = "num") String num,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			HttpSession session,Model model) {
		
		if(session.getAttribute("userInfo")==null) {
			session.setAttribute("destination","redirect:/delete.bd?num="+num+"&pageNumber="+pageNumber+"&whatColumn="+whatColumn+"&keyword="+keyword);
			return "redirect:login.mb";
		}
		model.addAttribute("num", num);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("whatColumn", whatColumn);
		model.addAttribute("keyword", keyword);
		
		return goPage;
	}
	
	@RequestMapping(value =  command,method = RequestMethod.POST)
	public ModelAndView delete(
			@RequestParam(value = "num") String num,
			@RequestParam(value = "passwd") String passwd,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		BoardBean board = boardDao.getBoard(num);
		mav.addObject("num",num);
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		if(passwd.equals(board.getPasswd())){
			boardDao.deleteBoard(num);
			mav.setViewName(goToPage);
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('비밀번호가 일치하지 않습니다.');</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mav.setViewName(goPage);
		}
		
		return mav;
	}
	
	
}



