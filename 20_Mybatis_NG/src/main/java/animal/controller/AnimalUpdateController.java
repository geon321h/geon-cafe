package animal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import animal.model.AnimalBean;
import animal.model.AnimalDao;

@Controller
public class AnimalUpdateController {
	private final String command = "update.am";
	private final String getPage = "animalUpdateForm";
	private final String gotoPage = "redirect:/list.am";
	
	@Autowired
	AnimalDao animalDao;
	
	@RequestMapping(value=command, method = RequestMethod.GET)
	public ModelAndView updateForm(
			@RequestParam(value="num") String num, 
					@RequestParam(value="pageNumber", required = false) String pageNumber,
					@RequestParam(value="whatColumn", required = false) String whatColumn,
					@RequestParam(value="keyword", required = false) String keyword
					) {
		
		AnimalBean animal = animalDao.getAnimalDetail(num);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("animal", animal);
		mav.setViewName(getPage);
		return mav;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("animal") @Valid AnimalBean animal,BindingResult result,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("whatColumn") String whatColumn,
			@RequestParam("keyword") String keyword) {
		
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		animalDao.updateAnimal(animal);
		mav.addObject("pageNumber",pageNumber);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		mav.setViewName(gotoPage);
		return mav;
	}
	
}