import java.util.ArrayList;

public class Ex03_ArrayList {

	public static void main(String[] args) {

		ArrayList<String> lists = new ArrayList<String>();
		int size = lists.size();
		System.out.println("size:" + size);
		
		lists.add("태연"); // 0
		lists.add("윤아"); // 1
		lists.add("수영"); // 2
		lists.add(1,"효연"); // 끼워넣기
		size = lists.size();
		System.out.println("size:" + size);
		System.out.println(lists.get(0));
		
		System.out.println("lists :" + lists); // 오버라이딩된 toString이다. [요소1,요소2]
		
	}

}
