package album.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumDetailController {

	private final String command = "/detail.ab";
	private final String getPage = "albumDetailView";
	
	@Autowired
	AlbumDao dao;
	
	@RequestMapping(command)
	public ModelAndView detail(@RequestParam("num") int num){
		ModelAndView mav = new ModelAndView();
		AlbumBean album = dao.getAlbum(num);
		mav.addObject("album",album);
		mav.setViewName(getPage);
		
		return mav;
	}
	
}
