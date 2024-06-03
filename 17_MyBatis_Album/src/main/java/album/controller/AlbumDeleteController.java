package album.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumDeleteController {

	private final String command = "/delete.ab";
	private String getPage = "redirect:list.ab";
	
	@Autowired
	AlbumDao dao;
	
	@RequestMapping(value = command)
	public String delete(@RequestParam("num") int num){

		int cnt = -1;
		cnt = dao.deleteAlbum(num);
		if(cnt>0) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
		}
		return getPage;
	}
	
}
