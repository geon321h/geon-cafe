class Person{
	String name; // 인스턴스 변수
	int age;
	double height;
	static String nation;
}

public class Ex01_클래스 {

	public static void main(String[] args) {

		int a=30; // 자료형, type
		double b=178.3;
		String c="아이유";
		Person.nation = "대한민국";
		
		Person p = new Person(); // 객체(인스턴스)를 생성한다. (p참조변수에 참조값이 들어감)
		 
		System.out.println("p:" + p);
		p.name="윤아";
		p.age=40;
		p.height=162.8;
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(p.height);
		System.out.println(p.nation);
		
		Person p1 = new Person(); 

		p1.name="정국";
		p1.age=50;
		p1.height=187.2;
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(p.height);
		System.out.println(p.nation);
		
	}

}

/*
	- 클래스란? -
	여러가지 데이터를 담을수있는 데이터타입을 직접 만들수있다.
	클래스는 사용자가 정의한 자료형이다.
	클래스의 변수는 객체라 불리며 생성시 참조변수에 객체의 주소가 들어간다.
	
 	특수문자는 _(언더바)만 가능 
 	숫자로 시작하지 않는다.
 	대/소문자 구분한다.
	
*/