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
public class BoardUpdateController {

	private final String command="/update.bd";
	private final String goPage="updateForm";
	private final String goToPage="redirect:list.bd";
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(value =  command,method = RequestMethod.GET)
	public String update(
			@RequestParam(value = "num") String num,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			HttpSession session,Model model) {
		
		if(session.getAttribute("userInfo")==null) {
			session.setAttribute("destination","redirect:/update.bd?num="+num+"&pageNumber="+pageNumber+"&whatColumn="+whatColumn+"&keyword="+keyword);
			return "redirect:login.mb";
		}
		BoardBean board = boardDao.getBoard(num);
		model.addAttribute("board", board);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("whatColumn", whatColumn);
		model.addAttribute("keyword", keyword);
		
		return goPage;
	}
	
	@RequestMapping(value =  command,method = RequestMethod.POST)
	public ModelAndView update(
			@ModelAttribute("board") @Valid BoardBean board,
			BindingResult result,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("whatColumn", whatColumn);
		mav.addObject("keyword", keyword);
		
		if(result.hasErrors()) {
			mav.setViewName(goPage);
			return mav;
		}
		
		BoardBean dbboard = boardDao.getBoard(String.valueOf(board.getNum()));
		
		if(board.getPasswd().equals(dbboard.getPasswd())){
			int cnt = -1;
			cnt = boardDao.updateBoard(board);
			
			if(cnt>0) {
				mav.setViewName(goToPage);
			}else {
				mav.setViewName(goPage);
			}
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('��й�ȣ�� ��ġ���� �ʽ��ϴ�.');</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mav.setViewName(goPage);
		}
		return mav;
		
	}
	
}