package album.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import album.model.AlbumBean;
import album.model.AlbumDao;
import utility.Paging;

@Controller
public class AlbumListController {
	
	private final String command = "/list.ab";
	private String getPage = "albumList";
	
	@Autowired
	AlbumDao dao;
	
	@RequestMapping(command)
	public ModelAndView list(
			@RequestParam(value = "whatColumn",required = false) String whatColumn, 
			@RequestParam(value = "keyword",required = false) String keyword,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			HttpServletRequest request){
		System.out.println("whatColumn : "+whatColumn);
		System.out.println("keyword : "+keyword);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("whatColumn", whatColumn);
		map.put("keyword", "%"+keyword+"%");
		
		int totalCount = dao.getTotalCount(map);
		System.out.println("totalCount: "+totalCount);
		
		String url =request.getContextPath() + this.command;
		
		// 페이지번호 , 한페이지개수 , 총리스트개수 ,url ,칼럼 ,검색어
		Paging pageInfo = new Paging(pageNumber,null,totalCount,url,whatColumn,keyword);
		ModelAndView mav = new ModelAndView();
		List<AlbumBean> albumLists = dao.getAlbumList(pageInfo,map);
		
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		
		mav.addObject("albumList",albumLists);
		mav.addObject("pageInfo",pageInfo);
		mav.setViewName(getPage);
		
		return mav;
	}

}
