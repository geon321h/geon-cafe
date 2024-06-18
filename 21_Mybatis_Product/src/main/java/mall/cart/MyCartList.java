package mall.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyCartList { // 장바구니 

	private Map<Integer,Integer> orderlists = null; // 몇번상품(key), 주문수량(value)
	
	public MyCartList() {
		orderlists = new HashMap<Integer,Integer>();
	}
	
	public void addOrder(int pnum, int oqty) {
		// 지금 주문한 상품(7,2)
		if(orderlists.containsKey(pnum) == false) {//장바구니에 동일 상품이 없으면
			orderlists.put(pnum, oqty); //3번,2개 / 7번,1개/ 5번,4개 => 7번,2개 더 =>3번,2개 / 7번,3개/ 5번,4개
			
		}else { // 있으면
			int qty = orderlists.get(pnum); 
			orderlists.put(pnum, oqty + qty); // 7,3
		}
		
		Set<Integer> key_set = orderlists.keySet();
		System.out.println("key_set:" + key_set); // 상품번호만 (3,7,5)
		
		for(int key : key_set) {
			System.out.println(key + ", " + orderlists.get(key));
		}
		
	}//addOrder

	public Map<Integer, Integer> getAllOrderLists() {
		return orderlists;
		
	}//getAllOrderLists
}
