class Count	{
	
	// static 변수, 인스턴스변수 - int: 0, double: 0.0, boolean: false 로 자동초기화
	static int a; // static 변
	int b; // 인스턴스 변수
	
	void increament()	{
		int c=0; // 지역변수
		a++;
		b++;
		c++;
		System.out.println("static 변수 a:" + a);
		System.out.println("인스턴스 변수 b:" + b);
		System.out.println("지역 변수 c:" + c);
		System.out.println();
	}
	
}


public class Ex08_변수 {

	public static void main(String[] args) {

		int a,b,c;
		
		System.out.println("객체1 생성");
		Count c1 = new Count();
		c1.increament();
		// a=1, b=1, c=1
		
		System.out.println("객체2 생성");
		Count c2 = new Count();
		c2.increament();
		c2.increament();
		// a=3, b=2, c=1
	
		System.out.println("객체3 생성");
		Count c3 = new Count();
		c3.increament();
		c3.increament();
		c3.increament();
		// a=6, b=3, c=1
		
	}

}

// 변수의 종류: 일반 변수, 인스턴스 변수, 클래스 변수, 매개 변수, 참조 변수, static 변수, 지역변수
