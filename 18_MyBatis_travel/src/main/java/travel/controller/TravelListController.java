package travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import travel.model.TravelBean;
import travel.model.TravelDao;
import utility.Paging;

@Controller
public class TravelListController {

	private final String commond = "/list.tv";
	private final String getPage = "travelList";
	
	@Autowired
	TravelDao travelDao; 
	
	@RequestMapping(value=commond)
	public ModelAndView doAction(
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		String url = request.getContextPath()+ this.commond;
		
		int count = travelDao.getTravelCount(map);
		System.out.println("count: "+count);
		Paging pageInfo = new Paging(pageNumber, null, count, url, whatColumn, keyword);
		
		List<TravelBean> travelLists = travelDao.getTravelList(map,pageInfo);
		mav.addObject("travelLists",travelLists);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		mav.addObject("pageInfo",pageInfo);
		mav.setViewName(getPage);
		
		return mav;
	}
	
}
