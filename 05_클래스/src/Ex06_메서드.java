class Fluit	{
	
	void apple() {
		System.out.println("apple");
	}
	
	static void banana() {
		System.out.println("banana");
	}
	
}
public class Ex06_메서드 {

	public static void main(String[] args) {

		Fluit f = new Fluit();
		Ex06_메서드 m = new Ex06_메서드();
		
		f.apple();
		f.banana();
		Fluit.banana();
		m.orange();
		m.melon();
		orange();
		melon();
		
	} // main

	static void orange() {
		System.out.println("orange");
	}

	static void melon() {
		System.out.println("melon");
	}
	
}





