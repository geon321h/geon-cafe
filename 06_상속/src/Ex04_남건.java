class Product {
	
	private String code;
	private String company;
	
	Product() {
	
	}
	
	Product(String code, String company) {
	
		this.code = code;
		this.company = company;
		
	}
	
	void display(){
		
		System.out.println("코드: " + code);
		System.out.println("회사명: " + company);
		
	}
	
}

class Computer extends Product{

	// private String code;
	// private String company;
	private String os;
	private int ram;
	
	Computer(String code, String company, String os, int ram) {
	
		super(code,company);
		this.os = os;
		this.ram = ram;
		
	}
	
	void display(){
		
		super.display();
		System.out.println("운영체제: " + os);
		System.out.println("램: " + ram + "기가");
		System.out.println("----------------");
		
	}
	
}

class Book extends Product{
	
	// private String code;
	// private String company;
	private String title;
	private	String author;
	
	Book(String code, String company, String title, String author) {
		
		super(code,company);
		this.title = title;
		this.author = author;
		
	}

	void display(){
		
		super.display();
		System.out.println("책제목: " + title);
		System.out.println("저자: " + author);
		System.out.println("----------------");
		
	}
	
}

public class Ex04_남건 {

	public static void main(String[] args) {

		Computer c = new Computer("C01","삼성","window10",16	);
		Book b = new Book("B02","쌍용출판사","자바","웬디");
				
		c.display();
		b.display();
		
	}

}
