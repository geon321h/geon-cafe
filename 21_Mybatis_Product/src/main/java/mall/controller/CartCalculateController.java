package mall.controller;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import member.model.MemberBean;
import member.model.MemberDao;
import order.model.OrderDao;
import orderdetail.model.OrderDetailDao;
import product.model.ProductDao;

@Controller
public class CartCalculateController {

	private final String command = "/calculate.mall";
	private final String gotoPage = "redirect:/list.prd";
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderDetailDao orderDetailDao;
	
	
	// mallList.jsp(장바구니 목록보기) -> 결제하기 클릭
	@RequestMapping(command)
	public String calculate(HttpSession session) {
		
		MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		Map<Integer,Integer> orderlists = mycart.getAllOrderLists();
		Set<Integer> key_set = orderlists.keySet();
		System.out.println("key_set:" + key_set); 
		
		MemberBean member = (MemberBean)session.getAttribute("loginInfo");
		System.out.println("-----member.getId():"+member.getId());
		orderDao.insertData(member.getId());
		
		for(Integer pnum : key_set) {
			int qty = orderlists.get(pnum);
			productDao.updateStock(pnum, qty);
			
			orderDetailDao.insertData(pnum, qty);
		}
		
		memberDao.updateMpoint(mb.getId(),100); // kim,100
		
		session.removeAttribute("mycart");
		return gotoPage;
	}
}
