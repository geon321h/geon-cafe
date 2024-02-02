import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex09_HashMap {

	public static void main(String[] args) {

		Map<String, Integer> hm = new HashMap<String, Integer>();
		
		System.out.println(hm.size());
		
		hm.put("윤아", 30);
		hm.put("서현", 20);
		hm.put("효연", 10);
		hm.put("수영", 40);
		
		System.out.println(hm.size());
		System.out.println("hm : " + hm);
		
		Integer age  = hm.get("효연");
		System.out.println("age:" + age);
		
		boolean result  = hm .containsKey("수영");
		System.out.println("result:" + result);
		
		boolean result2  = hm .containsValue(40);
		System.out.println("result2:" + result2);

		Set<String> keySet = hm.keySet();
		System.out.println("keySet:" + keySet);
		
		for( String key : keySet ) {
			
			Integer result3  = hm.get(key);
			System.out.println(key + ":" + result3 );
			
		}
		
	}

}
 