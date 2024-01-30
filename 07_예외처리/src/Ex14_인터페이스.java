interface Copymachine {
	
	void copy();
	default void abc() { // default 들어간 메서드는 interfave에서만
	
		System.out.println("abc");
		
	}
	
	static void xyz() { // default 들어간 메서드는 interfave에서만
		
		System.out.println("xyz");
		
	}
	
}

class Ex1 implements Copymachine {
	
	static int i;
	@Override
	public void copy() {

		
		
	}
	
	@Override
	public void abc() {
	
		System.out.println("abc---");
		
	}
	
}

class Ex2 implements Copymachine {
	
	@Override
	public void copy() {
		
		
		
	}
	
}

class Ex3 implements Copymachine {
	
	@Override
	public void copy() {
		
		
		
	}
	
}


public class Ex14_인터페이스 {

	public static void main(String[] args) {

		Ex1 i;
		Ex1 ex1 = new Ex1();
		ex1.abc();
		
		Ex2 ex2 = new Ex2();
		ex2.abc();
		
		Copymachine.xyz();

	}

}
