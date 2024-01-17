
public class Ex02_정수형 {
	
	public static void main(String[] args) {
		
		System.out.println(10);
		System.out.println(20);
		
		//a,b저장소(변수)의 용도 
		int a; //선언
		int b; //선언
		b = 20; //초기화
		a = 10; //초기화
		int c =30; //선언+초기화
		int banana = 100;
		
		System.out.println("a");
		System.out.println(a);
		System.out.println("b"); // ""안의 것이 그대로 나옴
		System.out.println(b);
		System.out.println(c);
		System.out.println("banana");
		System.out.println(banana);
		//System.out.println(d); // d cannot be resolved to a variable
		
		System.out.println("a=" + a + " 입니다."); // a=10 입니다.
		System.out.println("banana변수의 값은 " + banana + "입니다." ); // banana변수의 값은 100입니다.
		banana = 300;
		banana = 700;
		System.out.println("banana변수의 값은 " + banana + "입니다." ); // banana변수의 값은 700입니다.
		banana = 900;
		
		/*
		 정수 자료형(type) 
		 byte : 1byte -128 ~ 127
		 short: 2byte -32768 ~ 32767
		 int: 4byte -21억 ~ 21억
		 long: 8byte -900경 ~ 900경  
		*/
		
		byte b1 = 10;
		byte b2 = 20;
		int b3;
		b3 = b1+b2; // b3 = 10 + 20; 
		System.out.println(b3);
		
		/*
		 자동 형변환
		 byte + byte = int
		 byte + short = int
		 short + byte = int
		 short + short = int
		 int + int = int
		*/
		
		int x = 1000000; // 4byte
		int y = 2000000; // 4byte
		long z = x * (long)y; //2조 8byte * 4byte = 8byte(long) 강제 형변환
		System.out.println("z=" + z);
		
	} // main 메서드의 끝

} // class의 끝

/*
 변수(저장소) 이름 작성하는 방법
 소문자로 시작
 특수문자는 _(언더바)만 가능 
 숫자로 시작하지 않는다.
 대/소문자 구분한다.
*/
