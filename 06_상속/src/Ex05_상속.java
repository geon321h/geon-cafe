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

		Person2 p = new Person2("태형",50);
		p.display();
		System.out.println();
		
		Employee2 e =new Employee2("현아",30,"현대","연구부");
		e.display();
		System.out.println();
		
		Teacher t = new Teacher("태연",40,"쌍용고","생활지도부","음악");
		t.display();
		System.out.println();
		
		Person2[] p_arr = new Person2[3];
		p_arr[0] = p;
		p_arr[1] = e;
		p_arr[2] = t;
		
		for(Person2 a : p_arr) {
			
			a.display();
			System.out.println();
			
		}
		
	}

}
