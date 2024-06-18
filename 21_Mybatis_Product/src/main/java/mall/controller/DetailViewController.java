package mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import order.model.OrderBean;
import order.model.OrderDao;
import orderdetail.model.OrderDetailDao;


@Controller
public class DetailViewController {

	private final String command = "detailView.mall";
	private final String gotoPage = "shopResult";
	
	@Autowired
	OrderDetailDao orderDetailDao;
	
	@RequestMapping(command)
	public String order(
			Model model,
			@RequestParam("oid") int oid) {
		
		MemberBean member = orderDetailDao.detailMember(oid);
		List<OrderBean> ordersList = orderDetailDao.detailProduct(oid);
		model.addAttribute("member",member);
		model.addAttribute("ordersList",ordersList);
		
		return gotoPage;
	}
	
}
