class Sports {

 	String name;
	int inwon; // 인원수
	
} // Sports

class Baseball extends Sports { // class 자식(하위) 클래스 extends 부모(상위) 클래스

	// String name;
	// int inwon; // 인원수
	double ta; // 타율
	
	Baseball(String name, int inwon, double ta) {
		this.name = name;
		this.inwon = inwon;
		this.ta = ta;
	}
	
	void display() {
		
		System.out.println("게임명: " + name);
		System.out.println("인원수: " + inwon);
		System.out.println("타율: " + ta);
		System.out.println("------------------");

	}
	
} // Baseball

class Football extends Sports {
	
	// String name;
	// int inwon;
	int goal;
	
	Football(String name, int inwon, int goal) {
		this.name = name;
		this.inwon = inwon;
		this.goal = goal;
	}
	
	void display() {
		
		System.out.println("게임명: " + name);
		System.out.println("인원수: " + inwon);
		System.out.println("타율: " + goal);
		System.out.println("------------------");
		
	}
	
} // Football

public class Ex01_상속 {

	public static void main(String[] args) {

		Baseball bb = new Baseball("야구",9,0.235);
		bb.display();

		Football fb = new Football("축구",11,6);
		fb.display();
		
	}

}










