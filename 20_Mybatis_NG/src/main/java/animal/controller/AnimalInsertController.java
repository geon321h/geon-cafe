package animal.controller;

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

import animal.model.AnimalBean;
import animal.model.AnimalDao;


@Controller
public class AnimalInsertController {

	private final String command = "/insert.am";
	private final String getPage = "animalInsertForm";
	private final String goToPage = "redirect:list.am";
	
	@Autowired
	AnimalDao animalDao;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	private String insert(
			@RequestParam("pageNumber") int pageNumber,
			Model model) {
			model.addAttribute("pageNumber", pageNumber);
		return getPage;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	private ModelAndView insert(@ModelAttribute("animal") @Valid AnimalBean animal
			,BindingResult result
			,@RequestParam("pageNumber") int pageNumber) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		
		if (result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		int cnt = -1;
		cnt = animalDao.insertAnimal(animal);
		
		if(cnt>0) {
			mav.setViewName(goToPage);
		}else {
			mav.setViewName(getPage);
		}
		return mav;
	}
	
}
