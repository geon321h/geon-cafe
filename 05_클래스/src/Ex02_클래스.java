class Student{
	String name; // 인스턴스 변수 - 객체를 생성해야만 생성되는 변수
	int kor,eng,math;
	static String school; // 공유자원, static(정적) 변수 - 하나만 존재하지만 여러 객체에서 공유할수있다.
}

public class Ex02_클래스 {

	public static void main(String[] args) {

		String name; // 일반변수
		Student stu = new Student(); // 객체, 인스턴스
		
		stu.name="서현";
		stu.kor=70;
		stu.eng=80;
		stu.math=90;
		//	stu.school="쌍용고"; 
		Student.school="쌍용고";// static 방식으로 접근
		
		System.out.println(stu.name);
		System.out.println(stu.kor);
		System.out.println(stu.eng);
		System.out.println(stu.math);
		System.out.println(stu.school);
		System.out.println("---------------");
		
		Student stu2 = new Student();
		
		stu2.name="박보검";
		stu2.kor=55;
		stu2.eng=76;
		stu2.math=34;
		
		System.out.println(stu2.name);
		System.out.println(stu2.kor);
		System.out.println(stu2.eng);
		System.out.println(stu2.math);
		System.out.println(stu2.school);
		
		
	}

}
