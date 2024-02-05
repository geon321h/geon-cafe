import java.awt.Container;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Movie {
	
	private String title;
	private int age;

	public Movie(String title, int age) {
	
		super();
		this.title = title;
		this.age = age;
		
	}

	public String getTitle() {
		
		return title;
	
	}
	
	public void setTitle(String title) {
	
		this.title = title;
	
	}
	
	public int getAge() {
	
		return age;
	
	}
	
	public void setAge(int age) {

		this.age = age;
	
	}
	
	public String toString() {
		
		return title + "/" + age;
		
	}
	
}

public class Ex11_HashMap {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Map<String, Movie> hm  = new HashMap<String, Movie>();
		Movie m1 = new Movie("노량", 12);
		Movie m2 = new Movie("어벤져스", 7);
		Movie m3 = new Movie("스파이더맨", 19);
		
		hm.put("CGV", m1);
		hm.put("메가박스", m2);
		hm.put("롯데시네마",new Movie("스파이더맨", 19));
		
		System.out.println("hm:" + hm);
		
		System.out.print("영화관 입력:");
		String theater = sc.next();
		
		if(hm.containsKey(theater) == true) {
			
			System.out.println(theater + ":" + hm.get(theater));
			
		}else { 
			
			System.out.println("해당 영화관은 없습니다.");
			
		}
	
		boolean result = hm.isEmpty();
		System.out.println("result:" + result);

		Movie m = hm.remove("CGV2");
		if(m == null) {
			
			System.out.println("삭제실패");
			
		}else {
			
			System.out.println("삭제성공");
			
		}
		System.out.println("hm:" + hm);

		hm.clear();
		System.out.println("hm:" + hm);

	}

}







