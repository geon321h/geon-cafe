package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.model.BoardBean;
import board.model.BoardDao;

@Controller
public class BoardDetailViewController {

	private final String command="/detailView.bd";
	private final String goPage="boardDetailView";
	
	@Autowired
	BoardDao boardDao;
	
	@RequestMapping(value =  command,method = RequestMethod.GET)
	public ModelAndView detailView(
			@RequestParam(value = "num") String num,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword) {
		ModelAndView mav = new ModelAndView();
		
		boardDao.readCount(num);
		BoardBean board = boardDao.getBoard(num);
		mav.addObject("board",board);
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		
		mav.setViewName(goPage);
		return mav;
	}
	
	
}



