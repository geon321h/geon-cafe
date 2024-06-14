package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
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
public class ProductInsertController {

	private final String command = "/insert.prd";
	private final String getPage = "productInsertForm";
	private final String goToPage = "redirect:list.prd";
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value = command, method = RequestMethod.GET)
	private String insert(
			@RequestParam(value = "pageNumber", required = false) String pageNumber,
			Model model,
			HttpSession session) {
				model.addAttribute("pageNumber", pageNumber);
			
			// 로그인 성공하면 해당 사용자의 정보를 세션에 저장
			if(session.getAttribute("loginInfo")==null) {
				session.setAttribute("destination","redirect:/insert.prd");
				return "redirect:/login.mb";
			}else {
				return getPage;
			}
			
	}
	
	@RequestMapping(value = command, method = RequestMethod.POST)
	private ModelAndView insert(
			@ModelAttribute("product") @Valid ProductBean product
			,BindingResult result
			,@RequestParam("pageNumber") int pageNumber) {
		
		// C:\sts2\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\21_Mybatis_Product\
		System.out.println("product.getImage(): "+product.getImage());
		System.out.println("product.getUpload(): "+product.getUpload()); // 올린 파일의 정보
		MultipartFile multi = product.getUpload();
		
		String uploadPath = servletContext.getRealPath("/resources/uploadImage");
		System.out.println("uploadPath: "+uploadPath);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageNumber", pageNumber);
		
		if (result.hasErrors()) {
			mav.setViewName(getPage);
			return mav;
		}
		
		int cnt = -1;
		cnt = productDao.insertProduct(product);
		
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
		}else {
			mav.setViewName(getPage);
		}
		return mav;
	}
	
}
