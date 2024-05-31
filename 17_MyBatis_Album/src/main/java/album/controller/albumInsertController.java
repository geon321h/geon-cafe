package album.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class albumInsertController {
	
	private final String command = "/insert.ab";
	private final String getPage = "albumInsertForm";
	
	@Autowired
	AlbumDao dao;
	
	@RequestMapping(command)
	public String doAction(){
		
		return getPage;
	}

}
