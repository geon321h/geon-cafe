class Person3 {
	
	String name;
	int age;
	
	Person3(String name, int age) {
		
		this.name = name;
		this.age = age;
		
	}
	
	void display() {
		System.out.println(name + " " + age);
	}
	
}

class Student3 {
	
	int kor;
	int eng;
	
	Person3 p; // 참조변수 기본값 null
	
	Student3(String name, int age, int kor, int eng) {

		p = new Person3(name,age);
		this.kor = kor;
		this.eng = eng;
	
	}
	
	void display() {
		
		System.out.println(p.name + " " + p.age);
		System.out.println(kor + " " + eng);
		
	}	
	
}

public class Ex06_포함 {

	public static void main(String[] args) {

		Student3 s = new Student3("kim",30,88,99);
		
		s.display();
		
	}

}
