import java.util.ArrayList;
import java.util.Scanner;

class Card {
	
	Scanner sc = new Scanner(System.in);

	private String name;
	private String tel;
	
	boolean flag;
	
	public Card() {
		
	}
	
	public Card(String name, String tel) {
		
		super();
		this.name = name;
		this.tel = tel;
		
	}
	
	public Card input() { // 명함 입력 메서드
		
		System.out.print("이름을 입력하세요:");
		name = sc.next();
		System.out.print("전화번호를 입력하세요:");
		tel = sc.next();
		
		return new Card(name, tel); // 객체를 반환하여 list에 넣기
		
	}
	
	public void delete(ArrayList<Card> lists) { // 명함제거 메서드
		
		flag = false;
		System.out.print("삭제할이름:");
		String deleteName = sc.next();
		
		for(int i=0;i<lists.size();i++) {

			if(lists.get(i).getName().equals(deleteName)) {

				lists.remove(i);
				System.out.println("삭제하였습니다.");
				flag = true;
				
			}

		}
		if(flag == false) {
			
			System.out.println("이름을 잘못입력하셨습니다.");

		}
		
	}
	
	public void update(ArrayList<Card> lists) { // 수정 메서드
		
		flag = false;
		System.out.print("이름을 입력하세요:");
		String updateName = sc.next();
		
		for(int i=0;i<lists.size();i++) {

			Card c = (Card) lists.get(i);
			if(c.getName().equals(updateName)) {

				System.out.print("수정하실 전화번호는:");
				String updateTel = sc.next();
				lists.set(i, new Card(c.getName(), updateTel));
				System.out.println("수정되었습니다.");
				flag = true;
				
			}

		}
		if(flag == false) {
			
			System.out.println("이름을 잘못입력하셨습니다.");

		}
		
	}
	
	public String getName() { // 이름 반환 메서드
		
		return name;
		
	}
	
	public String toString() { // 출력 방법 변경

		return name+"\t\t\t"+tel;

	}
	
}

public class Ex05_남건 {

	public static void main(String[] args) {

		// 1. 명함추가 2. 명함삭제 3. 명함수정 4.명함보기 5.종료
		// 올바른 입력인지 판별
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Card> lists = new ArrayList<Card>();
		Card c = new Card();
		
		int num,i=0;
		
		do {
			
			System.out.println("1.명함추가\t2.명함삭제\t3.명함수정\t4.명함보기\t5.종료");
			num = sc.nextInt();
			
			switch (num) {
			case 1: lists.add(c.input());
				break;
			case 2: c.delete(lists);
				break;
			case 3: c.update(lists);
				break;
			case 4: System.out.println("이름\t\t\t전화번호");
						for(i=0;i<lists.size();i++) {

							System.out.println(lists.get(i));

						}
						break;
			case 5:	System.out.println("프로그램을 종료합니다.");
						System.exit(0);
			default: System.out.println("1~5만 가능합니다.");	
			}
			i++;
		}while(true);
		
	}

}
