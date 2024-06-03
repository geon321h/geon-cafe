package album.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;

@Controller
public class AlbumUpdateController {
	
	private final String command = "/update.ab";
	private String getPage = "albumUpdateForm";
	private String gotoPage = "redirect:list.ab";
	
	@Autowired
	AlbumDao dao;
	
	// list에 수정하기 버튼
	@RequestMapping(value = command, method = RequestMethod.GET)
	public ModelAndView update(@RequestParam("num") int num){
		ModelAndView mav = new ModelAndView();
		AlbumBean album = dao.getAlbum(num);
		mav.addObject("album",album);
		mav.setViewName(getPage);
		return mav;
	}
	
	// 업데이트폼에서 수정버튼으로 form post로 전송
	@RequestMapping(value = command, method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("album") @Valid AlbumBean album, BindingResult result){
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		int cnt = -1;
		cnt = dao.updateAlbum(album);
		if(cnt>0) {
			mav.setViewName(gotoPage);
		}else {
			mav.setViewName(getPage);
		}
		return mav;
	}

}
