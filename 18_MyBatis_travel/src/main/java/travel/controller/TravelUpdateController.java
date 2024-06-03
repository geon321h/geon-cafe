package travel.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {

	private final String commond = "/update.tv";
	private final String getPage = "travelUpdateForm";
	private final String goToPage = "redirect:list.tv";
	
	@Autowired
	TravelDao travelDao; 
	
	@RequestMapping(value=commond , method = RequestMethod.GET)
	public ModelAndView doAction(@RequestParam("num") int num) {
		ModelAndView mov = new ModelAndView();
		TravelBean travel = travelDao.getTravel(num);
		mov.addObject("travel", travel);
		mov.setViewName(getPage);
		
		return mov;
	}
	
	@RequestMapping(value=commond , method = RequestMethod.POST)
	public String doAction(@ModelAttribute("travel") @Valid TravelBean travel,BindingResult result) {
		
		if (result.hasErrors()) {
			return getPage;
		}
		//System.out.println("오류없음");
		int cnt = -1;
		cnt = travelDao.updateTravel(travel);
		
		if(cnt>0) {
			return goToPage;
		}else {
			return getPage;
		}
		
	}
	
}
