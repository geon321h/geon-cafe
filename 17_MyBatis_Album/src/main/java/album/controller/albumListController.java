package album.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class albumListController {
	
	private final String command = "/list.ab";
	private String getPage = "albumList";
	
	@Autowired
	AlbumDao dao;
	
	@RequestMapping(command)
	public ModelAndView list(){
		ModelAndView mav = new ModelAndView();
		List<AlbumBean> albumLists = dao.getAlbumList();
		
		mav.addObject("albumList",albumLists);
		mav.setViewName(getPage);
		
		return mav;
	}

}
