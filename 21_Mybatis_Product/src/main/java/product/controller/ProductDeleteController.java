package product.controller;


import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductDao;


@Controller
public class ProductDeleteController {

	private final String command = "/delete.prd";
	private final String getPage = "redirect:list.prd";
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command)
	private ModelAndView delete(
			@RequestParam(value = "num") String num,
			@RequestParam(value = "pageNumber",required = false) String pageNumber,
			@RequestParam(value = "whatColumn",required = false) String whatColumn,
			@RequestParam(value = "keyword",required = false) String keyword) {
		ModelAndView mav = new ModelAndView();
		
		ProductBean product = productDao.getProduct(num);
		String uploadPath = servletContext.getRealPath("/resources/uploadImage");
		String fullPath = uploadPath+File.separator+product.getImage();
		
		File file = new File(fullPath);
	 	if(file.exists()){
	 		if(file.delete()){
	 			System.out.println("파일 삭제");
	 		}else{
	 			System.out.println("파일삭제 실패");
	 		}
	 	}else{
	 			System.out.println("파일없음");
	 	}
		
		int cnt = productDao.deleteProduct(num);
		mav.addObject("whatColumn",whatColumn);
		mav.addObject("keyword",keyword);
		mav.addObject("pageNumber",pageNumber);
		mav.setViewName(getPage);
		
		return mav;
	}
	
}
