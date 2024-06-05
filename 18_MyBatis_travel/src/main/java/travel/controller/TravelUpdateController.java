package travel.controller;


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

import travel.model.TravelBean;
import travel.model.TravelDao;

@Controller
public class TravelUpdateController {

	private final String command = "/update.tv";
	private final String getPage = "travelUpdateForm";
	private final String goToPage = "redirect:list.tv";
	
	@Autowired
	TravelDao travelDao; 
	
	@RequestMapping(value=command , method = RequestMethod.GET)
	public String doAction(@RequestParam("num") int num,
			@RequestParam("pageNumber") int pageNumber,
			Model model) {
		TravelBean travel = travelDao.getTravel(num);
		
		model.addAttribute("travel", travel);
		model.addAttribute("pageNumber", pageNumber); // �Ӽ�
		
		return getPage;
	}
	
	@RequestMapping(value=command , method = RequestMethod.POST)
	public ModelAndView doAction(@ModelAttribute("travel") @Valid TravelBean travel,BindingResult result
			,@RequestParam("pageNumber") int pageNumber) {
		
		ModelAndView mov = new ModelAndView();
		mov.addObject("pageNumber", pageNumber); // �Ķ����
		
		if (result.hasErrors()) {
			mov.setViewName(getPage);
			return mov;
		}
		//System.out.println("��������");
		int cnt = -1;
		cnt = travelDao.updateTravel(travel);
		
		if(cnt>0) {
			mov.setViewName(goToPage);
		}else {
			mov.addObject("num", travel.getNum());
			mov.setViewName("redirect:"+command);
		}
		return mov;
		
	}
	
}
