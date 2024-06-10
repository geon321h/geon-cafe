package movie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import movie.model.MovieDao;


@Controller
public class MovieDeleteController {

	private final String command = "/delete.mv";
	private final String getPage = "redirect:list.mv";
	
	@Autowired
	MovieDao movieDao; 
	
	@RequestMapping(value = command)
	private ModelAndView delete(
			@RequestParam(value = "num") String num,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword) {
		ModelAndView mav = new ModelAndView();
		
		int cnt = movieDao.deleteMovie(num);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		
		return mav;
	}
	
}
