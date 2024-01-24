
public class Ex04_메서드 {

	public static void main(String[] args) {

		int a,b,result;
		a=10;
		b=20;
		
		hap(a,b); // 호출, 메서드명([전달인자]);
		hap(11,22);
		hap(100,200);
		result = cha(a,b);
		
		System.out.println("두 수의 차:" + result);
		
	}// main

	public static void hap(int x, int y) { // hap 메서드 정의 // void 아무것도 가져가지않는 상태
		
		System.out.println("합계:" + (x + y));
		return;
		
	}
	
	private static int cha(int x, int y) { // 리턴타입 메서드명 , int x - 매개변수 : 호출할때 받아오는 값은 저장해두는 변수
		
		// System.out.println("차:" + (x - y));
		int z = x-y;
		return z; // -10
		
	}
	
}
