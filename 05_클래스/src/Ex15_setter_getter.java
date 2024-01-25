import java.util.Scanner;

class Book {
	
	private String title;
	private String author;
	private int price;
	
	Book() {
		title = "토지";
		author = "박경리";
		price = 5000;
	}
	
	Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	void display( ) {

		System.out.println("책 제목: " + title);
		System.out.println("책 저자: " + author);
		System.out.println("책 가격: " + price + "원");
		System.out.println("-------------------------------");
		
	}
	
	void setTitle(String title) {
		
		this.title = title;
		
	}
	
	void setAuthor(String author) {
		
		this.author = author;
		
	}
	
	void setPrice(int price) {
		
		if(price>0) {
			this.price = price;
		}
		
	}
	
	String getTitle() {
		
		return title;
		
	}
	
	String getAuthor() {
		
		return author;
		
	}
	
	int getPrice() {
		
		return price;
		
	}
	
}

public class Ex15_setter_getter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 책 입력받고 출력하기 //
		
		Book b = new Book();

		// 객체에 값을 넣어 출력 //
		
		System.out.print("책 제목을 입력하세요>>");
		b.setTitle(sc.nextLine());
		System.out.print("책 저자를 입력하세요>>");
		b.setAuthor(sc.next());
		System.out.print("책 가격을 입력하세요>>");
		b.setPrice(sc.nextInt());
		System.out.println("-------------------------------");
		// System.out.println("책 제목: " + b.getTitle());
		// System.out.println("책 저자: " + b.getAuthor());
		// System.out.println("책 가격: " + b.getPrice() + "원");
		b.display();
		
		// 생성자에 기본적으로 있는 값 출력 //
		
		Book b2 = new Book();
		b2.display();
		
		// 값을 직접 입력받는 생성자를 이용하여 값 출력 //
		
		Book b3 = new Book("아리랑", "조성래", 4000);
		b3.display();
	
	}

}
