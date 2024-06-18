package mall.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyCartList { // ��ٱ��� 

	private Map<Integer,Integer> orderlists = null; // �����ǰ(key), �ֹ�����(value)
	
	public MyCartList() {
		orderlists = new HashMap<Integer,Integer>();
	}
	
	public void addOrder(int pnum, int oqty) {
		// ���� �ֹ��� ��ǰ(7,2)
		if(orderlists.containsKey(pnum) == false) {//��ٱ��Ͽ� ���� ��ǰ�� ������
			orderlists.put(pnum, oqty); //3��,2�� / 7��,1��/ 5��,4�� => 7��,2�� �� =>3��,2�� / 7��,3��/ 5��,4��
			
		}else { // ������
			int qty = orderlists.get(pnum); 
			orderlists.put(pnum, oqty + qty); // 7,3
		}
		
		Set<Integer> key_set = orderlists.keySet();
		System.out.println("key_set:" + key_set); // ��ǰ��ȣ�� (3,7,5)
		
		for(int key : key_set) {
			System.out.println(key + ", " + orderlists.get(key));
		}
		
	}//addOrder

	public Map<Integer, Integer> getAllOrderLists() {
		return orderlists;
		
	}//getAllOrderLists
}
