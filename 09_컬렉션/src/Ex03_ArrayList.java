import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex03_ArrayList {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
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
		System.out.println("lists :" + lists.toString());
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("수지");
		a.add("제니");
		
		lists.addAll(a);
		System.out.println("lists :" + lists);

		String[] arr = new String[lists.size()];
		lists.toArray(arr);
		System.out.println(arr[3]);
		
		System.out.println("lists :" + lists);
		lists.remove(1);
		
		ArrayList<String> del = new ArrayList<String>();
		del.add("윤아");
		del.add("수지");
		
		lists.removeAll(del);
		System.out.println("lists :" + lists);
		
		lists.add("수영");
		System.out.println("lists :" + lists);
		
		int index = lists.indexOf("제니");
		int index2 = lists.indexOf("수영");
		int index3 = lists.lastIndexOf("수영");
		System.out.println("index:" + index);
		System.out.println("index2:" + index2);
		System.out.println("index3:" + index3);
		
		boolean result = lists.contains("수영");
		System.out.println("result:" + result);
		
		lists.set(1, "아이유");
		System.out.println("lists :" + lists);
		
		int i;
		for(i=0;i<lists.size();i++) {
			
			String s2 = lists.get(i);
			System.out.print(s2);
			
		}
		System.out.println();
		
		Iterator<String> it = lists.iterator();
		while(it.hasNext()) {
			
			String s3 = it.next();
			System.out.println(s3);
			
		}
		
		System.out.println("============================");
		
		ArrayList<Integer> lists2 = new ArrayList<Integer>();
		lists2.add(10);
		lists2.add(20);
		lists2.add(30);
		System.out.println("lists2 :" + lists2.toString());
		
		Integer i1 = lists2.get(1);
		System.out.println("i1:" + i1);
		
		Iterator<Integer> it2 = lists2.iterator();
		
		for(i=0;i<lists2.size();i++) {
			
			Integer i2 = lists2.get(i);
			System.out.print(i2);
			
		}
		
		while(it2.hasNext()) {
			
			Integer i2 = it2.next();
			System.out.println(i2);
			
		}
		
		
		
		System.out.println("============================");

		System.out.print("이름:");
		String name = sc.next();
		int index4;
		boolean flag = false;
		
		for(i=0;i<lists.size();i++) {
			
			if(name.equals(lists.get(i))) {
				System.out.println("가입한 회원입니다.");
				flag = true;
				break;
			}
			
		}
		if(flag == false) {
			
			System.out.println("가입하지 않은 회원입니다.");
			lists.add(name);
		}
		


		index4 = lists.indexOf(name);
		if(index4 == -1) {

			System.out.println("가입하지 않은 회원입니다.");
			
		}else {
			
			System.out.println("가입한 회원입니다.");
			
		}

		boolean result2 = lists.contains(name);
		if(result2 == false) {
			
			System.out.println("가입하지 않은 회원입니다.");
			
		}else {
			
			System.out.println("가입한 회원입니다.");
		}
 
		
		
	}

}
