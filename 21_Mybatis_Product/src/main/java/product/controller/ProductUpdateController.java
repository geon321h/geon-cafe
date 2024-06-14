package product.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class ProductUpdateController {

	private final String command = "/update.prd";
	private final String getPage = "productUpdateForm";
	private final String goToPage = "redirect:list.prd";
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	private ModelAndView update(
			@RequestParam("num") String num,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam(value = "whatColumn", required = false) String whatColumn,
			@RequestParam(value="keyword", required = false) String keyword,
			HttpSession session) {
		
			ModelAndView mav = new ModelAndView();
			ProductBean product = productDao.getProduct(num);
			mav.addObject("product", product);
			mav.setViewName(getPage);
			
			if(session.getAttribute("loginInfo")==null) {
				session.setAttribute("destination","redirect:/update.prd?num="+num+"&pageNumber="+pageNumber);
				mav.setViewName("redirect:/login.mb");
			}
			
			//System.out.println("product inputdate: "+product.getInputdate());
		return mav;
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	private ModelAndView update(
			@ModelAttribute("product") @Valid ProductBean product
			,BindingResult result
			,@RequestParam("pageNumber") int pageNumber
			,@RequestParam("whatColumn") String whatColumn
			,@RequestParam("keyword") String keyword) {
		
		MultipartFile multi = product.getUpload();
		String uploadPath = servletContext.getRealPath("/resources/uploadImage");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		mav.addObject("whatColumn", whatColumn);
		mav.addObject("keyword", keyword);
		
		
		if (result.hasErrors()) {
			mav.setViewName(getPage);
			if(product.getImage().equals("")) {
				product.setImage(product.getUpload2());
			}
			return mav;
		}
		
		try {
			String encode = URLEncoder.encode(whatColumn,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		int cnt = -1;
		cnt = productDao.updateProduct(product);
		
		if(cnt>0) {
			mav.setViewName(goToPage);

			File destination = new File(uploadPath+File.separator+multi.getOriginalFilename());
			try {
				multi.transferTo(destination);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String fullPath = uploadPath+File.separator+product.getUpload2();
			
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
		}else {
			mav.setViewName(getPage);
		}
		return mav;
	}
	
}
