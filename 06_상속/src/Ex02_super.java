class Parent {
	
	int x = 10;
	
	void method() {
		System.out.println("Parent x:" + x);
	}
	
}

class Child extends Parent	{
	
	int x = 20; // 멤버변수
	
	void method() { // 부모가 물려준 메서드보다 본인이 만든 메서드가 우선순위가 높다.
		
		int x =30; // 지역변수
		System.out.println("x:" + x);
		System.out.println("this.x" + this.x);
		System.out.println("super.x" + super.x);
	
	}
	
}

public class Ex02_super {

	public static void main(String[] args) {

		Parent p = new Parent();
	
		p.method();
		System.out.println();
	
		Child c = new Child();
		
		c.method();
		
	}

}
