interface Copymachine {

	 void copy(); // public abstract
	 int age = 30; // final
	
}

interface Printmachine {
	
	void print();
	
}

interface Faxmachine {
	
	void fax();
	
}

class Compound implements Copymachine, Printmachine, Faxmachine { // 인터페이스 상속
		
	public void copy() {
		
		System.out.println("복사한다");
		
	}

	public void print() {
		
		System.out.println("프린트한다");
		
	}
	public void fax() {
		
		System.out.println("팩스보낸다");
		
	}
	
}

public class Ex14_인터페이스 {

	public static void main(String[] args) {

		// Copymachine c = new Copmachine();
		Compound c = new Compound();
		
		Faxmachine c2 = new Compound();
		c2.fax();
		
		
	}

}
