class Book2 {

	private String title;
	private int price;
	
	
	Book2() {
		title = "java";
		price = 1000;
	}
	
	Book2(String title, int price) {
		this.title	= title;
		this.price = price;
	}
	
	void display() {
		
		System.out.println("title: " + title);
		System.out.println("price: " + price);
		System.out.println("------------------");
		
	}
	
}

public class Ex18_객체배열 {

	public static void main(String[] args) {

		// 배열을 만드는 3가지 방법 //
		
		int[] a1 = new int[]{10,20,30};
		
		int[] a2 = {10,20,30};
		
		int[] a3 = new int[3];
		a3[0] = 10;
		a3[1] = 20;
		a3[2] = 30;
		
		Book2 b1 = new Book2();
		Book2 b2 = new Book2("JSP", 2000);
		Book2 b3 = new Book2("Spring", 3000);
		
		// Book2[] bk = {new Book2(), new Book2("JSP", 2000), new Book2("Spring", 3000)};
		
		Book2[] bk = new Book2[3];
		bk[0]=	new Book2();
		bk[1]=	new Book2("JSP", 2000);
		bk[2]=	new Book2("Spring", 3000);
		
		bk[0].display();
		bk[1].display();
		bk[2].display();
		
		for(int i=0;i<bk.length;i++) {
			
			bk[i].display();
			
		}
		
	}

}
