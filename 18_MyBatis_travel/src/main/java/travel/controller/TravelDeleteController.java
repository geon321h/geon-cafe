package travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import travel.model.TravelDao;

@Controller
public class TravelDeleteController {

	private final String commond = "/delete.tv";
	private final String getPage = "redirect:list.tv";
	
	@Autowired
	TravelDao travelDao; 
	
	@RequestMapping(value=commond)
	public String doAction(@RequestParam("num") int num) {
		
		int cnt = -1;
		cnt = travelDao.deleteTravel(num);
		
		return getPage;
	}
	
}
