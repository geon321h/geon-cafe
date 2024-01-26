class Person {
	
	protected String name;
	protected int age;
	
	Person() {
		
	}
	
	Person(String name, int age) {
		
		this.name = name;
		this.age = age;
		return; // 숨어있음
		
	}
	
	void display() {
		
		System.out.println("이름:" + name);
		System.out.println("나이:" + age);
		System.out.println("-----------------");
		
	}
	
}

class Student extends Person {

	// private String name;
	// private int age;
	private int kor;
	private int eng;

	Student() {

		super(); // 부모 생성자{Person()}를 호출해라 , 자동으로 생성되는 문장
		
	}
	
	Student(String name, int age, int kor, int eng) {
		
		// this.name =name; 에러가 나는 이유: 부모클래스가 private면 자식클래스에서도 변수를 사용할 수 없음
		super(name,age);
		this.kor = kor;
		this.eng = eng;
		
	}
	
	void display() { // 재정의 (overriding)
		
		System.out.println("이름:" + super.name);
		System.out.println("나이:" + super.age);
		System.out.println("국어점수:" + kor);
		System.out.println("영어점수:" + eng);
		System.out.println("-----------------");
		
	}
	
} // Student

class Employee extends Person{

	// private String name;
	// private int age;
	String company;
	String part;
	
	Employee() {

		super();
		
	}
	
	Employee(String name, int age, String company, String part){
		
		super(name,age);
		this.company = company;
		this.part = part;
		
	}
	
	void display() {
		
		System.out.println("이름:" + super.name);
		System.out.println("나이:" + super.age);
		System.out.println("국어점수:" + company);
		System.out.println("영어점수:" + part);
		System.out.println("-----------------");
		
		
	}
	
} // Employee

public class Ex03_상속 {

	public static void main(String[] args) {

		Person p = new Person("효연",20);
		Student s = new Student("윤아",50,77,89);
		Employee e = new Employee("송중기",30,"삼성","연구부");
		
		p.display();
		s.display();
		e.display();
		
	}

}








