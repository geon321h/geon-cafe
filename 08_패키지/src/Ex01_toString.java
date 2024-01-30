class Student extends Object {
	
	private String name;
	private int hakbun;
	
	
	
	public Student() {

	}

	public Student(String name, int hakbun) {
	
		this.name = name;
		this.hakbun = hakbun;
	
	}
	
	void abc() {
		
		
	}
	
	public String toString() {
		
		return name + "," + hakbun;
		
	}
	
	public boolean equals(Object obj) { // obj : s2참조값 (Student this, 받는값2 )

		if(obj instanceof Student) { 
			
			Student s = (Student)obj;
			return this.hakbun == s.hakbun; // 학번이 같으면 true, 다르면 false
			
		}else {
			
			return false; 
			
		}
		
	}
	
}

public class Ex01_toString {

	public static void main(String[] args) {

		int i;
		
		Student s1 = new Student("장동건",2000);
		Student s2 = new Student("장동건",2000);
	
		System.out.println(s1);
		String s = s1.toString();
		System.out.println(s);
		System.out.println(s1.toString());
		System.out.println(s2);
		System.out.println(s2.toString());
		
		boolean b = s1.equals(s2); // Object obj = new Student("장동건",2000);
		System.out.println("b:" + b);
		
	}

}

// java.lang : System, Math, String, NullPointException	
// java.utill : Scanner, InputMismatchException 