package movie.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import movie.model.MovieBean;
import movie.model.MovieDao;
import utility.Paging;


@Controller
public class MovieDetailViewController {

	private final String command = "/detailView.mv";
	private final String getPage = "movieDetailView";
	
	@Autowired
	MovieDao movieDao; 
	
	@RequestMapping(value = command)
	private ModelAndView detailView(
			@RequestParam(value = "num") String num,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		MovieBean movie = movieDao.getMovieDetail(num);
		mav.addObject("movie",movie);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		
		return mav;
	}
	
}
