package movie.controller;

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

import movie.model.MovieBean;
import movie.model.MovieDao;


@Controller
public class MovieInsertController {

	private final String command = "/insert.mv";
	private final String getPage = "movieInsertForm";
	private final String goToPage = "redirect:list.mv";
	
	@Autowired
	MovieDao movieDao; 
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	private String insert(
			@RequestParam("pageNumber") int pageNumber,
			Model model) {
			model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	private ModelAndView insert(@ModelAttribute("movie") @Valid MovieBean movie
			,BindingResult result
			,@RequestParam("pageNumber") int pageNumber) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		
		if (result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		int cnt = -1;
		cnt = movieDao.insertMovie(movie);
		
		if(cnt>0) {
			mav.setViewName(goToPage);
		}else {
			mav.setViewName(getPage);
		}
		return mav;
	}
	
}
