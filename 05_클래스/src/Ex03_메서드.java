
public class Ex03_메서드 { 

	public static void main(String[] args) { // main 메서드 정의

		System.out.println("기상");
		System.out.println("세수");

		meal();
		
		System.out.println("집청소");
		System.out.println("독서");
		
		meal();

		System.out.println("TV");		
		
		meal();
		
		System.out.println("취침");

		
	} // main

	public static void meal() { // 메서드(method) 정의
				
		// 특정한 작업을 반복적으로 필요할때마다 호출하여 사용할 수 있다.
		System.out.println("식탁닦기");
		System.out.println("수저놓기");
		System.out.println("밥,국,반찬 세팅");
		System.out.println("먹고 설겆이");
		
	} // meal
	
} // class
