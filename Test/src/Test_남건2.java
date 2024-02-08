import java.util.ArrayList;
import java.util.Scanner;

class Product_ng {

	private String code;
	private int price;
	
	public Product_ng() {
		
	}
	
	public Product_ng(String code, int price) {
		this.code = code;
		this.price = price;
	}

	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
}

class Book_ng extends Product_ng {
	
	Scanner sc = new Scanner(System.in);
	
	private String title;
	private String author;
	
	public Book_ng() {
		
	}
	
	public Book_ng(String code, int price, String title, String author) {
		
		super(code, price);
		this.title = title;
		this.author = author;
	
	}
	
	public Book_ng input() {
		
		System.out.print("코드 : ");
		setCode(sc.next());
		System.out.print("가격 : ");
		setPrice(sc.nextInt());
		System.out.print("책 제목 : ");
		title = sc.next();
		System.out.print("저자 : ");
		author = sc.next();
		
		return new Book_ng(getCode(),getPrice(),title,author);
		
	}
	
	public void listAll(ArrayList<Book_ng> lists) {
		
		for(Book_ng a : lists) {
			
			System.out.println(a);
			
		}
		
	}
	
	public void search(ArrayList<Book_ng> lists) {
		
		String searchInput;
		boolean flag = false;
		
		System.out.print("찾는 제목: ");
		searchInput = sc.next();
		
		for(Book_ng a : lists) {
			
			if (searchInput.equals(a.title)) {
				
				System.out.println(a.getCode() + "," + a.getPrice() + "," + a.author);
				flag = true;
				
			}
			
		}
		
		if(flag == false) {
			
			System.out.println("찾는 이름 없음");
			
		}
		
	}
	
	public boolean retry() {
		
		String reInput;
		
		System.out.print("계속(y|n)?");
		reInput = sc.next();
		
		if(reInput.equals("y")) {
			
			return true;
			
		}else if(reInput.equals("n")) {
			
			return false;
			
		}else {
			
			System.out.println("y혹은 n을 입력해주세요.");
			return retry();
			
		}
		
	}
	
	public String toString() {
		
		return getCode() + "," + getPrice() + "," + title + "," + author;
		
	}
	
}


public class Test_남건2 {

	public static void main(String[] args) {

		Book_ng bk = new Book_ng();
		
		ArrayList<Book_ng> lists = new ArrayList<>();
		
		System.out.println("----------------------");
		System.out.println("책 입력 구간");
		System.out.println("----------------------");
		while (true) {
			
			lists.add(bk.input());
			
			if(bk.retry() == false) {
				break;
			}
			
		}
		
		System.out.println("----------------------");
		System.out.println("ArrayList 사용한 결과");
		System.out.println("----------------------");
		bk.listAll(lists);
		System.out.println("----------------------");
		System.out.println("검색 구간");
		System.out.println("----------------------");
		
		while (true) {
			
			bk.search(lists);
			
			if(bk.retry() == false) {
				break;
			}
			
		}
		System.out.println("----------------------");
		System.out.println("프로그램을 종료합니다.");
		System.out.println("----------------------");
		
		
	}

}

// 2:45 1번만 메일로 보내기
// 4가지 넣고 게속할지 반복
// ArrayList 사용한 결과 후 리스트 출력
// 찾는이름 찾는 제목입력시 코드 가격 저자 나옴 게속할지 반복









