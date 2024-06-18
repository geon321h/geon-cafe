package mall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import mall.cart.ShoppingInfo;
import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class CartListController {
	private final String command = "list.mall";
	private final String getPage = "mallList"; // 장바구니 보기
	
	@Autowired
	private ProductDao productDao;
	
	// detailVeiw.jsp(주문) > CartAddController(로그인 성공) > 장바구니 담기(MyCartList addOrder) > list.mall 요청
	@RequestMapping(command)
	public String list(HttpSession session) {
		
		System.out.println(this.getClass());
		MyCartList mycart = (MyCartList)session.getAttribute("mycart");
		Map<Integer,Integer> maplists = mycart.getAllOrderLists();
		
		System.out.println("maplists.size():" + maplists.size());
		
		Set<Integer> key_set = maplists.keySet();
		System.out.println("key_set:" + key_set); // 상품번호만 [33, 19, 7]
		
		for(int key : key_set) {
			System.out.println(key + ", " + maplists.get(key));
		}
		
		List<ShoppingInfo> shoplists = new ArrayList<ShoppingInfo>();
		int totalAmount = 0;
		for(Integer pnum : key_set) {
			Integer qty = maplists.get(pnum);
			ProductBean pb = productDao.detailViewByNum(pnum);
			ShoppingInfo shopInfo = new ShoppingInfo();
			shopInfo.setPnum(pnum);
			shopInfo.setPname(pb.getName());
			shopInfo.setQty(qty);
			shopInfo.setPrice(pb.getPrice());
			int amount = pb.getPrice() * qty;
			totalAmount += amount;
			shopInfo.setAmount(amount);
			shoplists.add(shopInfo);
		}
		session.setAttribute("shoplists", shoplists);
		session.setAttribute("totalAmount", totalAmount);
		return getPage;
	}
}
