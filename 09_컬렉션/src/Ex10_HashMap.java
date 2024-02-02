import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex10_HashMap {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Map<String, String> dic = new HashMap<String, String>();
		
		dic.put("desk", "책상");
		dic.put("sky", "하늘");
		dic.put("hand", "손");
		dic.put("pencil", "연필");

		String word;
		
		
		do {
			
			System.out.println("찾는 단어는? (q입력시 종료) ");
			word = sc.next();
			
			if(true == dic.containsKey(word)) {
				
				String s = dic.get(word);
				System.out.println("뜻 : " + s);
				
			}else if(word.equals("q")) {

				System.out.println("프로그램을 종료합니다.");
				break;
				
			}else {
				
				System.out.println("잘못입력하셨습니다.");
				
			}
			
		}while(true);
		
		
	}

}
