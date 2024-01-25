class Person2{
	
	private String name;
	private int age;
	private double height;
	
	void setName(String name){
		this.name = name;
	}
	
	void setAge(int age) {
		if(age>0) { // 변수를 private해두고 set메서드에서 점검하고 출력 가능 - 안정성 증가			
			this.age = age;
		}
	}

	void setHeight(double height) {
		this.height = height;
	}

	String getName(){
		return name;
	}
	
	int getAge(){
		return age;
	}
	
	double getHeight(){
		return height;
	}
	
}

public class Ex14_setter_getter {

	public static void main(String[] args) {

		Person2 p = new Person2(); // 객체(인스턴스) 생성 => 공간 생성
		// p.name = "웬디";
		// p.age = 30;
		// p.height = 167.4;
		p.setName("웬디");
		p.setAge(30);
		p.setHeight(167.4);
		
		// System.out.println(p.name);
		// System.out.println(p.age);
		// System.out.println(p.height);
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getHeight());
		
	}

}






