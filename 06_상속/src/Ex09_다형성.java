class Animal	{
	
	public	void bark() {
		
		System.out.println("bark bark");
		
	}
	
}

class Dog extends Animal {
	
	public void bark() {
		
		System.out.println("멍멍");
		
	}
	
}

public class Ex09_다형성 {

	public static void main(String[] args) {

		int i= (int)3.2; // 강제형변환 (강제캐스팅)
		double  j = 3; // (double)3
		
		Animal a = new Animal();
		a.bark(); // Animal
		
		Dog d = new Dog();
		d.bark(); // Dog
		
		Animal a2 = new Dog(); // 다형성 , 자동으로 업캐스팅됨
		// Animal a2 = (Animal)new Dog(); // 자동형변환( 자식 -> 부모) 업캐스팅 
		a2.bark(); // Animal 
		
		
	}

}
