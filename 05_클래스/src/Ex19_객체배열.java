import java.util.Scanner;

class Member2 {
	
	private String id;
	private String pw;
	
	Member2(){
		id = "id";
		pw = "passward";
	}

	Member2(String id, String pw){
		this.id = id;
		this.pw = pw;
	}
	
	void show() {
	
		System.out.println("id:" + id);
		System.out.println("pw:" + pw);
		System.out.println("---------------");
		
	}
	
}

public class Ex19_객체배열 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int i;
		String id,pw;
		
		Member2[] member = new Member2[3];
		// member[0] = new Member2("abc","123");
		// member[1] = new Member2("geon","qwer1234");
		// member[2] = new Member2();
		
		for(i=0;i<member.length;i++) {
			
			System.out.print("id 입력:");
			id = sc.next();
			System.out.print("pw 입력:");
			pw = sc.next();
			
			member[i] = new Member2(id,pw);
			
		}
		
		for(Member2 a : member) {
			a.show();
		}
		
		for(i=0;i<member.length;i++) {
			member[i].show();
		}
		
	}

}






