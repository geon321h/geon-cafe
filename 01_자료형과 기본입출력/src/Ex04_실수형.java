
public class Ex04_실수형 {

	public static void main(String[] args) {
		
		double d1 = 1.234;
		System.out.println("d1 = " + d1);
		
		double d2 = 0.12300;
		System.out.println("d2 = " + d2);
		
		double d3 = 0.123E-2; // E-2 가 10의 -2승이기에 0.00123으로 출력
		System.out.println("d3 = " + d3);
				
		double d4 = 1.123456789123456789; // 15번째 자리로 8이 반올림되어 1.1234567891234568로 출력
		System.out.println("d4 = " + d4);
		
		float ft1 = 1.234f; // f: float(4byte)형 숫자표기 안할시 double로 입력되어 들어가지않음
		System.out.println("ft1 = " + ft1);
		
		float ft2 = 1.123456789123456789f; // 8번째 자리로 9가 반올림되어 1.1234568로 출력
		System.out.println("ft2 = " + ft2);
		
		float ft3 = 123; // 123.0
		System.out.println("ft3 = " + ft3);
		
		int a = (int)123.756f; // float > int 이므로 강제 형변환을 통해야함 대신 123만 들어감
		System.out.println("a = " + a);
		
	}
	
}

/*
 double: 8byte
 float: 4byte
*/
