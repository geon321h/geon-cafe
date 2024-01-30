class Test {

	int x =2;
	
	public void display() {
		
		System.out.println("Test");
		System.out.println("x:" + x);
		
	}
	
}

class Test2 extends Test{
	
	public void display() {
		
		System.out.println("Test2");
		System.out.println("x:" + x*x);
		
	}
	
}

public class Ex11_익명클래스 {

	public static void main(String[] args) {

		Test t = new Test();
		t.display();
		System.out.println();
		
		Test2 t2 = new Test2();
		t2.display();
		System.out.println();

		// 익명 클래스 //
		
		new Test() {

			public void display() {
				
				System.out.println("Test3");
				System.out.println("x:" + x*x*x);
				
			}
			
		}.display();;
		
	}

}
