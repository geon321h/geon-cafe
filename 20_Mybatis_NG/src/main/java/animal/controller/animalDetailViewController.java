package animal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import animal.model.AnimalBean;
import animal.model.AnimalDao;

@Controller
public class animalDetailViewController {

	private final String command = "/detailView.am";
	private final String getPage = "animalDetailView";
	
	@Autowired
	AnimalDao animalDao;
	
	@RequestMapping(value = command)
	private ModelAndView detailView(
			@RequestParam(value = "num") String num,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword) {
		ModelAndView mav = new ModelAndView();
		
		AnimalBean animal = animalDao.getAnimalDetail(num);
		mav.addObject("animal",animal);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		
		return mav;
	}
	
}
