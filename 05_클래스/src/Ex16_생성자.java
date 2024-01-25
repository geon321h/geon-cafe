import java.util.Scanner;

class Member {
	
	private String id;
	private String passwd;
	
	Member(){ // 생성자: 클래스와 이름이 같은 메서드
			  // 리턴타입이 없고 void도 쓰지않는다.
			  // 객체를 만들면 자동으로 생성된다.
		System.out.println("Member 생성자");
		id = "kim";
		passwd = "1234";
		
	}
	
	Member(String a, String b){
		
		id = a;
		passwd = b;
		System.out.println("Member(String a, String b) 생성자");
		
	}

	void setId(String id) {
		this.id = id;
	}
	
	void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	String getId() {
		return id;
	}
	
	String getPasswd() {
		return passwd;
	}
	
}

public class Ex16_생성자 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Member m = new Member();
		
		// 객체를 생성하고 값을 넣는 방법 //
		
		System.out.print("아이디를 입력하세요: ");
		m.setId(sc.next());
		System.out.print("비밀번호를 입력하세요: ");
		m.setPasswd(sc.next());
		
		System.out.println("아이디: " + m.getId());
		System.out.println("비밀번호: " + m.getPasswd());
		
		// 값을 받는 생성자를 이용하여 값을 넣는 방법 //
		
		Member m2 = new Member("a","b");
		Member m3 = new Member();
		System.out.println("아이디: " + m2.getId());
		System.out.println("비밀번호: " + m2.getPasswd());
		
		// 생성자에 있는 기본 값을 받는 방법 //
		
		System.out.println("아이디: " + m3.getId());
		System.out.println("비밀번호: " + m3.getPasswd());
		
	}

}






