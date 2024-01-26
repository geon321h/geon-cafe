/*class Person2 {
	
	private String name;
	private int age;
	 
	Person2(){
		
	}
	
	Person2(String name, int age){
		
		this.name = name;
		this.age = age;
		
	}
	
	void display() {
		
		System.out.println("이름: " + name);
		System.out.println("나이: " + age);
		
	}
	
}*/
import com.javastudy.Person2;

class Employee2 extends Person2 {
	
	private String compart;
	private String part; 
	
	Employee2() {
	
		super();
		
	}
	
	Employee2(String name, int age, String compart, String part){
		
		super(name,age);
		this.compart = compart;
		this.part = part;
		
	}

	public void display() { // overridig시 상위 클래스의 접근제어자와 동일해야함
		
		super.display();
		System.out.println("직장명: " + compart);
		System.out.println("담당부서: " + part);
		
	}
	
}

class Teacher extends Employee2 { // 한번에 다중상속은 안되지만 차례로 상속을 받을수 있다.
	
	private String subject;
	
	Teacher(String name, int age, String compart, String part, String subject) {
		
		super(name,age,compart,part);
		this.subject = subject;
		
	}

	public void display() {
		
		super.display();
		System.out.println("담당과목: " + subject);
		
	}
	
}


public class Ex05_상속 {

	public static void main(String[] args) {

		
		Teacher t = new Teacher("태연",40,"쌍용고","생활지도부","음악");
		
		t.display();
		
	}

}
