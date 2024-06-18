package mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.MemberBean;
import order.model.OrderBean;
import order.model.OrderDao;


@Controller
public class OrederMallController {

	private final String command = "order.mall";
	private final String gotoPage = "shopList";
	
	@Autowired
	OrderDao orderDao;
	
	@RequestMapping(command)
	public String order(Model model,HttpSession session) {
		
		if(session.getAttribute("loginInfo") == null) {// 
			session.setAttribute("destination", "redirect:/order.mall");
			return "redirect:/login.mb"; //MemberLoginController=>memberLoginForm.jsp
		
		}else {
			MemberBean member = (MemberBean)session.getAttribute("loginInfo");
			List<OrderBean> ordersList = orderDao.getOrderList(member.getId());
			
			model.addAttribute("member",member);
			model.addAttribute("ordersList",ordersList);
			
		}
		
		
		return gotoPage;
	}
	
}
