
public class Ex12_Math {

	public static void main(String[] args) {

		int a,b,c;
		a=30;
		b=40;
		
		c = Math.max(a,b); 
		// Math : 자바에서 지원하는 클래스 
		// FIELD : Math안에 변수
		
		System.out.println("c: " + c);
		System.out.println(Math.PI);
		
		c = Math.min(a, b);
		System.out.println("c: " + c);
		
		c = Math.abs(-13);
		System.out.println("c: " + c);
		
	}
	
}
