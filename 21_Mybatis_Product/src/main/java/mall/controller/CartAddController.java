package mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.MyCartList;
import product.model.ProductBean;

@Controller
public class CartAddController {
	private final String command = "add.mall";
	private final String gotoPage = "redirect:/list.mall"; // CartListController
	
	// productDetailView.jsp���� �ֹ� Ŭ������ �� num,orderqty, pageNumber �Դϴ�.
	@RequestMapping(command)
	public String add(ProductBean pb, 
					@RequestParam(value="pageNumber",required = false) int pageNumber,
					HttpSession session) {
		
		System.out.println(this.getClass()+ "POST");
		System.out.println("pb.getNum():"+pb.getNum());
		System.out.println("pb.getOrderqty():"+pb.getOrderqty());
		System.out.println("pageNumber:"+pageNumber);
		
		if(session.getAttribute("loginInfo") == null) {// 
			session.setAttribute("destination", "redirect:/detailView.prd?num="+pb.getNum()+"&pageNumber="+pageNumber);
			return "redirect:/login.mb"; //MemberLoginController=>memberLoginForm.jsp
		
		}else { // �α��� ����
			
			MyCartList mycart = (MyCartList)session.getAttribute("mycart"); // ��ٱ��� �����̸�:mycart
			System.out.println("mycart:" + mycart); 
			if(mycart == null) {
				mycart = new MyCartList();
			}
			System.out.println("mycart2:" + mycart);
			mycart.addOrder(pb.getNum(), pb.getOrderqty());
			session.setAttribute("mycart", mycart);
			
			return gotoPage;
		}
	}
}
