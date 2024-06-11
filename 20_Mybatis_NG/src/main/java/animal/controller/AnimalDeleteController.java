package animal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import animal.model.AnimalBean;
import animal.model.AnimalDao;
import utility.Paging;

@Controller
public class AnimalDeleteController {
	
	private final String command = "/delete.am";
	private final String getPage = "redirect:list.am";
	
	@Autowired
	AnimalDao animalDao;
	
	@RequestMapping(value = command)
	private ModelAndView list(
			@RequestParam(value = "num") String num,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			@RequestParam(value = "pageNumber",required = false) String pageNumber) {
		ModelAndView mav = new ModelAndView();
		
		int cnt = animalDao.deleteAnimal(num);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		
		return mav;
	}

}
