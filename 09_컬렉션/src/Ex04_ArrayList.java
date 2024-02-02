import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Person {
	
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String toString() {

		return name+"/"+age;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}

public class Ex04_ArrayList {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		// 배열로 객체 리스트에 넣기 // 
		
		int i;
		Person[] arr = new Person[3];
		arr[0] = new Person("제니",30);
		arr[1] = new Person("지수",40);
		arr[2] = new Person("로제",50);
		
		ArrayList<Person> lists = new ArrayList<Person>();
		
		for(i=0;i<arr.length;i++) {
			
			lists.add(arr[i]);
			
		}

		lists.add(new Person("로사", 60));
		Person x = lists.get(0);
		System.out.println("x:" + x);
		System.out.println("lists:" + lists);
		
		// 리스트 출력하기 //
		
		for(i=0;i<lists.size();i++) {
			
			Person p = lists.get(i);
			System.out.println(p);
			
		}
		
		Iterator<Person> it_p = lists.iterator();
		
		while(it_p.hasNext()) {
			
			Person p = it_p.next();
			System.out.println(p);
			
		}
		
		// 이름 검색하기 //
		
		boolean flag=false;
		
		System.out.print("이름:");
		String name = sc.next();
		for(i=0;i<lists.size();i++) {
			
			Person p = lists.get(i);
			if(p.getName().equals(name)) {
				
				System.out.println(p.getName() + "의 나이는 " + p.getAge());
				flag=true;
				
			}
			
		}
		
		if(flag == false) {

			System.out.println("찾는 이름이 없습니다.");
			
		}
		
		// 이름 삭제하기 //
		
		flag=false;
		System.out.print("삭제할이름:");
		String delName = sc.next();
		
		for(i=0;i<lists.size();i++) {

			Person p = lists.get(i);
			if(p.getName().equals(delName)) {

				lists.remove(i);
				flag=true;

			}

		}
		
		if(flag == false) {

			System.out.println("찾는 이름이 없습니다.");
			
		}else {
			
			System.out.println("남은 lists: " + lists);
			
		}
		
		
		
	}

}
